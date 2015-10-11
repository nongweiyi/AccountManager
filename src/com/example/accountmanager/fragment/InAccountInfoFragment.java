package com.example.accountmanager.fragment;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;

public class InAccountInfoFragment extends Fragment {
	ListView listview;
	View view;
	DbManager dbManager;
	RelativeLayout desktop_inaccountinfo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_inaccountinfo, null);
		dbManager = DbManager.getInstance(getActivity());

		// 将标题条隐藏
		desktop_inaccountinfo = (RelativeLayout) view.findViewById(R.id.desktop_inaccountinfo);
		desktop_inaccountinfo.setVisibility(desktop_inaccountinfo.GONE);
		listview = (ListView) view.findViewById(R.id.listview);

		Cursor cursor = dbManager.loadInAccountInfo();
		Log.i("nongweiyi", "执行到这里吗-12----");
		// 有数据
		if ((cursor.getCount()) != 0) {
			Log.i("nongweiyi", "执行到这里吗-11----");
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.listview_item_inaccount,
					cursor, new String[] { "_id", "type", "money", "time", "handler", "mark" },
					new int[] { R.id.tv_id, R.id.tv_type, R.id.tv_money, R.id.tv_time, R.id.tv_handler, R.id.tv_mark },
					0);
			Log.i("nongweiyi", "执行到这里吗-----");
			listview.setAdapter(adapter);
			Log.i("nongweiyi", "这里呢-----");
		} else {
			// 无数据
			Toast.makeText(getActivity(), "当前无数据", 0).show();
		}

		return view;
	}

}
