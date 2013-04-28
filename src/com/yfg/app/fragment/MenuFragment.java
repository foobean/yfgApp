package com.yfg.app.fragment;

import com.slidingmenu.lib2.SlidingMenu;
import com.yfg.app.activity.HomeActivity;
import com.yfg.app.activity.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
/**
 *  main ui menu
 *  
 *  @author asbai
 *  @since 2013-04-12
 * 
 * */
@SuppressLint("NewApi")
public class MenuFragment extends Fragment implements OnClickListener {

	private int index = -1;
	//private ViewPager mViewPager = null;
	private FrameLayout mFrameLayout = null;
	private HomeActivity mActivity = null;
	private View contextView = null;
	private FragmentManager fragmentManager = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		mActivity = (HomeActivity) getActivity();
		mFrameLayout = (FrameLayout) mActivity.findViewById(R.id.content);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		contextView = inflater.inflate(R.layout.main_menu_list, container, false);
		LinearLayout layout = (LinearLayout) contextView.findViewById(R.id.listMenu_layout);
		for (int i = 0; i < layout.getChildCount(); i++){
			layout.getChildAt(i).setOnClickListener(this);
		}
		return contextView;
	}

	@Override
	public void onClick(View v) {
		
		/*switch (v.getId()) {
		case R.id.listMenu_1:
			if (index == 1) {
				mActivity.getSlidingMenu().toggle();
				return;
			}
			index = 1;
			mActivity.getSlidingMenu().setTouchModeAbove(
					SlidingMenu.TOUCHMODE_FULLSCREEN);
			fragmentManager = mActivity.getSupportFragmentManager();
			ViewPagerIndicatorFragment viewPagerIndicatorFragment = (ViewPagerIndicatorFragment) fragmentManager
					.findFragmentByTag("Indicator");
			fragmentManager
					.beginTransaction()
					.replace(
							R.id.content,
							viewPagerIndicatorFragment == null ? new ViewPagerIndicatorFragment()
									: viewPagerIndicatorFragment, "Indicator")
					.commit();
			break;
		case R.id.listMenu_2:
			
			if (index == 2) {
				mActivity.getSlidingMenu().toggle();
				return;
			}
			index = 2;
			fragmentManager = mActivity.getSupportFragmentManager();
			ViewPagerIndicatorFragment viewPagerIndicatorFragment2 = (ViewPagerIndicatorFragment) fragmentManager
					.findFragmentByTag("Indicator");
			fragmentManager
					.beginTransaction()
					.replace(
							R.id.content,
							viewPagerIndicatorFragment2 == null ? new ViewPagerIndicatorFragment()
									: viewPagerIndicatorFragment2, "Indicator")
					.commit();
		
			break;
		default:
			break;
		}
		mActivity.getSlidingMenu().toggle();*/
	}

}
