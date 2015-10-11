package com.example.accountmanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;
import com.example.accountmanager.model.Password;
import com.example.accountmanager.util.ActivityCollector;

public class LoginActivity extends Activity implements OnClickListener {
	EditText et_password;
	Button btn_cancle, btn_login;
	DbManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//�ѵ�ǰ���ӵ����������
		ActivityCollector.addActivity(this);
		// ��ȡ���ݿ������
		dbManager = DbManager.getInstance(this);
		// �鿴���ݿ���û���������룬���û�����ù����룬��ת����������ҳ����������
		Boolean flag = dbManager.isPasswordExist(null);
		if (!flag) {
			Intent intent = new Intent(this, SetPasswordActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//��������ģʽΪSingleTask
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		} 
		init();

	}

	private void init() {
		et_password = (EditText) this.findViewById(R.id.et_password);
		btn_cancle = (Button) this.findViewById(R.id.btn_cancle);
		btn_login = (Button) this.findViewById(R.id.btn_login);

		btn_login.setOnClickListener(this);
		btn_cancle.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ��¼
		case R.id.btn_login:
			String pass = et_password.getText().toString().trim();
			savePassordToSharedPreferences(pass);
			if (pass != null) {
				// �������ݿ�����û���������
				Password password = new Password();
				password.setPassword(pass);

				Boolean flag_exist = dbManager.isPasswordExist(password);
				if (flag_exist) {
					// ��ת����ҳ
					Intent intent = new Intent(this, MainActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//��������ģʽΪSingleTask
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(this, "���������������", 0).show();
				}
			}
			break;
		// ȡ��
		case R.id.btn_cancle:
			et_password.setText("");
			break;

		default:
			break;
		}

	}
	/*
	 * �������ŵ�SharedPreferences��
	 * 
	 * */
	private void savePassordToSharedPreferences(String pass) {
		
		SharedPreferences sp=getSharedPreferences("sp_password", MODE_PRIVATE);
		Editor editor=sp.edit();
		editor.putString("password", pass);
		editor.commit();
		
	}
	

}
