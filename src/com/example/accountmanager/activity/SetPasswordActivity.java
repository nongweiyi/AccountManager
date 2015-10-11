package com.example.accountmanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;
import com.example.accountmanager.model.Password;
import com.example.accountmanager.util.ActivityCollector;
import com.example.accountmanager.util.LogUtil;

public class SetPasswordActivity extends Activity implements OnClickListener {
	Button btn_cancle, btn_save;
	EditText et_password;
	DbManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setpassword);
		// �ѵ�ǰ���ӵ����������
		ActivityCollector.addActivity(this);
		init();
		dbManager = DbManager.getInstance(this);

	}

	private void init() {
		btn_cancle = (Button) this.findViewById(R.id.btn_cancle);
		btn_save = (Button) this.findViewById(R.id.btn_save);
		et_password = (EditText) this.findViewById(R.id.et_password);

		btn_save.setOnClickListener(this);
		btn_cancle.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		// ����
		case R.id.btn_save:
			Password password = new Password();
			String pass = et_password.getText().toString().trim();
			if(TextUtils.isEmpty(pass)){
				Toast.makeText(this, "����������", 0).show();
				return;
			}
			password.setPassword(pass);
			Boolean flag = dbManager.savePassord(password);// ���÷������������洢�����ݿ���
			if (flag) {
				Toast.makeText(this, "����ɹ�", 0).show();
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
			} else {
				Toast.makeText(this, "ϵͳ��æ��������", 0).show();
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

}
