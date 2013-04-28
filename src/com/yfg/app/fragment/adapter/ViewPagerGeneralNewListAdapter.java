package com.yfg.app.fragment.adapter;

import java.util.ArrayList;

import com.yfg.app.activity.R;
import com.yfg.app.fragment.holder.NewListModelHolder;
import com.yfg.app.fragment.model.NewList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *   The main adapter that backs the ViewPagerGeneralNewsList.
 * 
 * 	@author asbai
 * 	@since 2013-04-25
 * 
 * */
public class ViewPagerGeneralNewListAdapter extends BaseAdapter{

	private ArrayList<NewList> allList;
	private Activity content;
	private NewList model;
	
	public ViewPagerGeneralNewListAdapter(ArrayList<NewList> list,Activity activity){
		this.allList = list;
		this.content = activity;
	}
	@Override
	public int getCount() {
		return allList.size();
	}

	@Override
	public Object getItem(int position) {
		return allList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final NewListModelHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(this.content).inflate(R.layout.list_raw, null);
			holder = new NewListModelHolder();
			holder.newList_title = (TextView) convertView.findViewById(R.id.title);
			holder.newList_content = (TextView) convertView.findViewById(R.id.content);
			holder.newList_commentNum = (TextView) convertView.findViewById(R.id.commentNum);
			holder.newList_img = (ImageView) convertView.findViewById(R.id.list_image);
		} else {
			holder = (NewListModelHolder) convertView.getTag();
		}
		convertView.setTag(holder);
		
		 
		model = allList.get(position);
		
		holder.newList_title.setText(model.title.trim());
		holder.newList_content.setText(model.smalltext.trim());
		if(model.titlepic == null || model.titlepic.trim() == "" || model.titlepic.length()  <= 0){
			holder.newList_img.setBackgroundResource(R.drawable.nophoto);
		} else {
			BitmapFactory.Options op = new BitmapFactory.Options();  
			Bitmap pic = BitmapFactory.decodeFile(model.titlepic, op);
			holder.newList_img.setImageBitmap(pic);
		}
		

		
		return convertView;
	}

}
