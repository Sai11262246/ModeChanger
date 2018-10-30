package com.vivartha.modechanger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivityTest {
	
	@Test
	public void testOnCreate()
	{
		LoginActivity act = new LoginActivity();
		Bundle savedInstanceState = new Bundle();
		act.onCreate(savedInstanceState);
	}

    @Test
	public void testOnRequestPermissionsResult()
	{
		int requestCode = 1;
		String[] permissions = {"1","0","1"};
		int[] grantResults = new int[]{1,2,3};
		//grantResults = {1,2,3};
		LoginActivity act = new LoginActivity();
		act.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}  
   
	@Test
	public void testAttemptLogin()
	{
		LoginActivity act = new LoginActivity();
		//act.attemptLogin();
	}
	
	@Test
	public void testOnCreateLoader()
	{
		LoginActivity act = new LoginActivity();
		Bundle bundle = new Bundle();
		act.onCreateLoader(1,bundle);
	}
	
    @Test
    public void testOnLoadFinished()
	{
		Loader<Cursor> cursorLoader=new Loader<Cursor>(null);
        Cursor cursor = new SQLiteCursor(null, null, null);
        //		// public SQLiteCursor (SQLiteCursorDriver driver, String editTable, SQLiteQuery query)
		LoginActivity act = new LoginActivity();
		act.onLoadFinished(cursorLoader, cursor);
		
	}

}

