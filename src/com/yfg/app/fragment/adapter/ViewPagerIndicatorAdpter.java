package com.yfg.app.fragment.adapter;

import java.util.List;
import java.util.TreeSet;

import com.yfg.app.fragment.ViewPagerHeadNewsList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;


/**
 *  Custom adapter 
 * 
 * @author asbai
 * @since 2012-04-12
 * */
public class ViewPagerIndicatorAdpter extends FragmentPagerAdapter{

	
	 private List<ListFragment> fragmentList;
     private List<String>   titleList;

     
	public ViewPagerIndicatorAdpter(FragmentManager fm,List<ListFragment> fragmentList, List<String> titleList) {
		 super(fm);
		 this.fragmentList = fragmentList;
         this.titleList = titleList;
	}

	  @Override
      public Fragment getItem(int position) {
		  //fragmentList.add(new ViewPagerHeadNewsList(position));
          return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(position);
      }
	  
	  
	  
      @Override
      public CharSequence getPageTitle(int position) {
          return (titleList.size() > position) ? titleList.get(position) : "";
      }

      @Override
      public int getCount() {
          return titleList == null ? 0 : titleList.size();
      }

}
