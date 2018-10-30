package com.vivartha.modechanger;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import org.junit.Test;

public class Splash_ScreenTest {
	
	@Test
	public void testOnCreate()
	{
		Splash_Screen obj = new Splash_Screen();
		Bundle savedInstanceState = new Bundle();
		obj.onCreate(savedInstanceState);
	}

}
