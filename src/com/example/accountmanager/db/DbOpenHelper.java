package com.example.accountmanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {
	/*tb_pwd
	密码信息表
	*/
	private static final String CREATE_TB_PWD="create table tb_pwd("
			+ "password varchar(20))";
			
	/*tb_outaccount
	支出管理表
	*/
	private static final String CREATE_TB_OUTACCOUNT="create table tb_outaccount("
			+ "_id Integer primary key autoincrement,"
			+ "money decimal,"
			+ "time varchar(10),"
			+ "type varchar(10),"
			+ "address varchar(100),"
			+ "mark varchar(200))";

	/*tb_inaccount
	收入信息表
	*/
	private static final String CREATE_TB_INACCOUNT="create table tb_inaccount("
			+ "_id Integer primary key autoincrement,"
			+ "money decimal,"
			+ "time varchar(10),"
			+ "type varchar(10),"
			+ "handler varchar(100),"
			+ "mark varchar(200))";

	/*tb_flag
	便签信息表
	*/
	private static final String CREATE_TB_FLAG="create table tb_flag("
			+ "_id Integer primary key autoincrement,"
			+ "flag varchar(200))";
	
	

	public DbOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TB_PWD);
		db.execSQL(CREATE_TB_OUTACCOUNT);
		db.execSQL(CREATE_TB_INACCOUNT);
		db.execSQL(CREATE_TB_FLAG);
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}

}
