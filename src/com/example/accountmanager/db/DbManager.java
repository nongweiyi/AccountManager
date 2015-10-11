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
	 * 将构造方法私有化
	 */
	private DbManager(Context context) {
		DbOpenHelper helper = new DbOpenHelper(context, DB_NAME, null, VERSION);
		db = helper.getWritableDatabase();
	}

	// 获取DbManager实例
	public synchronized static DbManager getInstance(Context context) {
		if (dbManager == null) {
			dbManager = new DbManager(context);
		}
		return dbManager;
	}

	/*
	 * 判断密码是否存在
	 */
	public Boolean isPasswordExist(Password password) {
		// 没有参数传入时
		if (password == null) {
			Cursor cursor = db.query("tb_pwd", null, null, null, null, null,
					null);
			int i = cursor.getCount();
			if (i != 0) {
				return true;
			} else {
				return false;
			}
			// 有参数传入时
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
	 * 保存用户密码
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
	 * 保存新增支出数据
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
	 * 查询支出数据
	 */
	public Cursor loadOutAccountInfo() {
		return db.query("tb_outaccount", null, null, null, null, null,
				"_id ASC");
	}

	/*
	 * 保存新增收入数据
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
	 * 查询收入数据
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
	 * 保存便签
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
	 * 加载所有的便签数据
	 */
	public Cursor loadAccountFlag() {
		return db.query("tb_flag", null, null, null, null, null, "_id ASC");
	}
}
