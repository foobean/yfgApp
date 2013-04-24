package com.yfg.app.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;


/**
 *  http fuction
 * 
 * @author asbai
 * @since 2012-04-23
 * */
public final class HttpClient {

	public HttpClient() {
	}
	
	/**
	 * 
	 *  request http url
	 * 
	 * @param urlStr
	 *            of String
	 * @return
	 * @throws IOException
	 */
	public String connect(String urlStr) throws IOException {
		InputStream ins = null;
		try {
			Log.d("connect","urlStr,," + urlStr);
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(18000);
			conn.setDoInput(true);
			conn.connect();
			int code = conn.getResponseCode();
			Log.d("","-----response code-----" + code);
			if (code == HttpURLConnection.HTTP_OK || code == 400) {
				ins = (InputStream)conn.getInputStream();
				return readInputStreams(ins);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				ins.close();
			}
		}
		return null;
	}
	/**
	 *  
	 *   read inputStream
	 * 
	 * */
	private String readInputStreams(InputStream ins){
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		StringBuffer sb = new StringBuffer();
		int count = 1024;
		int result = -1;
		char[] readChars = new char[count];
		String temp = null;
		try {
			do {
				result = br.read(readChars, 0, count);

				if (result > 0) {
					temp = new String(readChars, 0, result);
					sb.append(temp);
				}
			} while (result != -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
		
	   
	}

	/**
	 *  read input stream
	 *  
	 *  @param inputStream
	 *  @return string
	 * 
	 * */
	private String readInputStream(InputStream ins) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(ins));
			String str = null;
			StringBuffer sb = new StringBuffer(0);
			//sb.append("[");
			while ((str = br.readLine()) != null) {
				sb.append(str);
				Log.d("","---sb-----" + sb.toString());
			}
			//sb.append("]");
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
