package com.example.accountmanager.fragment;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;

public class OutAccountInfoFragment extends Fragment {
	ListView listview;
	View view;
	DbManager dbManager;
	RelativeLayout desktop_outaccountinfo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_outaccountinfo, null);

		dbManager = DbManager.getInstance(getActivity());
		listview = (ListView) view.findViewById(R.id.listview);
		// 将标题条隐藏
		desktop_outaccountinfo = (RelativeLayout) view.findViewById(R.id.desktop_outaccountinfo);
		desktop_outaccountinfo.setVisibility(desktop_outaccountinfo.GONE);
		Cursor cursor = dbManager.loadOutAccountInfo();

		// 有数据
		if ((cursor.getCount()) != 0) {
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.listview_item_outaccount,
					cursor, new String[] { "_id", "type", "money", "time", "address", "mark" },
					new int[] { R.id.tv_id, R.id.tv_type, R.id.tv_money, R.id.tv_time, R.id.tv_address, R.id.tv_mark },
					0);
			listview.setAdapter(adapter);
		} else {
			// 无数据
			Toast.makeText(getActivity(), "当前无数据", 0).show();
		}

		return view;
	}

}
