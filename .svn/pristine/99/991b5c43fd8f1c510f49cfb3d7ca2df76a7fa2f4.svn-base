package com.dm.util.redis;

public class MqRedisDb {

	/**
	 * 将java对象转换成json字符串 存入消息队列
	 *
	 * @param bean
	 * @return
	 */
	public static Long add(String redisKey,String value) {
		if(value == null){
			return null;
		}
		return RedisFactory.lpush(redisKey, value);
	}

	/**
	 * 返回指定列表范围内的元素
	 * 
	 * @param key
	 *            列表名
	 * @param start
	 *            开始位置
	 * @param end
	 *            结束位置
	 * @return
	 */
	public static String lpop(String redisKey) {
		if(redisKey == null){
			return null;
		}
		return RedisFactory.lpop(redisKey);
	}

}
