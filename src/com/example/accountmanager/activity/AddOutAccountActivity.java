package com.example.accountmanager.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.accountmanager.R;
import com.example.accountmanager.db.DbManager;
import com.example.accountmanager.model.OutAccount;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddOutAccountActivity extends Activity implements OnClickListener {
	EditText et_money, et_time, et_address, et_mark;
	Spinner sp_type;
	Button btn_save, btn_cancle, btn_datePicker;
	DbManager dbManager;
	SimpleDateFormat df;
	Calendar cal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addoutaccount);
		dbManager = DbManager.getInstance(this);
		init();
	}

	private void init() {
		et_money = (EditText) this.findViewById(R.id.et_money);
		et_time = (EditText) this.findViewById(R.id.et_time);
		et_address = (EditText) this.findViewById(R.id.et_address);
		et_mark = (EditText) this.findViewById(R.id.et_mark);
		sp_type = (Spinner) this.findViewById(R.id.sp_type);
		btn_save = (Button) this.findViewById(R.id.btn_save);
		btn_cancle = (Button) this.findViewById(R.id.btn_cancle);
		btn_datePicker = (Button) this.findViewById(R.id.btn_datePicker);
		cal = Calendar.getInstance();
		btn_save.setOnClickListener(this);
		btn_cancle.setOnClickListener(this);
		btn_datePicker.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ѡ������
		case R.id.btn_datePicker:
			setDataPicker();
			break;
		// ����
		case R.id.btn_save:
			saveOutAccountInfo();
			break;
		// ȡ��
		case R.id.btn_cancle:
			showAlertDialog();
			break;

		default:
			break;
		}

	}

	/**************************************** ����ѡ������� ***************************************/
	private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			cal.set(Calendar.YEAR, arg1);
			cal.set(Calendar.MONTH, arg2);
			cal.set(Calendar.DAY_OF_MONTH, arg3);
			updateDate();
		}
	};

	// �� DatePickerDialog �رգ�����������ʾ
	private void updateDate() {
		df = new SimpleDateFormat("yyyy-MM-dd");
		et_time.setText(df.format(cal.getTime()));
	}

	private void setDataPicker() {
		// ����һ�� DatePickerDialog ����ʾ
		new DatePickerDialog(this, listener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH)).show();

	}

	/******************************************************************************************/
	/*
	 * ��������֧������
	 */
	private void saveOutAccountInfo() {
		OutAccount outAccount = new OutAccount();
		String inputMoney = et_money.getText().toString().trim();
		String inputTime = et_time.getText().toString().trim();
		if (TextUtils.isEmpty(inputMoney) || TextUtils.isEmpty(inputTime)) {
			Toast.makeText(this, "����ʱ��Ϊ������", 0).show();
			return;
		}
		outAccount.setMoney(Float.valueOf(inputMoney));
		outAccount.setTime(inputTime);
		outAccount.setType(sp_type.getSelectedItem().toString().trim());
		outAccount.setAddress(et_address.getText().toString().trim());
		outAccount.setMark(et_mark.getText().toString().trim());

		Boolean flag = dbManager.saveOutAccountInfo(outAccount);
		if (flag) {
			// ����ɹ��������ҵ�֧��Activity
			Toast.makeText(this, "����ɹ�", 0).show();
			Intent intent = new Intent(this, OutAccountInfoActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

		} else {
			// ����ʧ��
			Toast.makeText(this, "ϵͳ��æ��������", 0).show();
		}
	}
	/*
	 * ���ֶԻ���ѯ���Ƿ�ȡ������
	 */

	private void showAlertDialog() {

		AlertDialog.Builder dialog = new Builder(this);
		dialog.setTitle("��ʾ");
		dialog.setMessage("ȡ������֧�������أ�");
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
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
