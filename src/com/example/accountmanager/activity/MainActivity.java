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
	ImageView iv_addoutaccount;// 新增支出
	ImageView iv_addinaccount;// 新增收入
	ImageView iv_outaccountinfo;// 我的支出
	ImageView iv_inaccountinfo;// 我的收入
	ImageView iv_showinfo;// 数据管理
	ImageView iv_sysset;// 系统设置
	ImageView iv_accountflag;// 便签管理
	ImageView iv_exit;// 退出
	
	private int backPressCount = 0;//返回键按下次数

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//把当前活动添加到活动管理器中
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
		// 新增支出
		case R.id.iv_addoutaccount:
			Intent intent_addoutaccount = new Intent(this,AddOutAccountActivity.class);
			intent_addoutaccount.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_addoutaccount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_addoutaccount);
			
			break;
		// 新增收入
		case R.id.iv_addinaccount:
			Intent intent_addinaccount = new Intent(this,AddInAccountActivity.class);
			intent_addinaccount.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_addinaccount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_addinaccount);

			break;
		// 我的支出
		case R.id.iv_outaccountinfo:
			Intent intent_outaccountinfo = new Intent(this,OutAccountInfoActivity.class);
			intent_outaccountinfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_outaccountinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_outaccountinfo);
			break;
		// 我的收入
		case R.id.iv_inaccountinfo:
			Intent intent_inaccountinfo = new Intent(this,InAccountInfoActivity.class);
			intent_inaccountinfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_inaccountinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_inaccountinfo);

			break;
		// 数据管理
		case R.id.iv_showinfo:
			Intent intent_showinfo = new Intent(this,ShowAccountInfoActivity.class);
			intent_showinfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_showinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_showinfo);

			break;
		// 系统设置
		case R.id.iv_sysset:
			Intent intent_sysset=new Intent(this,SystemSetActivity.class);
			intent_sysset.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_sysset.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_sysset);

			break;
		// 收支便签
		case R.id.iv_accountflag:
			Intent intent_accountflag=new Intent(this,AccountFlagActivity.class);
			intent_accountflag.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent_accountflag.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_accountflag);
			break;
		// 退出
		case R.id.iv_exit:
			showAskExitDialog();
			break;
		}

	}
	/*
	 * 显示询问是否退出对话框
	 * 
	 */
	private void showAskExitDialog() {
		// 创建builder
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("提示"); // 标题
		builder.setMessage("确定退出该程序吗？");
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.dismiss();
			}

		});
		builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.finish();
				
			}
		});
		builder.create();
		builder.show();
		
	}
	/*
	 * 返回键监听，按下两次提出程序
	 * 
	 */
	@Override
	public void onBackPressed() {

		backPressCount++;
		if (2 == backPressCount) {
			this.finish();
		} else {
			Toast.makeText(this, "再按一次退出程序", 0).show();
		}

	}

}
