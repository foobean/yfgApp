package com.yfg.app.fragment.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.yfg.app.activity.R;
import com.yfg.app.utils.ImageLoader;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader; // 用来下载图片的类，后面有介绍
	
	public static final String KEY_NEWS = "news"; // parent node
  	public static final String KEY_ID = "id";
  	public static final String KEY_TITLE = "title";
  	public static final String KEY_CONTENT = "content";
  	public static final String KEY_COMMENTNUM = "commentNum";
  	public static final String KEY_THUMB_URL = "thumb_url";
	
	public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null){
			vi = inflater.inflate(R.layout.list_raw, null);
		}	
		TextView title = (TextView) vi.findViewById(R.id.title); // 标题
		TextView content = (TextView) vi.findViewById(R.id.content); // content
		TextView commentNum = (TextView) vi.findViewById(R.id.commentNum); // commentnum
		ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image); // 缩略图
		HashMap<String, String> song = new HashMap<String, String>();
		song = data.get(position);
		// 设置ListView的相关值
		title.setText(song.get(KEY_TITLE));
		content.setText(song.get(KEY_CONTENT));
		commentNum.setText(song.get(KEY_COMMENTNUM));
		imageLoader.DisplayImage(song.get(KEY_THUMB_URL),
				thumb_image);
		return vi;
	}
}