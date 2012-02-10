/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app.main;

import com.wrapper.core.jni.JavaCallback;
import com.wrapper.core.jni.OTCallback;
import com.wrapper.core.jni.OTCaller;
import com.wrapper.core.jni.otapi;
import com.wrapper.core.util.Configuration;
import com.wrapper.core.util.Utility;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author cameron
 *
 * Cleanup: FT
 */
public class Load {

    private static Concierge _concierge;
    // These can only happen once per run of the cpplication
    // -FT
    //
    private static boolean s_bLoadedZMQ = false; // So we don't load it multiple times in Windows.
    private static boolean s_bLoadedOTAPI = false; // So we don't load it multiple times.
    private static boolean s_bInitializedOTAPI = false; // So we don't initialize it multiple times.
    private static boolean s_bLoadedWallet = false; // So we don't load the wallet multiple times.
    // -------------------------------------
    private static OneTimeOnly s_OneTime = null;
    // -------------------------------------
    // Do NOT instantiate this until AFTER OTAPI library is loaded
    // and OT_API_INit() is called, but BEFORE LoadWallet() is called.
    //

    public static boolean IsOTLoaded() {
        return s_bLoadedOTAPI;
    }

    public static boolean IsOTInitialized() {
        return s_bInitializedOTAPI;
    }

    public static boolean IsOTWalletLoaded() {
        return s_bLoadedWallet;
    }

    Load(Concierge concierge) {
        _concierge = concierge;
    }

