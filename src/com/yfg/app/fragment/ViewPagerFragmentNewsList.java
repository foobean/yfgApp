package com.yfg.app.fragment;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.yfg.app.activity.R;
import com.yfg.app.fragment.adapter.LazyAdapter;
import com.yfg.app.fragment.adapter.ViewPagerFragmentListAdpter;
import com.yfg.app.fragment.model.DemoModel;
import com.yfg.app.utils.XMLParser;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ViewPagerFragmentNewsList  extends ListFragment{
    private ListView listView  = null;
    // URL
  	//public static final String URL = "http://api.androidhive.info/music/music.xml";//xml
  	public String URL = "http://192.168.1.105:8080/newslist/newslist.action";//xml
    // XML 
  	public static final String KEY_NEWS = "news"; // parent node
  	public static final String KEY_ID = "id";
  	public static final String KEY_TITLE = "title";
  	public static final String KEY_CONTENT = "content";
  	public static final String KEY_COMMENTNUM = "commentNum";
  	public static final String KEY_THUMB_URL = "thumb_url";
  	private LazyAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View v = inflater.inflate(R.layout.main, container, false);
	     return v;
	}
	
	
	public ViewPagerFragmentNewsList(){}
	
	
	public ViewPagerFragmentNewsList(int position){
		URL += "?id="+ String.valueOf(position);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		 super.onActivityCreated(savedInstanceState);
		 listView = this.getListView();;
	     ArrayList<HashMap<String, String>> newsList = new ArrayList<HashMap<String, String>>();
         XMLParser parser = new XMLParser();
         String xml = parser.getXmlFromUrl(URL); // internet xml
         Document doc = parser.getDomElement(xml); // parser DOM 
         NodeList nl = doc.getElementsByTagName(KEY_NEWS);
         //  <song>
         for (int i = 0; i < nl.getLength(); i++) {
                 // HashMap
                 HashMap<String, String> map = new HashMap<String, String>();
                 Element e = (Element) nl.item(i);
                 //HashMap
                 map.put(KEY_ID, parser.getValue(e, KEY_ID));
                 map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
                 map.put(KEY_CONTENT, parser.getValue(e, KEY_CONTENT));
                 map.put(KEY_COMMENTNUM, parser.getValue(e, KEY_COMMENTNUM));
                 map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));
                 // HashList
                 newsList.add(map);
         }
         adapter=new LazyAdapter(getActivity(), newsList);        
         listView.setAdapter(adapter);
         listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {
				
				Log.i(view+"println==================="," - position: "+Integer.toString(position)+id);
			
			}
        	 
         });
         
	}

	
	
	
	
	
}
