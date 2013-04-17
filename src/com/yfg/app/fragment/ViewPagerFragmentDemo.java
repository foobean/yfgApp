package com.yfg.app.fragment;

import java.util.Arrays;
import java.util.LinkedList;

import com.yfg.app.activity.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 *  c
 * 
 * */
public class ViewPagerFragmentDemo extends Fragment {

	private LinkedList<String>   listItems = null;
    private ListView listView  = null;
    

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View v = inflater.inflate(R.layout.view_pager_fragment_demo, container, false);
	    /* listView = (ListView)v.findViewById(R.id.statusListView);
	        
	        
	     listItems = new LinkedList<String>();
	     listItems.addAll(Arrays.asList(mStrings));
	     ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
	                                                                listItems);
	     listView.setAdapter(adapter);*/

	     return v;
	}
	
	
	 private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
	            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
	            "Allgauer Emmentaler" };

}
