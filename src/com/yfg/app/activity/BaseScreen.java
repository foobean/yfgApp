package com.yfg.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Infrastructure Functions
 * 
 * @author asbai
 * @since 2012-04-12
 * */
public abstract class BaseScreen extends Activity{

	protected static BaseScreen context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		context = this;
		initView();
	}
	
	public abstract void initView();

	
	
}
