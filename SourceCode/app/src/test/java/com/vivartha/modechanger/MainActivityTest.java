package com.vivartha.modechanger;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.junit.Test;

public class MainActivityTest {
	
	@Test
	public void testOnCreate()
	{
		MainActivity act = new MainActivity();
		Bundle savedInstanceState = new Bundle();
		act.onCreate(savedInstanceState);
	}
	
	@Test
	public void testOnCreateOptionsMenu()
	{
		MainActivity act = new MainActivity();
		//Menu menu = PowerMockito.mock(Menu.class);
		Menu menu = null;
		boolean result = act.onCreateOptionsMenu(menu);
	}	

}

