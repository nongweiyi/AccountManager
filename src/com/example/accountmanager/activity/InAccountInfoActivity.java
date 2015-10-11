package com.example.accountmanager.activity;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class InAccountInfoActivity extends Activity {
	ListView listview;
	DbManager dbManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inaccountinfo);
		
		listview=(ListView) this.findViewById(R.id.listview);
		dbManager=DbManager.getInstance(this);
		
		Cursor cursor=dbManager.loadInAccountInfo();
		
		//有数据
		if((cursor.getCount())!=0){
			SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.listview_item_inaccount, cursor, new String[]{
					"_id","type","money","time","handler","mark"
			}, new int[]{
					R.id.tv_id,R.id.tv_type,R.id.tv_money,R.id.tv_time,R.id.tv_handler,R.id.tv_mark
			},0);
			listview.setAdapter(adapter);
		}else{
			//无数据
			Toast.makeText(this, "当前无数据", 0).show();
		}
	}
}
