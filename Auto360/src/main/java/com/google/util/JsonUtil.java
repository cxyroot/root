package com.google.util;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class JsonUtil {
	private static Gson gson=new Gson();
	public static String toJson(Object src){
		if(src == null){
			return gson.toJson(JsonNull.INSTANCE);
		}

		return gson.toJson(src);
	}
}
