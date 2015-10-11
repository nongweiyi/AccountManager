package com.example.accountmanager.fragment;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;

public class AccountFlagInfoFragment extends Fragment {
	ListView listview;
	View view;
	DbManager dbManager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_layout_accountflaginfo, null);
		dbManager=DbManager.getInstance(getActivity());
		listview=(ListView) view.findViewById(R.id.listview);
		Cursor cursor=dbManager.loadAccountFlag();
		if((cursor.getCount())!=0){
			SimpleCursorAdapter adapter=new SimpleCursorAdapter(getActivity(), 
					R.layout.listview_item_accountflg, 
					cursor, new String[]{
				"_id","flag"
			}, new int[]{
				R.id.tv_id,R.id.tv_flag
			}, 0);
			listview.setAdapter(adapter);
		}
		
		return view;
	}

}
