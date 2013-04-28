package com.yfg.app.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


import com.slidingmenu.lib.app2.SlidingFragmentActivity;
import com.slidingmenu.lib2.SlidingMenu;
import com.yfg.app.fragment.MenuFragment;
import com.yfg.app.fragment.ViewPagerIndicatorFragment;

/**
 *  Home 
 * 
 * @author asbai
 * @since 2012-04-12
 * */
public class HomeActivity extends FragmentActivity { //extends SlidingFragmentActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_frame_content);
		 // set the Behind View
        //setBehindContentView(R.layout.home_frame_menu);
        
       // TextView iconTitle = (TextView) this.findViewById(R.id.icon_title);
       // iconTitle.setOnClickListener(this); //去除menu
        initMenuShowContent();
        //initSlidingMenu();
	}

	/*
	 * show the alignment of the contents
	 * */
	private void initMenuShowContent() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //MenuFragment menuFragment = new MenuFragment();
        //fragmentTransaction.replace(R.id.menu, menuFragment);
        //fragmentTransaction.replace(R.id.content, new ContentFragment(getString(R.string.welcome)),"Welcome");
        fragmentTransaction.replace(R.id.content, new ViewPagerIndicatorFragment());
        
        fragmentTransaction.commit();
	}

	/*
	 * customize the SlidingMenu
	 * */
	/*private void initSlidingMenu() {
		SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidth(50);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffset(80);
        sm.setFadeDegree(0.35f);
        
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//Gesture
		
	}*/

	//@Override
	//public void onClick(View arg0) {
		//this.toggle();//open SlidingMenu
	//}



}
