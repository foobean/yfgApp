package com.yfg.app.fragment;


import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.yfg.app.activity.NewsContentActivity;
import com.yfg.app.activity.R;
import com.yfg.app.fragment.adapter.LazyAdapter;
import com.yfg.app.utils.XMLParser;

@SuppressLint("ValidFragment")
public class ViewPagerHeadNewsList  extends ListFragment{
    private ListView listView  = null;
    // URL
  	//public static final String URL = "http://api.androidhive.info/music/music.xml";//xml
  	//public String URL = "http://192.168.1.105:8080/newslist/newslist.action";//xml
    public String URL = "http://192.168.11.6:8080/newslist/newslist.action";//xml
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
		/* vFooter = inflater.inflate(R.layout.list_footer, null);
		 loading = (LinearLayout) vFooter.findViewById(R.id.list_footer);
		 loading.setVisibility(View.GONE);
		 getFirstData();*/
	     return v;
	}
	
	
	public ViewPagerHeadNewsList(){}
	
	public ViewPagerHeadNewsList(int position){
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
         //  <news>
         int num = nl.getLength();
         for (int i = 0; i < num ; i++) {
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
				
				Log.i(view+"println===================","-position: "+Integer.toString(position)+id);
				Intent intent = new Intent(getActivity(),NewsContentActivity.class);
				startActivity(intent);
				
			}
         });
         
         //scroll
         listView.setOnScrollListener(new OnScrollListener(){

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
			}

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
					if (view.getLastVisiblePosition() == view.getCount() - 1) {
						//getSecondData();
						
						
						
					}
				}
				
			}
         });
         
	}
	
	
	public ArrayList<HashMap<String, String>> getNewsList(){
		ArrayList<HashMap<String, String>> newsList = new ArrayList<HashMap<String, String>>();
        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // internet xml
        Document doc = parser.getDomElement(xml); // parser DOM 
        NodeList nl = doc.getElementsByTagName(KEY_NEWS);
        //  <news>
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
        return newsList;
	}
	
	/**
	 * 只是显示底部
	 * 
	 */
/*	public void getFirstData() {
		th = new Thread(new Runnable() {
			@Override
			public void run() {
				Bundle b = new Bundle();
				try {
					Thread.sleep(2000);
					b.putBoolean("bindList", true);
					count = 5;
				} catch (Exception e) {
				} finally {
					sendMsgHandle(handler, b);
				}
			}
		});
		try {
				th.start();
			} catch (Exception e) {
		}
	}*/

	
	/**
	 * 获得加载的数据
	 * 
	 * 
	 */
	/*public void getSecondData() {
		loading.setVisibility(View.VISIBLE);
		th = new Thread(new Runnable() {

			@Override
			public void run() {
				Bundle b = new Bundle();
				try {
					Thread.sleep(2000);
					b.putBoolean("bindSecond", true);
					count += 5;
				} catch (Exception e) {
				} finally {
					sendMsgHandle(handler, b);
				}
			}
		});
		th.start();
	}
	*/
	// 发送Msg
	public void sendMsgHandle(Handler handler, Bundle bundle) {
		Message msg = handler.obtainMessage();
		msg.setData(bundle);
		handler.sendMessage(msg);
	}
	
	
	/**
	 * 这个起什么作用
	 * 
	 */
	/*public Handler handler = new Handler(Looper.getMainLooper()) {
		@Override
		public void handleMessage(Message msg) {
			try {
				if (msg.getData().containsKey("bindList")) {
					adapter = new LazyAdapter(getActivity(),getNewsList());
					listView.setAdapter(adapter);
				} else if (msg.getData().containsKey("bindSecond")) {
					loading.setVisibility(View.GONE);
					adapter.notifyDataSetChanged();
				}
			} catch (Exception e) {
			
			}
		}
	};
*/
	
/*	private LinearLayout loading;
	private View vFooter;
	private Thread th = null;
	private int count;

	*/
	
}
