package com.example.accountmanager.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.accountmanager.R;
import com.example.accountmanager.fragment.AccountFlagInfoFragment;
import com.example.accountmanager.fragment.InAccountInfoFragment;
import com.example.accountmanager.fragment.OutAccountInfoFragment;

public class ShowAccountInfoActivity extends Activity implements
		OnClickListener {
	Button btn_outaccount, btn_inaccount, btn_flag;
	FragmentManager fragmentManager;
	FragmentTransaction transaction;

	OutAccountInfoFragment outAccountInfoFragment;
	InAccountInfoFragment inAccountInfoFragment;
	AccountFlagInfoFragment accountFlagInfoFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showaccountinfo);
		init();

		// ��ȡ֧����Ϣ��������Ϣ����ǩ��Ϣ��Ƭʵ��
		outAccountInfoFragment = new OutAccountInfoFragment();
		inAccountInfoFragment = new InAccountInfoFragment();
		accountFlagInfoFragment = new AccountFlagInfoFragment();
		// ��ȡ��Ƭ����������Ĭ�ϼ����ҵ�֧����Ϣ��Ƭ
		fragmentManager = this.getFragmentManager();
		transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.ll_showaccountinfo, outAccountInfoFragment);
		transaction.commit();
		btn_outaccount.setBackgroundColor(Color.parseColor("#AAAAAA"));

	}

	private void init() {
		btn_outaccount = (Button) this.findViewById(R.id.btn_outaccount);
		btn_inaccount = (Button) this.findViewById(R.id.btn_inaccount);
		btn_flag = (Button) this.findViewById(R.id.btn_flag);

		btn_outaccount.setOnClickListener(this);
		btn_inaccount.setOnClickListener(this);
		btn_flag.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		transaction = fragmentManager.beginTransaction();
		switch (v.getId()) {
		// ֧����Ϣ
		case R.id.btn_outaccount:
			btn_outaccount.setBackgroundColor(Color.parseColor("#AAAAAA"));
			btn_inaccount.setBackgroundColor(Color.parseColor("#DEDCE0"));
			btn_flag.setBackgroundColor(Color.parseColor("#DEDCE0"));
			//����֧����Ϣ��Ƭ
			transaction.replace(R.id.ll_showaccountinfo, outAccountInfoFragment);
			break;
		// ������Ϣ
		case R.id.btn_inaccount:
			btn_inaccount.setBackgroundColor(Color.parseColor("#AAAAAA"));
			btn_outaccount.setBackgroundColor(Color.parseColor("#DEDCE0"));
			btn_flag.setBackgroundColor(Color.parseColor("#DEDCE0"));
			//����������Ϣ��Ƭ
			transaction.replace(R.id.ll_showaccountinfo, inAccountInfoFragment);

			break;
		// ��ǩ��Ϣ
		case R.id.btn_flag:
			btn_flag.setBackgroundColor(Color.parseColor("#AAAAAA"));
			btn_inaccount.setBackgroundColor(Color.parseColor("#DEDCE0"));
			btn_outaccount.setBackgroundColor(Color.parseColor("#DEDCE0"));
			//���ر�ǩ��Ϣ��Ƭ
			transaction.replace(R.id.ll_showaccountinfo, accountFlagInfoFragment);

			break;

		default:
			break;
		}
		transaction.commit();

	}

}
