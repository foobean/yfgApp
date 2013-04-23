package com.yfg.app.fragment.data;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yfg.app.common.HttpClient;
import com.yfg.app.common.URLString;
import com.yfg.app.fragment.model.NewLm;

/**
 *  parser json data
 *  
 * @author asbai
 * @since 2012-4-23
 * */
public class AppDataService {
 
	/**
	 *  解析栏目 
	 * 
	 * */
	public ArrayList<NewLm> parserNewLmResponse(){
		HttpClient client = new HttpClient();
		try {
			String json = client.connect(URLString.getLmURL());
			JSONArray array = new JSONArray(json);
			if (array == null || array.length() == 0) {
				return null;
			}
			NewLm lm = null;
			JSONObject data = null;
			Object obj = null;
					
			ArrayList<NewLm> allLm = new ArrayList<NewLm>();
			if(array != null){
				for(int j = 0; j < array.length(); j++){
					lm = new NewLm();
					data = array.getJSONObject(j);
					Field[] fields = NewLm.class.getFields();
					for (Field f : fields) {
						obj = data.get(f.getName());
						if (!obj.equals(JSONObject.NULL)) {
							f.set(lm, obj);
						}
					}
					allLm.add(lm);
				}
				
			}
			
			return allLm;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
