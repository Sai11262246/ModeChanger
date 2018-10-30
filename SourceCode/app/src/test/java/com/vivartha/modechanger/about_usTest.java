package com.vivartha.modechanger;

import android.os.Bundle;
import android.app.Activity;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

public class about_usTest{
	
	@Test
	public void testOnCreate()
	{
		about_us obj = new about_us();
		Bundle savedInstanceState = new Bundle();
		obj.onCreate(savedInstanceState);
		
	}

}
