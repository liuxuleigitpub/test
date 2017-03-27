package com.dm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dm.dao.UserInfoDao;
import com.dm.entity.ChannelUserInfo;
import com.dm.entity.UserInfo;
import com.dm.util.PageData;
import com.dm.util.PageUtil;

/**
 * MvInfoService实现类
 * 
 * @author Administrator
 *
 */
@Service("userInfoService")
public class UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;

	public UserInfo getUserInfo(String username, String password) {
		UserInfo userInfo = userInfoDao.getUserInfo(username, password);
		return userInfo;
	}
	
	public PageData<UserInfo> getUserInfoByPage(int pageNum, int pageSize, String userName,int usertype) {
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		int count = userInfoDao.getUserInfoCount(userName,usertype);
		if(count == 0){
			return pageData;
		}
		int startNum = PageUtil.getStart(pageNum, pageSize);
		List<UserInfo> list = userInfoDao.getUserInfoByPage(startNum, pageSize, userName,usertype);
		int pageCount = PageUtil.getTotalPage(pageSize, count);
		pageData.setList(list);
		pageData.setPageCount(pageCount);
		return pageData;
	}

	public int addUserInfo(UserInfo userInfo) {
		return userInfoDao.addUserInfo(userInfo);
	}

	public int updateUserInfo(UserInfo userInfo) {
		return userInfoDao.updateUserInfo(userInfo);
	}
	public int deleteUserInfo(UserInfo userInfo) {
		userInfoDao.deleteUserByChid(userInfo);
		return userInfoDao.deleteUserInfo(userInfo);
	}

	public PageData<UserInfo> getChannelUserByPage(int pageNum, int pageSize, int chid) {
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		List<Integer> id = userInfoDao.getUserId(chid);
		int count = id.size();
		if(count == 0){
			return pageData;
		}
		int startNum = PageUtil.getStart(pageNum, pageSize);
		int pageCount = PageUtil.getTotalPage(pageSize, count);
		List<UserInfo> list=null;
		if (id.size()>1) {
			list = userInfoDao.getChannelUserByPageList(startNum, pageSize, id);
		}else {
		int userid = id.get(0);
			 list = userInfoDao.getChannelUserByPage(startNum, pageSize, userid);
		}
		
		pageData.setList(list);
		pageData.setPageCount(pageCount);
		return pageData;
	}

	public int addUserByChannel(UserInfo userInfo) {
		int chid = userInfo.getChid();
		userInfoDao.addUserByChannel(userInfo);
		int userid =userInfo.getId();
		System.out.println(userid+"<>"+chid);
		return userInfoDao.addUseridAndChid(userid,chid);
	}

	public int updateUserByChannel(UserInfo userInfo) {
		return userInfoDao.updateUserByChannel(userInfo);
	}

	public int addChannelidByUserid(ChannelUserInfo channelUserInfo) {
		int userid = channelUserInfo.getUserid();
		int chid = 	userInfoDao.GetChidByChannelid(channelUserInfo);
		channelUserInfo.setChid(chid);
		channelUserInfo.setUserid(userid);
		return userInfoDao.addChannelidByUserid(channelUserInfo);
	}

}