package com.vivartha.modechanger;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author revanth
 * To declare the preferences.
 * Set the default values for the keywords.
 */

/**Saving data across the application */
public class AppPreferences {

	private static final String APP_SHARED_PREFS = "com.viv.mode";
	private SharedPreferences appSharedPrefs;
	private Editor prefsEditor;

	/** Saving data in shared preferences which will store life time of Application */
	public AppPreferences(Context context)
	{
		this.appSharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
		this.prefsEditor = appSharedPrefs.edit();
	}

	/*
	 *    Delete the all the preferences
	 */
	public void deletePref() {
		this.prefsEditor.clear();
		this.prefsEditor.commit();
	}

	public void saveLoginStatte(int contactsCount) // 0 - Logg off, 1 - login success
	{
		prefsEditor.putInt("login_state", contactsCount);
		prefsEditor.commit();
	}

	public int getLoginState() {
		return appSharedPrefs.getInt("login_state",0);
	}


	public void savePinPadState(int contactsCount) // 0 - Logg off, 1 - login success
	{
		prefsEditor.putInt("pin_pad_state", contactsCount);
		prefsEditor.commit();
	}

	public int getPinPadState() {
		return appSharedPrefs.getInt("pin_pad_state",0);
	}


	public void savePin(String pin){
		prefsEditor.putString("pin", pin);
		prefsEditor.commit();
	}

	public String getPin(){
		return appSharedPrefs.getString("pin", "");
	}
	public void saveLatitude(String latitude){
		prefsEditor.putString("lat", latitude);
		prefsEditor.commit();
	}

	public String getLatitude(){
		return appSharedPrefs.getString("lat", "00.00");
	}

	public void saveLongitude(String longitude){
		prefsEditor.putString("longitude", longitude);
		prefsEditor.commit();
	}

	public String getLongitude(){
		return appSharedPrefs.getString("longitude","00.00");
	}

	public void saveUserName(String name){ // otp
		prefsEditor.putString("user_name", name);
		prefsEditor.commit();
	}

	public String getUserName(){ //otp
		return appSharedPrefs.getString("user_name","");
	}

	public void savePassword(String name){ // otp
		prefsEditor.putString("passwd", name);
		prefsEditor.commit();
	}

	public String getPassword(){ //otp
		return appSharedPrefs.getString("passwd","");
	}

	public void saveUserId(int id){ //phone no
		prefsEditor.putInt("user_id", id);
		prefsEditor.commit();
	}

	public int getUserid(){// phone no
		return appSharedPrefs.getInt("user_id",0);
	}


	public void saveUserPhone(String id){ //phoneno
		prefsEditor.putString("phoneno", id);
		prefsEditor.commit();
	}

	public String getUserPhone(){// phone no
		return appSharedPrefs.getString("phoneno","");
	}



	public void saveManifestoUrl(String url) {
		prefsEditor.putString("manifesto", url);
		prefsEditor.commit();
	}

	public String getManifestoUrl(){
		return appSharedPrefs.getString("manifesto", "");
	}

	public void saveHistoryUrl(String localUri) {
		prefsEditor.putString("history", localUri);
		prefsEditor.commit();
	}
	public String getHistoryUrl(){
		return appSharedPrefs.getString("history","");
	}

	public void saveLogOutRequired(int val) {
		prefsEditor.putInt("LogOutRequired", val);
		prefsEditor.commit();
	}
	public int getLogOutRequired(){
		return appSharedPrefs.getInt("LogOutRequired",0);
	}



	public void saveOrgId(String data) {
		prefsEditor.putString("org_id", data);
		prefsEditor.commit();
	}

	public String getOrgId(){
		return appSharedPrefs.getString("org_id","0");
	}

//	public void savePushState(int i) {
//		prefsEditor.putInt(RegistrationIntentService.SENT_TOKEN_TO_SERVER, i);
//		prefsEditor.commit();
//	}
//
//	public int getPushState(){
//		return appSharedPrefs.getInt(RegistrationIntentService.SENT_TOKEN_TO_SERVER, 0);
//	}

	public void saveFirebaseToken(String token) {
		prefsEditor.putString("fire_base_token", token);
		prefsEditor.commit();
	}

	public String getFirebaseToken(){
		return appSharedPrefs.getString("fire_base_token","");
	}

	public void saveHomeLat(String data) {
		prefsEditor.putString("lat", data);
		prefsEditor.commit();
	}

	public String getHomeLat(){
		return appSharedPrefs.getString("lat","0");
	}


	public void saveHomeLang(String data) {
		prefsEditor.putString("lang", data);
		prefsEditor.commit();
	}

	public String getHomeLang(){
		return appSharedPrefs.getString("lang","0");
	}


	public void saveFCMState(int state) {
		prefsEditor.putInt("state", state);
		prefsEditor.commit();
	}

	public int getFCMState(){
		return appSharedPrefs.getInt("state",0);
	}




}

