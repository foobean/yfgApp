package com.yfg.app.fragment;

import java.util.ArrayList;

import com.yfg.app.activity.R;
import com.yfg.app.fragment.adapter.ViewPagerFragmentListAdpter;
import com.yfg.app.fragment.model.NewList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 *  general news list
 *  
 *  @author  asbai
 *  @since 2013-04-24
 * 
 * */
public class ViewPagerGeneralNewsList extends ListFragment{

	 private ListView listView  = null;
	 private ArrayList<NewList> modelList = new ArrayList<NewList>();
	 private ViewPagerFragmentListAdpter mAdpter;
	    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.view_pager_fragment_demo, container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	
	
}
