package com.example.accountmanager.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/*
 * 活动管理器，用来随时随地退出程序
 * */
public class ActivityCollector {
	public static List<Activity> activities=new ArrayList<Activity>();
	
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	public static void finishAll(){
		for(Activity activity:activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}

}
