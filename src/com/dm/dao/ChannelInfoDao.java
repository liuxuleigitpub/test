package com.dm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dm.entity.ChannelInfo;
import com.dm.entity.ChannelUserInfo;
import com.dm.util.PageData;

public interface ChannelInfoDao {
	
	public List<ChannelInfo> getChannelInfoList(@Param("userid")int userid);
	public List<ChannelInfo> getDetailChannelInfoList(@Param("startNum")int startNum, @Param("pageSize")int pageSize,@Param("channelid")String channelid);
	
	public List<Map<String, Object>> getChannelStatic(@Param("channelids")String channelids,
			@Param("starttime")String starttime, @Param("endtime")String endtime);

	public int getChannelInfoCount(@Param("userId")int userId);

	public List<ChannelInfo> getChannelInfoByPage(@Param("startNum")int startNum, @Param("pageSize")int pageSize,
			@Param("userId")int userId);

	public int addChannelInfo(@Param("channelInfo")ChannelInfo channelInfo);
	
	public int updateChannelInfo(@Param("channelInfo")ChannelInfo channelInfo);
	
	public int deleteChannelInfo(@Param("id")int id);
	
	public List<Map<String, Object>> getAdminChannelStatic(@Param("channelids")String channelids,
			@Param("starttime")String starttime, @Param("endtime")String endtime);

	public List<Map<String, Object>> getKlChannelStatic(@Param("channelids")String channelids,
			@Param("starttime")String starttime, @Param("endtime")String endtime);

	public int getOrderlistCount(Map<String, Object> map);

	public List<Map<String, Object>> getOrderlistByPage(Map<String, Object> map);
	public int getAllCount(@Param("channelid")String channelid);
	public List<Map<String, Object>> getAllChannel();
	public List<Integer> getChidByUserid(ChannelUserInfo channelUserInfo);
	public List<Map<String, Object>> getChannelidByChid(List<Integer> list);
	public int getChannelCountByUserid(@Param("userid")int userid);
	public int addChannelInfoReturnchid(@Param("channelInfo")ChannelInfo channelInfo);
}
