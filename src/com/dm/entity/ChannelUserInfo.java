package com.dm.entity;


public class ChannelUserInfo {
	private int userid;
	private int id;
	private String createtime;
	private int chid;
	private String channelid;
	private int klxs;
	
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public int getChid() {
		return chid;
	}
	public void setChid(int chid) {
		this.chid = chid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getKlxs() {
		return klxs;
	}
	public void setKlxs(int klxs) {
		this.klxs = klxs;
	}
	
}
