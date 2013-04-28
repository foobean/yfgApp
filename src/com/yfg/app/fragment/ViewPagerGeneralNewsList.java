package com.yfg.app.fragment;


import java.util.ArrayList;

import com.yfg.app.activity.R;
import com.yfg.app.fragment.adapter.ViewPagerFragmentListAdpter;
import com.yfg.app.fragment.adapter.ViewPagerGeneralNewListAdapter;
import com.yfg.app.fragment.data.BankApp;
import com.yfg.app.fragment.model.NewList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 *  This fragment will populate the children of the ViewPager from
 *  
 *  @author  asbai
 *  @since 2013-04-24
 * 
 * */
@SuppressLint("ValidFragment")
public class ViewPagerGeneralNewsList extends ListFragment{
	
	 private static final String TAG = ViewPagerGeneralNewListAdapter.class.toString();
	 private ListView listView  = null;
	 private ArrayList<NewList> modelList = new ArrayList<NewList>();
	 private ViewPagerGeneralNewListAdapter mAdpter;
	// private Activity content = this.getActivity();
	 private Context context;
	 private String classId; //classId for newLm class field
	 
	 public ViewPagerGeneralNewsList(){}
	 public ViewPagerGeneralNewsList(String id){
		 this.classId = id;
	 }
	 
	 /**
	  * 
	  * Factory method to generate a new instance of the fragment given an news List
	  * id.
	  * 
	  * @param id
	  *            The id within the parent adapter to load
	  * @return A new instance of ViewPagerGeneralNewsList with id extras
	  */
	 static ViewPagerGeneralNewsList newInstance(String id){
		 ViewPagerGeneralNewsList fragmentNesList = new ViewPagerGeneralNewsList();
		 Bundle bundle = new Bundle();
		 bundle.putString("number", id);
		 fragmentNesList.setArguments(bundle);
		 return fragmentNesList;
	 }
	 
	 
	 
	/**
	 * 
	 * Populate id number from extra, use the convenience factory method
	 * {@link ViewPagerGeneralNewsList#newInstance(String)} to create this fragment.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "-- onCreate method --");
		Bundle bund = getArguments();
		classId = bund != null ? bund.getString("number") : "";
		/**Get a the classID and the request related  URL*/
		modelList = BankApp.dataService.parserNewListResponse(classId);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "-- onCreateView method --");
		View v = inflater.inflate(R.layout.view_pager_fragment_demo, container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		listView = this.getListView();
		context = this.getActivity().getApplicationContext();
		
		Log.i(TAG, "-- onActivityCreated method --");
		
		if(modelList != null && modelList.size() > 0){
			mAdpter = new ViewPagerGeneralNewListAdapter(modelList,this.getActivity());
			 
			listView.setAdapter(mAdpter);
			listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
		               int position, long id) {
					
					Log.i("println"," - position: "+modelList.get(position).title+" id:"+modelList.get(position).id);
					Intent intent = new Intent("com.yfg.app.activity.NewsContentActivity");
					//intent.putExtra("classId", position);
					startActivity(intent);	   
				}
			});
		}
		
	}

	
	
}
