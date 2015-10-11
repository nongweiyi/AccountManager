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
		// 把当前活动添加到活动管理器中
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

		// 保存
		case R.id.btn_save:
			Password password = new Password();
			String pass = et_password.getText().toString().trim();
			if(TextUtils.isEmpty(pass)){
				Toast.makeText(this, "请输入密码", 0).show();
				return;
			}
			password.setPassword(pass);
			Boolean flag = dbManager.savePassord(password);// 调用方法把密码对象存储到数据库中
			if (flag) {
				Toast.makeText(this, "保存成功", 0).show();
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
