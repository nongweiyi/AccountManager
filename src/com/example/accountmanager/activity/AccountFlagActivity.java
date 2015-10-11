package com.example.accountmanager.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;
import com.example.accountmanager.fragment.AccountFlagInfoFragment;
import com.example.accountmanager.fragment.AddAccountFlagFragment;
import com.example.accountmanager.model.Flag;

public class AccountFlagActivity extends Activity implements OnClickListener {
	Button btn_accountFlagInfo, btn_addAccountFlag;

	AccountFlagInfoFragment accountFlagInfoFragment;
	AddAccountFlagFragment addAccountFlagFragment;
	FragmentManager fragmentManager;
	FragmentTransaction transaction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accountflag);

		init();
		fragmentManager = this.getFragmentManager();
		// ��ȡ��Ƭʵ��
		accountFlagInfoFragment = new AccountFlagInfoFragment();

		addAccountFlagFragment = new AddAccountFlagFragment();

		// ����Ĭ�ϼ����ҵı�ǩ��Ƭ
		btn_accountFlagInfo.setBackgroundColor(Color.parseColor("#AAAAAA"));
		transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.add_fragment_layout, accountFlagInfoFragment);
		transaction.commit();
	}

	private void init() {
		btn_accountFlagInfo = (Button) this
				.findViewById(R.id.btn_accountFlagInfo);
		btn_addAccountFlag = (Button) this
				.findViewById(R.id.btn_addAccountFlag);
		btn_accountFlagInfo.setOnClickListener(this);
		btn_addAccountFlag.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// �ҵı�ǩ
		case R.id.btn_accountFlagInfo:
			// ����ı䰴ť��ɫ
			btn_accountFlagInfo.setBackgroundColor(Color.parseColor("#AAAAAA"));
			btn_addAccountFlag.setBackgroundColor(Color.parseColor("#DEDCE0"));
			// ������Ƭ
			transaction = fragmentManager.beginTransaction();
			transaction.replace(R.id.add_fragment_layout,
					accountFlagInfoFragment);

			break;
		// ������ǩ
		case R.id.btn_addAccountFlag:
			// ����ı䰴ť��ɫ
			btn_addAccountFlag.setBackgroundColor(Color.parseColor("#AAAAAA"));
			btn_accountFlagInfo.setBackgroundColor(Color.parseColor("#DEDCE0"));
			// ������Ƭ
			transaction = fragmentManager.beginTransaction();
			transaction.replace(R.id.add_fragment_layout,
					addAccountFlagFragment);
			break;

		}
		transaction.commit();

	}

}