    public void attempt() throws LoadMoneyChangerException {
        try {
            System.out.println(_concierge.getConfig().getOTPath());
            Load.loadOTAPI(_concierge.getConfig().getOTPath());
            System.out.println(_concierge.getConfig().getUserDataPath());
            System.out.println(_concierge.getConfig().getWalletFilename());
            Load.loadAppData(_concierge.getConfig().getUserDataPath(), _concierge.getConfig().getWalletFilename());
            System.out.println(_concierge.getConfig().getTimeOut());
            Load.setTimeout(_concierge.getConfig().getTimeOut());
            Utility.setSettingsObj(_concierge.getDialogOwner());
        } catch (ApiNotLoadedException e) {
            StringBuilder error = new StringBuilder();
            error.append("Unable to load your Java Path!");
            error.append(System.getProperty("line.separator"));
            error.append(e.getError());
            throw new LoadMoneyChangerException(error.toString());
        } catch (AppDataNotLoadedException e) {
            StringBuilder error = new StringBuilder();
            error.append("Loading your MoneyChanger user data failed; Please Choose the correct location:");
            error.append(e.getError().replace(":", System.getProperty("line.separator")));
            throw new LoadMoneyChangerException(error.toString());
        } catch (InvalidTimeOutException e) {
            StringBuilder error = new StringBuilder();
            error.append("Auto-Timout is invalid; you should never see this message: please contact us for support!");
            error.append(e.getError());
            throw new LoadMoneyChangerException(error.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="One Time Only">
    private static class OneTimeOnly {

        private static OTCaller s_theCaller = null;
        private static OTCallback s_theCallback = null;
        private static boolean s_bHasHappened = false;

        public OneTimeOnly() {
            System.out.println("OneTimeOnly.OneTimeOnly(): FYI, constructor is called here. Trying to set password callback also...");
            boolean bSuccess = OneTimeOnly.GiveItAShot();
            System.out.println("OneTimeOnly.OneTimeOnly(): Status: " + bSuccess);
        }
        // <editor-fold defaultstate="collapsed" desc="Give It A Shot">

        public static boolean GiveItAShot() {

            // It hasn't happened yet, so let's give it a shot...
            if (false == OneTimeOnly.s_bHasHappened) {

                if ((null != OneTimeOnly.s_theCaller) || (null != OneTimeOnly.s_theCallback)) {
                    System.out.println("OneTimeOnly.GiveItAShot(): ERROR: HOW on earth were the callback objects instantiated already? ERROR.");
                } else {
                    OneTimeOnly.s_theCaller = new OTCaller();
                    OneTimeOnly.s_theCallback = new JavaCallback();

                    if ((null == OneTimeOnly.s_theCaller) || (null == OneTimeOnly.s_theCallback)) {
                        System.out.println("OneTimeOnly.GiveItAShot(): ERROR: Failure instantiating caller or callback objects.");
                        OneTimeOnly.s_theCaller = null;
                        OneTimeOnly.s_theCallback = null;
                    } else {
                        OneTimeOnly.s_theCaller.setCallback(OneTimeOnly.s_theCallback);

                        // bool OT_API_Set_PasswordCallback(OTCaller & theCaller);
                        // Caller _must_ have Callback attached already.
                        //
                        boolean bSuccess = otapi.OT_API_Set_PasswordCallback(OneTimeOnly.s_theCaller);

                        if (false == bSuccess) {
                            System.out.println("OneTimeOnly.GiveItAShot(): FAILED calling OT_API_Set_PasswordCallback(). (Better try again!)");
                            OneTimeOnly.s_theCaller = null;
                            OneTimeOnly.s_theCallback = null;
                        } else {
                            // IF SUCCESS:
                            OneTimeOnly.s_bHasHappened = true; // SUCCESS!

                            System.out.println("OneTimeOnly.GiveItAShot(): SUCCESS setting the password callback.");


                            // Definitely this is the only place these set functions are called.
                            // I also don't see that they are used, except for the same reason this class is
                            // (to maintain the instance...)
                            //
                            Utility.setG_theCallback(OneTimeOnly.s_theCallback);
                            Utility.setG_theCaller(OneTimeOnly.s_theCaller);
                        }
                    }
                }
            } else {
                System.out.println("OneTimeOnly.GiveItAShot(): Password callback is already set. (Skipping and returning true.)");
            }
            return OneTimeOnly.s_bHasHappened;
        }
        // </editor-fold>
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setup Password Callback">

    public static void setupPasswordCallback() {
        // This only happens if the above OT_API_Init() was successful, and it
        // only happens once.
        if (false == Load.IsOTInitialized()) {
            System.out.println("Load.setupPasswordCallback: OTAPI isn't initialized yet. (Skipping.)");
        } else {
            if (null == Load.s_OneTime) {
                System.out.println("Load.setupPasswordCallback: Instantiating OneTimeOnly object... (this should happen one time only)");
                Load.s_OneTime = new OneTimeOnly(); // Password callbacks are in here. This internally also calls GiveItAShot().
            } else {
                System.out.println("Load.setupPasswordCallback: OneTimeOnly already exists. Calling GiveItAShot()...");
                boolean bCallbackSetup = Load.s_OneTime.GiveItAShot();
                System.out.println("Load.setupPasswordCallback: Status: " + bCallbackSetup);
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Load Image">

    private static void loadImage(String strImagePath) throws ImageNotLoadedException {

        System.out.println("Load.loadImage() top... ");

        if (strImagePath != null || !strImagePath.isEmpty()) {
            System.out.println("Load.loadImage(): Setting new Load Image:  " + strImagePath);

            Configuration.setImagePath(strImagePath);
        }

        if (Configuration.getImagePath() == null || Configuration.getImagePath().isEmpty()) {
            throw new ImageNotLoadedException("Load.loadImage(): Unable To Load Image, Maybe First Run, Image Not Set?");
        };

        System.out.println("Load.loadImage: Utility.getImagePath(): " + strImagePath);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Load AppData">

    private static String genericGetPath() { // added this function to avoid code duplication
        StringBuffer strOSVers = new StringBuffer("~"); // My appdataDirectory has a SPACE in it (/Users/au/Library/Application Support/.ot)
//      StringBuffer strOSVers      = new StringBuffer(appdataDirectory(getOS())); // Therefore I did this for now, so I could run the wallet again!
        String strAppend = strOSVers.append("/.ot/client_data").toString(); // todo hardcoding
//      String strSubstitute        = strAppend.replaceAll(" ", "\\ "); // Oh well, I tried.
        return strAppend;
    }

    public static void loadAllAppDataButWallet() throws AppDataNotLoadedException {
        String strPath = genericGetPath();
        if (null != strPath) {
            loadAllAppDataButWallet(strPath); // todo hardcoding
        }
    }

    public static void loadAppData() throws AppDataNotLoadedException {
        String strPath = genericGetPath();
        if (null != strPath) {
            loadAppData(strPath, "wallet.xml"); // todo hardcoding
        }
    }

    public static void loadAppData(String appDataLocation, String walletLocation) throws AppDataNotLoadedException {
        loadAllAppDataButWallet(appDataLocation);
        loadOTWallet(appDataLocation, walletLocation);
    }

    public static void loadAllAppDataButWallet(String appDataLocation) throws AppDataNotLoadedException {
        if (!Load.IsOTLoaded()) // We haven't loaded the jnilib yet.
        {
            String strError = "Load.loadAppData: otapi library isn't loaded yet. (Should thus never call this function at this point.)";
            System.out.println(strError);
            throw new AppDataNotLoadedException(strError);
        }
        // -----------------------------------------

        initOTAPI(appDataLocation);

        // --------------------------------------------
        // Password dialog -- security image path
        //
        try {
            Load.loadImage(_concierge.getConfig().getPasswordImage()); // really just loading the image path.
        } catch (ImageNotLoadedException ex) {
            throw new AppDataNotLoadedException("Load.loadAppData: Unable To Load Wallet; password security image not loaded.");
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Init OT API">
    public static void initOTAPI(String appDataLocation) throws AppDataNotLoadedException {

        if (!Load.IsOTLoaded()) // We haven't loaded the jnilib yet.
        {
            String strError = "Load.initOTAPI: otapi library isn't loaded yet. (Skipping.)";
            System.out.println(strError);
            throw new AppDataNotLoadedException(strError);
        }
        // -------------------------------------
        // BELOW THIS POINT, we know for a FACT that the OTAPI is LOADED...

        String strLocation = appDataLocation.trim();

        if (Load.IsOTInitialized()) {
            System.out.println("Load.initOTAPI: (OT_API_Init() was already completed in the past. (Skipping.)");
        } else // We haven't initialized yet OT yet.
        {
            // --------------------------------------------
            // This has internal logic so that it only actually is called once.
            // Probably not necessary anymore since I moved the call here.
            // The problem was, this call was happening too early (it could
            // happen even if otapi init failed) and then it wouldn't allow
            // itself to trigger again.  This I think should fix that.
            //
            // --------------------------------------------

            System.err.println("Calling otapi.OT_API_Init(" + strLocation + ")");

            // If you rename or refactor the com.wrapper.core part of Moneychanger... somehow this part breaks really bad...
            if (1 == otapi.OT_API_Init(strLocation)) {
                System.out.println("Load.initOTAPI: SUCCESS invoking OT_API_Init().");
                Load.s_bInitializedOTAPI = true;
                // ---------------------------------

                Load.setupPasswordCallback();
            } else // Failed in OT_API_Init().
            {
                String strErrorMsg = "Load.initOTAPI: OT_API_Init() call failed(). (Has it already been called?) Location is " + appDataLocation + " (End of location.)";
                throw new AppDataNotLoadedException(strErrorMsg);
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Load OT Wallet">

    public static void loadOTWallet(String appDataLocation, String walletLocation) throws AppDataNotLoadedException {

        if (false == Load.IsOTInitialized()) {
            System.out.println("Load.loadOTWallet: Skipping. (OT isn't initialized yet.)");
            return;
        }
        // ----------------------------------------
        // Load the wallet, if not already loaded.
        //
        String strLocation = new String(appDataLocation.trim());

        if (Load.s_bLoadedWallet) // Already loaded, therefore, use SwitchWallet() instead of LoadWallet().
        {
            if (1 == otapi.OT_API_SwitchWallet(strLocation, walletLocation)) {
                Load.s_bLoadedWallet = true;
                System.out.println("Load.loadOTWallet: OT_API_SwitchWallet() completed successfully.");
            } else {
                Load.s_bLoadedWallet = false;
                throw new AppDataNotLoadedException("Load.loadOTWallet: Unable To Switch Wallet, Maybe Wrong Password?");
            }
        } else // Wallet has not ever been loaded yet successfully.
        {
            Load.setupPasswordCallback(); // Just in case. (This can't step on its own toes, anyway.)

            if (1 == otapi.OT_API_LoadWallet(walletLocation)) {
                Load.s_bLoadedWallet = true;
                System.out.println("Load.loadOTWallet: OT_API_LoadWallet() completed successfully.");
            } else {
                Load.s_bLoadedWallet = false;
                throw new AppDataNotLoadedException("Load.loadOTWallet: Unable To Load Wallet, Maybe Wrong Password?");
            }
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Load API">
    public static void loadOTAPI() throws ApiNotLoadedException {
        loadOTAPI("");
    }

    public static void loadOTAPI(String paths) throws ApiNotLoadedException {
        try {

            Utility.addDirToRuntime(paths);

            loadZMQ();

            if (!s_bLoadedOTAPI) {
                System.loadLibrary("otapi-java");
                s_bLoadedOTAPI = true;
                System.out.println("Load.loadOTAPI: Success loading otapi-java.jnilib");
            } else {
                System.out.println("Load.loadOTAPI (2): (otapi-java is already loaded. Skipping.)");
            }
        } catch (java.lang.UnsatisfiedLinkError e) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append(System.getProperty("line.separator"));
            errorMessage.append(e.toString());
            errorMessage.append(System.getProperty("line.separator"));
            errorMessage.append(System.getProperty("java.library.path").replace(File.pathSeparator, System.getProperty("line.separator")));
            throw new ApiNotLoadedException(errorMessage.toString());
        } catch (IOException e) {
            throw new ApiNotLoadedException("IO Error");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Load loadZMQ">

    public static void loadZMQ() throws ApiNotLoadedException {
        try {
            if (!s_bLoadedZMQ//){
                    && !System.getProperty("os.name").toLowerCase().contains("mac")
                    && !System.getProperty("os.name").toLowerCase().contains("linux")) {
                System.loadLibrary("libzmq");
                s_bLoadedZMQ = true; // (Assuming the above loadLibrary throws in event of failure.)
            } else {
                System.out.println("Load.loadZMQ: (libzmq is already loaded. Skipping.)");
            }
        } catch (java.lang.UnsatisfiedLinkError e) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append(System.getProperty("line.separator"));
            errorMessage.append(e.toString());
            errorMessage.append(System.getProperty("line.separator"));
            errorMessage.append(System.getProperty("java.library.path").replace(File.pathSeparator, System.getProperty("line.separator")));
            throw new ApiNotLoadedException(errorMessage.toString());
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Load setTimeOut">

    public static void setTimeout() throws InvalidTimeOutException {
        long waitTime = 1;
        Configuration.setWaitTime(waitTime);
    }

    public static void setTimeout(String waitTimeTxt) throws InvalidTimeOutException {
        long waitTime;
        try {
            waitTime = Long.parseLong(waitTimeTxt);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeOutException("Please enter valid timeout; timeout not a number!");
        }
        if (waitTime < 1) {
            throw new InvalidTimeOutException("Please enter valid timeout; is less than 1");
        }
        Configuration.setWaitTime(waitTime);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Helpers">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Exceptions">

    public class LoadMoneyChangerException extends Exception {

        private String error;

        public LoadMoneyChangerException() {
            error = "none";
        }

        public LoadMoneyChangerException(String err) {
            super(err);     // call super class constructor
            error = err;  // save message
        }

        public String getError() {
            return error;
        }
    }

    static class ApiNotLoadedException extends Exception {

        private String locationsChecked;

        public ApiNotLoadedException() {
            super();             // call superclass constructor
            locationsChecked = "none";
        }

        public ApiNotLoadedException(String err) {
            super(err);     // call super class constructor
            locationsChecked = err;  // save message
        }

        public String getError() {
            return locationsChecked;
        }
    }

    static class ImageNotLoadedException extends Exception {

        private String locationsChecked;

        public ImageNotLoadedException() {
            super();             // call superclass constructor
            locationsChecked = "none";
        }

        public ImageNotLoadedException(String err) {
            super(err);     // call super class constructor
            locationsChecked = err;  // save message
        }

        public String getError() {
            return locationsChecked;
        }
    }

    static class AppDataNotLoadedException extends Exception {

        private String locationsChecked;

        public AppDataNotLoadedException() {
            super();             // call superclass constructor
            locationsChecked = "none";
        }

        public AppDataNotLoadedException(String err) {
            super(err);     // call super class constructor
            locationsChecked = err;  // save message
        }

        public String getError() {
            return locationsChecked;
        }
    }

    static class InvalidTimeOutException extends Exception {

        private String error;

        public InvalidTimeOutException() {
            error = "none";
        }

        public InvalidTimeOutException(String err) {
            super(err);     // call super class constructor
            error = err;  // save message
        }

        public String getError() {
            return error;
        }
    }
    // </editor-fold>
}
