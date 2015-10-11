package com.example.accountmanager.activity;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;
import com.example.accountmanager.model.Password;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SystemSetActivity extends Activity implements OnClickListener {
	Button btn_cancle, btn_save;
	EditText et_password;
	DbManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_systemset);

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

		// 保存
		case R.id.btn_save:
			Password password = new Password();
			String pass = et_password.getText().toString();
			password.setPassword(pass);
			String oldPassword = this.getSharedPreferences("sp_password", MODE_PRIVATE).getString("password", null);
			// 调用方法重置密码
			Boolean flag = dbManager.udaptePassord(oldPassword, password);
			if (flag) {
				Toast.makeText(this, "重置成功", 0).show();
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
			} else {
				Toast.makeText(this, "系统繁忙，请重试", 0).show();
			}
			break;
		// 取消
		case R.id.btn_cancle:
			et_password.setText("");
			break;
		default:
			break;
		}

	}

}
