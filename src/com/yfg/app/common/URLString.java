package com.yfg.app.common;


/**
 * 
 * request url site  
 * 
 * @author asbai
 * @since 2012-04-23
 * */
public final class URLString {
	
	//
	public static final String BASE_URL = "http://www.infocio.cn/e/extend/yfg/";
	
	
	/**
	 * 栏目
	 * */
	public static String getLmURL(){
		return BASE_URL + "newsLm.php";
	}
	
	/**
	 * 新闻列表的接口
	 * 
	 * @param id 栏目ID
	 * */
	public static String getNewListURL(String id){
		return BASE_URL + "newsList.php?id=" + id;
	}
	
	/**
	 * 新闻详细接口
	 * 
	 * @param id 列表ID
	 * 
	 * */
	public static String getNewsDetailURL(String id){
		return BASE_URL + "news.php?id=" + id;
	}
	
	
}
