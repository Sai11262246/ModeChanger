package com.vivartha.modechanger;

import android.os.Bundle;
import android.app.Activity;

public class About_Us_Test extends JunitTestCase{    
	
	@Test
	public void testOnCreate()
	{
		about_us obj = new about_us();
		Bundle savedInstanceState = new Bundle();
		obj.onCreate(savedInstanceState);
		
	}

}
