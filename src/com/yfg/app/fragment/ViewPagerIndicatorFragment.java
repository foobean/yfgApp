package com.yfg.app.fragment;

import java.util.ArrayList;
import java.util.List;

import com.slidingmenu.lib2.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;
import com.yfg.app.activity.HomeActivity;
import com.yfg.app.activity.R;
import com.yfg.app.fragment.adapter.ViewPagerIndicatorAdpter;
import com.yfg.app.fragment.data.BankApp;
import com.yfg.app.fragment.model.NewLm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


/**
 *  build Indicator fragment
 *  
 *  @author asbai
 *  @since 2013-04-12
 * 
 * */
public class ViewPagerIndicatorFragment extends Fragment{

	private HomeActivity mMain = null;
	private TabPageIndicator indicator = null;
	private View contextView = null;
	private ViewPager pager = null;
	private ViewPagerIndicatorAdpter myAdapter = null;
	private List<ListFragment> fragmentList = new ArrayList<ListFragment>();
	private List<String>   titleList    = new ArrayList<String>();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*fragmentList.add(new ViewPagerFragmentListDemo());
		fragmentList.add(new ViewPagerFragmentListDemo());
		fragmentList.add(new ViewPagerFragmentListDemo());
		fragmentList.add(new ViewPagerFragmentListDemo());
		fragmentList.add(new ViewPagerFragmentListDemo());*/
     /*   fragmentList.add(new ViewPagerFragmentNewsList());
        fragmentList.add(new ViewPagerFragmentNewsList());
        fragmentList.add(new ViewPagerFragmentNewsList());
        fragmentList.add(new ViewPagerFragmentNewsList());*/
		
		/*titleList.add("title 1 ");
        titleList.add("title 2 ");
        titleList.add("title 3 ");
        titleList.add("title 4 ");
        titleList.add("title 5 ");	*/	
		
		ArrayList<NewLm> allLm = BankApp.dataService.parserNewLmResponse();
		if(allLm != null && allLm.size() >0){
			for(int i = 0 ; i < allLm.size(); i++){
				NewLm lm = allLm.get(i);
				titleList.add(lm.classname.trim());
				fragmentList.add(ViewPagerGeneralNewsList.newInstance(lm.classid));
			}
		}
		
		myAdapter = new ViewPagerIndicatorAdpter(getFragmentManager(), fragmentList, titleList);
		mMain = (HomeActivity) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		contextView = inflater.inflate(R.layout.simple_tabs, container, false);
		pager = (ViewPager) contextView.findViewById(R.id.pager);
		
		//myAdapter.notifyDataSetChanged();
		pager.setAdapter(myAdapter);

		
		indicator = (TabPageIndicator) contextView.findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		
		//indicator.setOnPageChangeListener(onPageChangeListener);
		return contextView;
	}

	
	/*ViewPager.SimpleOnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener(){
		
		@Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                	mMain. getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    break;
                default:
                	mMain. getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
                    break;
            }
        }
	};*/
	
}
