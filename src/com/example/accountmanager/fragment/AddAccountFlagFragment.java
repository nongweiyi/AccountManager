package com.example.accountmanager.fragment;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;
import com.example.accountmanager.model.Flag;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAccountFlagFragment extends Fragment implements OnClickListener {
	EditText et_flag;
	Button btn_cancle, btn_save;
	DbManager dbManager;
	View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		dbManager = DbManager.getInstance(getActivity());
		view = inflater.inflate(R.layout.fragment_layout_addaccountflag, null);
		init();
		return view;

	}

	private void init() {
		et_flag = (EditText) view.findViewById(R.id.et_flag);
		btn_cancle = (Button) view.findViewById(R.id.btn_cancle);
		btn_save = (Button) view.findViewById(R.id.btn_save);
		btn_cancle.setOnClickListener(this);
		btn_save.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 保存
		case R.id.btn_save:
			saveFlag();
			break;
		// 取消
		case R.id.btn_cancle:
			showAlertDialog();
			break;
		}

	}

	/*
	 * 保存新增便签内容
	 */
	private void saveFlag() {
		String inputFlag=et_flag.getText().toString().trim();
		Flag flag=new Flag();
		flag.setFlag(inputFlag);
		Boolean sussecceFlag=dbManager.saveFlag(flag);
		if(sussecceFlag){
			//保存成功
			Toast.makeText(getActivity(), "保存成功", 0).show();
			et_flag.setText("");
			
		}else{
			//保存失败
			Toast.makeText(getActivity(), "系统繁忙，请重试", 0).show();
		}
	}

	/*
	 * 出现对话框询问是否取消保存
	 */

	private void showAlertDialog() {

		AlertDialog.Builder dialog = new Builder(getActivity());
		dialog.setTitle("提示");
		dialog.setMessage("取消新增便签并返回？");
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				getActivity().finish();
			}
		});
		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

			}
		});
		dialog.create();
		dialog.show();

	}

}
