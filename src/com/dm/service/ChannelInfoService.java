package com.dm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dm.dao.ChannelInfoDao;
import com.dm.dao.UserInfoDao;
import com.dm.entity.ChannelInfo;
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
@Service("channelInfoService")
public class ChannelInfoService {

	@Resource
	private ChannelInfoDao channelInfoDao;
	@Resource
	private UserInfoDao userInfoDao;

	public List<ChannelInfo> getChannelInfoList(int userid) {
		List<ChannelInfo> channelInfo = channelInfoDao.getChannelInfoList(userid);
		return channelInfo;
	}
	public List<Map<String,Object>> getChannelStatic(String channelids,String starttime,String endtime) {
		List<Map<String, Object>> list = channelInfoDao.getChannelStatic(channelids, starttime, endtime);
		return list;
	}
	public PageData<ChannelInfo> getChannelInfoByPage(int pageNum, int pageSize,int userId) {
		PageData<ChannelInfo> pageData = new PageData<ChannelInfo>();
		int count = channelInfoDao.getChannelInfoCount(userId);
		if(count == 0){
			return pageData;
		}
		int startNum = PageUtil.getStart(pageNum, pageSize);
		List<ChannelInfo> list = channelInfoDao.getChannelInfoByPage(startNum, pageSize,userId);
		int pageCount = PageUtil.getTotalPage(pageSize, count);
		pageData.setList(list);
		pageData.setPageCount(pageCount);
		return pageData;
	}
	public PageData<ChannelInfo> getChannelListByUser(int pageNum, int pageSize,int userId) {
		PageData<ChannelInfo> pageData = new PageData<ChannelInfo>();
		int userid = userId;
		int count = channelInfoDao.getChannelCountByUserid(userid);
		if(count == 0){
			return pageData;
		}
		int startNum = PageUtil.getStart(pageNum, pageSize);
		List<ChannelInfo> list = channelInfoDao.getChannelInfoByPage(startNum, pageSize,userId);
		int pageCount = PageUtil.getTotalPage(pageSize, count);
		pageData.setList(list);
		pageData.setPageCount(pageCount);
		return pageData;
	}
	public int addChannelInfo(ChannelInfo channelInfo) {
		return channelInfoDao.addChannelInfo(channelInfo);
	}
	public List<Map<String, Object>> getAdminChannelStatic(String starttime, String endtime) {
		List<Map<String, Object>> list1 = channelInfoDao.getChannelStatic(null, starttime, endtime);
		Map<String, Map<String, Object>> map1 = new HashMap<String, Map<String, Object>>();
		for(Map<String, Object> m : list1){
			String channelId = m.get("channelId")+"";
			map1.put(channelId, m);
		}
		List<Map<String, Object>> list2 = channelInfoDao.getKlChannelStatic(null, starttime, endtime);
		Map<String, Map<String, Object>> map2 = new HashMap<String, Map<String, Object>>();
		for(Map<String, Object> m : list2){
			String channelId = m.get("channelId")+"";
			map2.put(channelId, m);
		}
		
		List<Map<String, Object>> list = channelInfoDao.getAdminChannelStatic(null, starttime, endtime);
		for(Map<String, Object> m : list){
			String channelId = m.get("channelId")+"";
			Map<String, Object> m1 = map1.get(channelId);
			Map<String, Object> m2 = map2.get(channelId);
			m.put("zccs", m1==null?0:m1.get("count"));
			m.put("zcje", m1==null?0:m1.get("fee"));
			m.put("klcs", m2==null?0:m2.get("count"));
			m.put("klje", m2==null?0:m2.get("fee"));
		}
		return list;
	}
	public PageData<Map<String, Object>> getOrderlistByPage(Map<String, Object> map) {
		PageData<Map<String, Object>> pageData = new PageData<Map<String, Object>>();
		int count = channelInfoDao.getOrderlistCount(map);
		if(count == 0){
			return pageData;
		}
		int pageNum = (Integer)map.get("page");
		int pageSize = (Integer)map.get("pageSize");
		int startNum = PageUtil.getStart(pageNum, pageSize);
		map.put("startNum", startNum);
		List<Map<String, Object>> list = channelInfoDao.getOrderlistByPage(map);
		int pageCount = PageUtil.getTotalPage(pageSize, count);
		pageData.setList(list);
		pageData.setPageCount(pageCount);
		return pageData;
	}
	public int updatechannelinfo(ChannelInfo channelInfo) {
		return channelInfoDao.updateChannelInfo(channelInfo);
	}
	public int deletechannelinfo(int id) {
		return channelInfoDao.deleteChannelInfo(id);
	}
	public PageData<ChannelInfo> getDetailChannelInfoList(int pageNum, int pageSize,String channelid) {
		PageData<ChannelInfo> pageData = new PageData<ChannelInfo>();
		int count =channelInfoDao.getAllCount(channelid);
		if(count == 0){
			return pageData;
		}
		int startNum = PageUtil.getStart(pageNum, pageSize);
		List<ChannelInfo> list = channelInfoDao.getDetailChannelInfoList(startNum, pageSize, channelid);
		int pageCount = PageUtil.getTotalPage(pageSize, count);
		pageData.setList(list);
		pageData.setPageCount(pageCount);
		return pageData;
	}

	public List<Map<String, Object>> getAllChannel(ChannelUserInfo channelUserInfo) {
		List<Integer> list = channelInfoDao.getChidByUserid(channelUserInfo);
//		System.out.println("list"+list);
		List<Map<String, Object>>list2 = new ArrayList<>();
		if(list.size()>0){
			list2 =channelInfoDao.getChannelidByChid(list);
//			System.out.println(list2);
		}
		List<Map<String, Object>>list3 = channelInfoDao.getAllChannel();
//		System.out.println(list3);
		if (list2.size()>0) {
			list3.removeAll(list2);
		}
//		System.out.println(list3);
		return list3;
	}
	public int addChannelInfoByUserid(ChannelUserInfo channelUserInfo) {
	int userid = channelUserInfo.getUserid();
	int klxs = channelUserInfo.getKlxs();
	String channelid = channelUserInfo.getChannelid();
	ChannelInfo channelInfo = new ChannelInfo();
	channelInfo.setChannelid(channelid);
	channelInfo.setKlxs(klxs);
	channelInfo.setUserid(userid);
	int chid = channelInfoDao.addChannelInfoReturnchid(channelInfo);
//		System.out.println(chid);
//		System.out.println(userid);
		channelUserInfo.setChid(chid);
		channelUserInfo.setUserid(userid);
		return userInfoDao.addChannelidByUserid(channelUserInfo);
	}

	
}