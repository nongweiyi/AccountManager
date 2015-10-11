package com.example.accountmanager.model;
/*
 * 用于保存用户的支出信息
 * */

public class OutAccount {
	private int id;
	private float money;
	private String time;
	private String type;
	private String address;
	private String mark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "OutAccount [id=" + id + ", money=" + money + ", time=" + time + ", type=" + type + ", address="
				+ address + ", mark=" + mark + "]";
	}
	
	
}
