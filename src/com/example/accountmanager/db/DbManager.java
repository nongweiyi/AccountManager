package com.example.accountmanager.db;

import com.example.accountmanager.model.Flag;
import com.example.accountmanager.model.InAccount;
import com.example.accountmanager.model.OutAccount;
import com.example.accountmanager.model.Password;
import com.example.accountmanager.util.LogUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public class DbManager {
	private static DbManager dbManager;
	private static final String DB_NAME = "db_account_manager";
	private static final int VERSION = 1;
	private SQLiteDatabase db;

	/*
	 * �����췽��˽�л�
	 */
	private DbManager(Context context) {
		DbOpenHelper helper = new DbOpenHelper(context, DB_NAME, null, VERSION);
		db = helper.getWritableDatabase();
	}

	// ��ȡDbManagerʵ��
	public synchronized static DbManager getInstance(Context context) {
		if (dbManager == null) {
			dbManager = new DbManager(context);
		}
		return dbManager;
	}

	/*
	 * �ж������Ƿ����
	 */
	public Boolean isPasswordExist(Password password) {
		// û�в�������ʱ
		if (password == null) {
			Cursor cursor = db.query("tb_pwd", null, null, null, null, null,
					null);
			int i = cursor.getCount();
			if (i != 0) {
				return true;
			} else {
				return false;
			}
			// �в�������ʱ
		} else {
			Cursor cursor = db.query("tb_pwd", null, "password=?",
					new String[] { password.getPassword() }, null, null, null);
			int i = cursor.getCount();
			if (i != 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	/*
	 * �����û�����
	 */
	public Boolean savePassord(Password password) {
		if (password != null) {
			ContentValues values = new ContentValues();
			values.put("password", password.getPassword());
			long i = db.insert("tb_pwd", null, values);
			if (i != 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	/*
	 * ��������֧������
	 */
	public Boolean saveOutAccountInfo(OutAccount outAccount) {
		if (outAccount != null) {
			ContentValues values = new ContentValues();
			values.put("money", outAccount.getMoney());
			values.put("time", outAccount.getTime());
			values.put("type", outAccount.getType());
			values.put("address", outAccount.getAddress());
			values.put("mark", outAccount.getMark());
			long i = db.insert("tb_outaccount", null, values);
			if (i != 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/*
	 * ��ѯ֧������
	 */
	public Cursor loadOutAccountInfo() {
		return db.query("tb_outaccount", null, null, null, null, null,
				"_id ASC");
	}

	/*
	 * ����������������
	 */
	public Boolean saveInAccountInfo(InAccount inAccount) {
		if (inAccount != null) {
			ContentValues values = new ContentValues();
			values.put("money", inAccount.getMoney());
			values.put("time", inAccount.getTime());
			values.put("type", inAccount.getType());
			values.put("handler", inAccount.getHandler());
			values.put("mark", inAccount.getMark());
			long i = db.insert("tb_inaccount", null, values);
			if (i != 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/*
	 * ��ѯ��������
	 */
	public Cursor loadInAccountInfo() {

		return db
				.query("tb_inaccount", null, null, null, null, null, "_id ASC");
	}

	public Boolean udaptePassord(String oldPassword, Password password) {
		if (password != null) {
			ContentValues values = new ContentValues();
			values.put("password", password.getPassword());
			int i = db.update("tb_pwd", values, "password=?",
					new String[] { oldPassword });
			if (i != 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	/*
	 * �����ǩ
	 */
	public Boolean saveFlag(Flag flag) {
		if (flag != null) {
			ContentValues values = new ContentValues();
			values.put("flag", flag.getFlag());
			long i = db.insert("tb_flag", null, values);
			if (i != 0) {
				return true;
			} else {
				return false;
			}
		}
		return null;
	}

	/*
	 * �������еı�ǩ����
	 */
	public Cursor loadAccountFlag() {
		return db.query("tb_flag", null, null, null, null, null, "_id ASC");
	}
}
