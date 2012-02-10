/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app.controlers;

import com.moneychanger.app.dialogs.OTPasswordDialog;
import com.moneychanger.app.main.Concierge;
import com.moneychanger.app.main.helpers.GetSetClipboard;
import com.moneychanger.core.util.Configuration;
import java.awt.event.ActionEvent;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import net.sf.swinglib.actions.AbstractActions;
import net.sf.swinglib.actions.IActions;
import net.sf.swinglib.actions.ReturnAction;
import net.sf.swinglib.dialog.IDialog;
import net.sf.swinglib.dialog.viewmodel.AbstractViewModel;
import net.sf.swinglib.document.DocWatcher;
import net.sf.swinglib.field.AbstractFields;
import net.sf.swinglib.field.IFields;

/**
 *
 * @author Cameron Garnham
 */
public class PasswordController {

    private static ReturnAction _returnAction;
    private static OTPasswordDialog _dialog;
    private static Concierge _concierge;
    private static PasswordModel _passwordModel;
    private static Fields _fields;
    private static Actions _actions;
    private PasswordViewModel _passwordViewModel;

    // <editor-fold defaultstate="collapsed" desc="Controller Constructor">
    public PasswordController(Concierge concierge, ReturnAction returnAction) {
        _returnAction = returnAction;
        _passwordModel = new PasswordModel();
        _concierge = concierge;
        _fields = new Fields(_passwordModel);
        _actions = new Actions(_fields);
        _passwordViewModel = new PasswordViewModel(_fields, _actions);
        _dialog = new OTPasswordDialog(_concierge.getDialogOwner(), true, _passwordViewModel, Configuration.getImagePath());
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    public void show() {
        _dialog.setVisible(true);
    }

    public void close() {
        _dialog.dispose();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Private Methods">

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Enum Keys">
    public enum ActionKeys {

        OK, CLOSE, GETCLIPBOARD;
    }

    public enum FieldKeys {

        PASSWORD;
    };
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Password View Model">

    private static class PasswordViewModel extends AbstractViewModel<PasswordController.FieldKeys, PasswordController.ActionKeys> {

        public PasswordViewModel(IFields<PasswordController.FieldKeys> fields, IActions<PasswordController.ActionKeys> actions) {
            super(fields, actions);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Password Model">

    private static final class PasswordModel {

        private static Map<FieldKeys, String> _localConfigViewModel;

        public PasswordModel() {
            _localConfigViewModel = new EnumMap<FieldKeys, String>(FieldKeys.class);

            if (_returnAction.getAction() == null || _returnAction.getAction().isEmpty()) {
                _localConfigViewModel.put(FieldKeys.PASSWORD, "Enter Password");
            }

            _localConfigViewModel.put(FieldKeys.PASSWORD, _returnAction.getAction());

        }

        public void setConfigOption(FieldKeys key, String value) {
            _localConfigViewModel.put(key, value);
        }

        public String getConfigViewModel(FieldKeys key) {
            return _localConfigViewModel.get(key);
        }

        public String getPassword() {
            return _localConfigViewModel.get(FieldKeys.PASSWORD);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Fields">

    private static class Fields extends AbstractFields<FieldKeys> {

        private PasswordModel _passwordModel;

        public Fields(PasswordModel passwordModel) {
            super(new EnumMap<FieldKeys, Document>(FieldKeys.class),
                    new EnumMap<FieldKeys, DocWatcher>(FieldKeys.class),
                    new EnumMap<FieldKeys, Boolean>(FieldKeys.class));
            _passwordModel = passwordModel;
        }

        @Override
        public void updateFieldDoc(FieldKeys fieldKey) {
            updateFieldDoc(fieldKey, _passwordModel.getConfigViewModel(fieldKey));
        }

        @Override
        public void updateConfig() {
            for (FieldKeys key : _fieldsMap.keySet()) {
                try {
                    _passwordModel.setConfigOption(key, _fieldsMap.get(key).getText(0, _fieldsMap.get(key).getLength()));
                } catch (BadLocationException e) {
                }
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Actions">

    private static class Actions extends AbstractActions<FieldKeys, ActionKeys> {

        public Actions(IFields<FieldKeys> fields) {
            super(fields, new EnumMap<ActionKeys, Action>(ActionKeys.class));
            _actionsMap.put(ActionKeys.OK, new AcceptAction());
            _actionsMap.put(ActionKeys.CLOSE, new CloseAction());
            _actionsMap.put(ActionKeys.GETCLIPBOARD, new GetClipboardAction());
        }

        @Override
        public void setConfig() {
            //do nothing, no config to set.
        }

        @Override
        public IDialog getDialog() {
            throw new UnsupportedOperationException("Not Needed.");
        }

        public class AcceptAction extends AbstractAction {

            public AcceptAction() {
                super("Accept");
            }

            @Override
            public void actionPerformed(ActionEvent ignored) {
                _fields.updateConfig();
                _returnAction.returnAction(_passwordModel.getPassword());
                _dialog.dispose();
            }
        }

        public class GetClipboardAction extends AbstractAction {

            private GetSetClipboard _setClipboard;

            public GetClipboardAction() {
                super("Paste Password From Clipboard");
                _setClipboard = new GetSetClipboard(_concierge, new ReturnAction() {

                    @Override
                    public String getAction() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public void returnAction(String string) {
                        _fields.updateFieldDoc(FieldKeys.PASSWORD,string);
                    }
                });
            }

            @Override
            public void actionPerformed(ActionEvent ignored) {
                _setClipboard.GetClipboard();
            }
        }

        public class CloseAction extends AbstractAction {

            public CloseAction() {
                super("Close");
            }

            @Override
            public void actionPerformed(ActionEvent ignored) {
                getDialog().close();
            }
        }
    }
}
// </editor-fold>
