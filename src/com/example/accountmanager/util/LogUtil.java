package com.example.accountmanager.util;

import android.util.Log;

public class LogUtil {
	private static final int VERBOSE=1;
	private static final int DEBUG=2;
	private static final int INFO=3;
	private static final int WARN=4;
	private static final int ERROR=5;
	private static final int ASSERT=6;
	
	private static final String tag="nongweiyi";
	
	private static int LEVEL=VERBOSE; 
	
	public static void v(String tag,String msg){
		if(LEVEL<=VERBOSE){
			Log.v(tag, msg);
		}
	}
	public static void d(String tag,String msg){
		if(LEVEL<=DEBUG){
			Log.v(tag, msg);
		}
	}
	public static void i(String tag,String msg){
		if(LEVEL<=INFO){
			Log.v(tag, msg);
		}
	}
	public static void w(String tag,String msg){
		if(LEVEL<=WARN){
			Log.v(tag, msg);
		}
	}
	public static void e(String tag,String msg){
		if(LEVEL<=ERROR){
			Log.v(tag, msg);
		}
	}
	

}
