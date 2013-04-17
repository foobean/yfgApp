package com.yfg.app.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.yfg.app.activity.R;
import com.yfg.app.fragment.adapter.ViewPagerFragmentListAdpter;
import com.yfg.app.fragment.model.DemoModel;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * list demo
 * 
 * */
public class ViewPagerFragmentListDemo extends ListFragment{

	
	private LinkedList<String>   listItems = null;
    private ListView listView  = null;
    private ArrayList<DemoModel> modelList = new ArrayList<DemoModel>();
    private ViewPagerFragmentListAdpter mAdpter;
    
    private Activity content = this.getActivity();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View v = inflater.inflate(R.layout.view_pager_fragment_demo, container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		 super.onActivityCreated(savedInstanceState);
		 listView = this.getListView();
		 content = this.getActivity();
		/* 
	     listItems = new LinkedList<String>();
	     listItems.addAll(Arrays.asList(mStrings));
	     ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
	                                                                listItems);
	        listView.setAdapter(adapter);                                                        
	                                                                */
		 
		 for (int i = 1; i < 20; i++) {
			 DemoModel model = new DemoModel();
	 		 model.setTitle("title"+i);
	 		 model.setPreface("preface"+i);
	 		 modelList.add(model);
		}
		 mAdpter = new ViewPagerFragmentListAdpter(modelList,this.getActivity());
		 
		 listView.setAdapter(mAdpter);
		 listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {
				Log.i("println"," - position: "+Integer.toString(position));
			}
		});
	}


	private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
	            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
	            "Allgauer Emmentaler" };

	
}
