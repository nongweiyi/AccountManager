package com.example.accountmanager.activity;

import com.example.accountmanager.R;
import com.example.accountmanager.util.ActivityCollector;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	ImageView iv_addoutaccount;// ����֧��
	ImageView iv_addinaccount;// ��������
	ImageView iv_outaccountinfo;// �ҵ�֧��
	ImageView iv_inaccountinfo;// �ҵ�����
	ImageView iv_showinfo;// ���ݹ���
	ImageView iv_sysset;// ϵͳ����
	ImageView iv_accountflag;// ��ǩ����
	ImageView iv_exit;// �˳�
	
	private int backPressCount = 0;//���ؼ����´���

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//�ѵ�ǰ���ӵ����������
		ActivityCollector.addActivity(this);
		init();
	}

	private void init() {

		iv_addoutaccount = (ImageView) this.findViewById(R.id.iv_addoutaccount);
		iv_addinaccount = (ImageView) this.findViewById(R.id.iv_addinaccount);
		iv_outaccountinfo = (ImageView) this.findViewById(R.id.iv_outaccountinfo);
		iv_inaccountinfo = (ImageView) this.findViewById(R.id.iv_inaccountinfo);
		iv_showinfo = (ImageView) this.findViewById(R.id.iv_showinfo);
		iv_sysset = (ImageView) this.findViewById(R.id.iv_sysset);
		iv_accountflag = (ImageView) this.findViewById(R.id.iv_accountflag);
		iv_exit = (ImageView) this.findViewById(R.id.iv_exit);

		iv_addoutaccount.setOnClickListener(this);
		iv_addinaccount.setOnClickListener(this);
		iv_outaccountinfo.setOnClickListener(this);
		iv_inaccountinfo.setOnClickListener(this);
		iv_showinfo.setOnClickListener(this);
		iv_sysset.setOnClickListener(this);
		iv_accountflag.setOnClickListener(this);
		iv_exit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ����֧��
		case R.id.iv_addoutaccount:
			Intent intent_addoutaccount = new Intent(this,AddOutAccountActivity.class);
			intent_addoutaccount.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_addoutaccount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_addoutaccount);
			
			break;
		// ��������
		case R.id.iv_addinaccount:
			Intent intent_addinaccount = new Intent(this,AddInAccountActivity.class);
			intent_addinaccount.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_addinaccount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_addinaccount);

			break;
		// �ҵ�֧��
		case R.id.iv_outaccountinfo:
			Intent intent_outaccountinfo = new Intent(this,OutAccountInfoActivity.class);
			intent_outaccountinfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_outaccountinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_outaccountinfo);
			break;
		// �ҵ�����
		case R.id.iv_inaccountinfo:
			Intent intent_inaccountinfo = new Intent(this,InAccountInfoActivity.class);
			intent_inaccountinfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_inaccountinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_inaccountinfo);

			break;
		// ���ݹ���
		case R.id.iv_showinfo:
			Intent intent_showinfo = new Intent(this,ShowAccountInfoActivity.class);
			intent_showinfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_showinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_showinfo);

			break;
		// ϵͳ����
		case R.id.iv_sysset:
			Intent intent_sysset=new Intent(this,SystemSetActivity.class);
			intent_sysset.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_sysset.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_sysset);

			break;
		// ��֧��ǩ
		case R.id.iv_accountflag:
			Intent intent_accountflag=new Intent(this,AccountFlagActivity.class);
			intent_accountflag.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_accountflag.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_accountflag);
			break;
		// �˳�
		case R.id.iv_exit:
			showAskExitDialog();
			break;
		}

	}
	/*
	 * ��ʾѯ���Ƿ��˳��Ի���
	 * 
	 */
	private void showAskExitDialog() {
		// ����builder
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("��ʾ"); // ����
		builder.setMessage("ȷ���˳��ó�����");
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.dismiss();
			}

		});
		builder.setPositiveButton("ȷ��",new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.finish();
				
			}
		});
		builder.create();
		builder.show();
		
	}
	/*
	 * ���ؼ����������������������
	 * 
	 */
	@Override
	public void onBackPressed() {

		backPressCount++;
		if (2 == backPressCount) {
			this.finish();
		} else {
			Toast.makeText(this, "�ٰ�һ���˳�����", 0).show();
		}

	}

}
