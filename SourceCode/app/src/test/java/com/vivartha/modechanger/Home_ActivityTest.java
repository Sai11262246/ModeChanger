package com.vivartha.modechanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import org.junit.Test;

public class Home_ActivityTest{
	
	@Test
	public void testOnCreate()
	{
		Home_Activity act = new Home_Activity();
		Bundle savedInstanceState = new Bundle();
		act.onCreate(savedInstanceState);
	}
}
