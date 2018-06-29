package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
public class Test {
	public static void main(String[] args) {
		List<String> urls = new ArrayList<String>();
		//git
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=5645e996af8ec3801cb52c72152c51a9944971cd6ea0f87e4b5175c93eb98f05");
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=5c06fba6715622141724af41780a614e60aef73234e56ba5c598a43569996a0b");
		
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=aed8c447cb32a05efece1205194bff07d4f4a7b0aa76cc1d9704c56521cf0c84");
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("msgtype", "text");
		HashMap<String,String> item = new HashMap<String,String>();
		item.put("content", "锟斤拷烫烫烫锟斤拷");
		map.put("text", item);
//		HashMap<String,String[]> at = new HashMap<String,String[]>();
//		String[] str={"18637125029"};
//		at.put("atMobiles", str);
//		map.put("at", at);
		String pae = JSONObject.toJSONString(map);
		System.out.println(pae);
		doPost(urls.get(2), pae); 
	}
	
	public static String doPost(String url, String params) {
		HttpClient httpclient = HttpClients.createDefault();
	    HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        StringEntity se = new StringEntity(params, "utf-8");
        httppost.setEntity(se);

        HttpResponse response;
		try {
			response = httpclient.execute(httppost);
			 if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
		            String result = EntityUtils.toString(response.getEntity());
		            System.out.println(result);
		          
		        }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        return null;
    }
	

}
