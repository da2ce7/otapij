/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.ot.wrapper.jni;

import java.util.ArrayList;
import java.util.List;

public class OfferListNym extends Storable {
  private long swigCPtr;

  public OfferListNym(long cPtr, boolean cMemoryOwn) {
    super(otapiJNI.OfferListNym_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(OfferListNym obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        otapiJNI.delete_OfferListNym(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }
// ------------------------
	/*@SWIG:OTAPI.i,329,OT_CONTAINER_TYPE_MEMBERS@*/
	private List elementList = new ArrayList();
/*@SWIG@*/
	/*@SWIG:OTAPI.i,410,OT_ADD_ELEMENT@*/  // THIS BLOCK CONTAINS JAVA CODE.
private long removeRefOfferDataNym(long lIndex) {
	//
	// loop through the elements in the actual container, in order to find the one
	// at lIndex. Once it is found, then loop through the reference list and remove
	// the corresponding reference for that element.
	//
	OfferDataNym refActualElement = GetOfferDataNym(lIndex);

	if (refActualElement == null)
		return lIndex; // oh well.

	// Loop through the reference list and remove the corresponding reference
	// for the specified element.
	//
	for(int intIndex = 0; intIndex < elementList.size(); intIndex++)
	{
		Object theObject = elementList.get(intIndex);

		if ((theObject == null) || !(theObject instanceof OfferDataNym))
			continue;

		OfferDataNym tempRef = (OfferDataNym)(theObject);

		if ((OfferDataNym.getCPtr(tempRef) == OfferDataNym.getCPtr(refActualElement)))
		{
			elementList.remove(tempRef);
			break;
		}
	}

	return lIndex;
}

private long getCPtrAddRefOfferDataNym(OfferDataNym element) {
	// Whenever adding a reference to the list, I remove it first (if already there.)
	// That way we never store more than one reference per actual contained object.
	//
	for(int intIndex = 0; intIndex < elementList.size(); intIndex++)
	{
		Object theObject = elementList.get(intIndex);

		if ((theObject == null) || !(theObject instanceof OfferDataNym))
			continue;

		OfferDataNym tempRef = (OfferDataNym)(theObject);

		if ((OfferDataNym.getCPtr(tempRef) == OfferDataNym.getCPtr(element)))
		{
			elementList.remove(tempRef); // It was already there, so let's remove it before adding (below.)
			break;
		}
	}
	// Now we add it...
	//
	OfferDataNym tempLocalRef = element;
	elementList.add(tempLocalRef);
	return OfferDataNym.getCPtr(element);
}	// Hope I get away with overloading this for every type. Otherwise,
/*@SWIG@*/
  public long GetOfferDataNymCount() { return otapiJNI.OfferListNym_GetOfferDataNymCount(swigCPtr, this); }

  public OfferDataNym GetOfferDataNym(long nIndex) {
    long cPtr = otapiJNI.OfferListNym_GetOfferDataNym(swigCPtr, this, nIndex);
    return (cPtr == 0) ? null : new OfferDataNym(cPtr, false);
  }

  public boolean RemoveOfferDataNym(long nIndexOfferDataNym) {
    return otapiJNI.OfferListNym_RemoveOfferDataNym(swigCPtr, this, removeRefOfferDataNym(nIndexOfferDataNym));
  }

  public boolean AddOfferDataNym(OfferDataNym disownObject) {
    return otapiJNI.OfferListNym_AddOfferDataNym(swigCPtr, this, OfferDataNym.getCPtr(disownObject), disownObject);
  }

  public static OfferListNym ot_dynamic_cast(Storable pObject) {
    long cPtr = otapiJNI.OfferListNym_ot_dynamic_cast(Storable.getCPtr(pObject), pObject);
    return (cPtr == 0) ? null : new OfferListNym(cPtr, false);
  }

}