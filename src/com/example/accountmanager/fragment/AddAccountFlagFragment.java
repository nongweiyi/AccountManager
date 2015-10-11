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
		// ����
		case R.id.btn_save:
			saveFlag();
			break;
		// ȡ��
		case R.id.btn_cancle:
			showAlertDialog();
			break;
		}

	}

	/*
	 * ����������ǩ����
	 */
	private void saveFlag() {
		String inputFlag=et_flag.getText().toString().trim();
		Flag flag=new Flag();
		flag.setFlag(inputFlag);
		Boolean sussecceFlag=dbManager.saveFlag(flag);
		if(sussecceFlag){
			//����ɹ�
			Toast.makeText(getActivity(), "����ɹ�", 0).show();
			et_flag.setText("");
			
		}else{
			//����ʧ��
			Toast.makeText(getActivity(), "ϵͳ��æ��������", 0).show();
		}
	}

	/*
	 * ���ֶԻ���ѯ���Ƿ�ȡ������
	 */

	private void showAlertDialog() {

		AlertDialog.Builder dialog = new Builder(getActivity());
		dialog.setTitle("��ʾ");
		dialog.setMessage("ȡ��������ǩ�����أ�");
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				getActivity().finish();
			}
		});
		dialog.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

			}
		});
		dialog.create();
		dialog.show();

	}

}
