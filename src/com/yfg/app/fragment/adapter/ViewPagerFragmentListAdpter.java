package com.yfg.app.fragment.adapter;

import java.util.ArrayList;

import com.yfg.app.activity.R;
import com.yfg.app.fragment.holder.DemoModelHolder;
import com.yfg.app.fragment.model.DemoModel;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewPagerFragmentListAdpter extends BaseAdapter{

	private ArrayList<DemoModel> allList;
	private Activity content;
	private DemoModel model;
	
	public ViewPagerFragmentListAdpter(ArrayList<DemoModel> list,Activity activity){
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
		convertView = LayoutInflater.from(this.content).inflate(R.layout.demo_model, null);
		DemoModelHolder holder = new DemoModelHolder();
		holder.title = (TextView) convertView.findViewById(R.id.title);
		holder.preface = (TextView) convertView.findViewById(R.id.preface);
		holder.img = (ImageView) convertView.findViewById(R.id.img);
		
		convertView.setTag(holder);
		
		 
		model = allList.get(position);
		
		holder.title.setText(model.getTitle());
		holder.preface.setText(model.getPreface());
		holder.img.setBackgroundResource(R.drawable.checked);
		

		
		return convertView;
	}

}
