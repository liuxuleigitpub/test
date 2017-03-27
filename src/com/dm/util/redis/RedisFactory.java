package com.dm.util.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.dm.SpringContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public class RedisFactory
{
    /**
     * 1分钟过期
     * */
    public static final int               ONE_MINUTE       = 60;
    /**
     * 1小时过期
     * */
    public static final int               ONE_HOUR         = 60 * 60;
    /**
     * 1天过期
     * */
    public static final int               ONE_DAY          = 60 * 60 * 24;
    /**
     * 2天过期
     * */
    public static final int               TWO_DAY          = 2 * 60 * 60 * 24;
    /**
     * 1周过期
     * */
    public static final int               ONE_WEEK         = 60 * 60 * 24 * 7;
    /**
     * 1月过期
     * */
    public static final int               ONE_MONTH        = 60 * 60 * 24 * 30; // 最大不能超过30天
    /**
     * 永不过期
     * */
    public static final int               ALWAYS           = 0;

    private static JedisConnectionFactory redisConnFactory = null;
    private static JedisPool pool = null;

    private static Jedis getInstance()
    {
        if (pool == null)
        {
            redisConnFactory = (JedisConnectionFactory) SpringContext.getContext()
                    .getBean("redisConnectionFactory");
            pool = new JedisPool(redisConnFactory.getPoolConfig(), redisConnFactory.getHostName(), redisConnFactory.getPort(),redisConnFactory.getTimeout()); 
        }
        return pool.getResource();
    }

//    public static void close(Jedis instance)
//    {
//        pool.returnResource(instance)
//        if (redisClient != null)
//        {
//            redisClient.close();
//            redisClient = null;
//        }
//    }

    public static void setRedisConnFactory(
            JedisConnectionFactory redisConnFactory)
    {
        if (redisConnFactory == null)
        {
            RedisFactory.redisConnFactory = redisConnFactory;
        }
    }

    /**
     * 从指定的列表右边出队,添加到目的列表中
     * 
     * @param srckey
     *            源列表
     * @param dstkey
     *            　目的列表
     * @return
     */
    public static String rpoppush(String srckey, String dstkey)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.rpoplpush(srckey, dstkey);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 从队列的左边取出一条数据
     * 
     * @param key
     *            　列表名
     * @return
     */
    public static String lpop(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.lpop(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 从队列的右边取出一条数据
     * 
     * @param key
     *            列表名
     * @return
     */
    public static String rpop(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.rpop(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 把一个值添加到对应列表中
     * 
     * @param key
     *            列表名
     * @param index
     *            　添加的位置
     * @param value
     *            　数据
     * @return
     */
    public static String lset(String key, long index, String value)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.lset(key, index, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static Long lpush(String key, String value)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            String[] strs = new String[1];
            strs[0] = value;
            return redis.lpush(key, strs);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
    /**
     * 右放数据
     */
    public static Long rpush(String key, String value)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            String[] strs = new String[1];
            strs[0] = value;
            return redis.rpush(key, strs);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 把所有数据添加到一个列表中
     * 
     * @param key
     *            列表名
     * @param values
     *            　数据
     * @return
     */
    public static Long lpush(String key, String[] values)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.lpush(key, values);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 把所有数据添加到一个列表中,并且设置列表的存活时间
     * 
     * @param key
     *            列表名
     * @param values
     *            数据
     * @param liveTime
     *            存活时间--单位(秒)
     * @return
     */
    public static Long lpush(String key, String[] values, int liveTime)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            Long result = redis.lpush(key, values);
            redis.expire(key, liveTime);
            return result;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 删除列表中对应值的元素
     * 
     * @param key
     *            列表名
     * @param count
     *            删除多少个相同的元素
     * @param value
     *            数据
     * @return
     */
    public static Long lrem(String key, long count, String value)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.lrem(key, count, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
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
    public static List<String> lrange(String key, long start, long end)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.lrange(key, start, end);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static Long llen(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.llen(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 通过key删除（字节）
     * 
     * @param key
     */
    public static void del(byte[] key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.del(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 通过key删除
     * 
     * @param key
     */
    public static void del(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.del(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 添加key value 并且设置存活时间(byte)
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void set(byte[] key, byte[] value, int liveTime)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.set(key, value);
            redis.expire(key, liveTime);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 添加key value 并且设置存活时间
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void set(String key, String value, int liveTime)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.set(key, value);
            redis.expire(key, liveTime);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 添加key value
     * 
     * @param key
     * @param value
     */
    public static void set(String key, String value)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.set(key, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 添加key value (字节)(序列化)
     * 
     * @param key
     * @param value
     */
    public static void set(byte[] key, byte[] value)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.set(key, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 获取redis value (String)
     * 
     * @param key
     * @return
     */
    public static String get(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            String value = redis.get(key);
            return value;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 获取redis value (byte [] )(反序列化)
     * 
     * @param key
     * @return
     */
    public static byte[] get(byte[] key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.get(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static String set(String key, Map<String, String> map)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.hmset(key, map);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static List<String> get(String key, String... fields)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.hmget(key, fields);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
    /**
     * 如果在插入的过程用，参数中有的成员在Set中已经存在，该成员将被忽略，
     * 而其它成员仍将会被正常插入。如果执行该命令之前，该Key并不存在，
     * 该命令将会创建一个新的Set，此后再将参数中的成员陆续插入。
     * 如果该Key的Value不是Set类型，该命令将返回相关的错误信息。
     * @param key
     * @param fields
     * @return
     */
    public static Long sadd(String key, String... fields)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.sadd(key, fields);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
    /**
     * 如果在插入的过程用，参数中有的成员在Set中已经存在，该成员将被忽略，
     * 而其它成员仍将会被正常插入。如果执行该命令之前，该Key并不存在，
     * 该命令将会创建一个新的Set，此后再将参数中的成员陆续插入。
     * 如果该Key的Value不是Set类型，该命令将返回相关的错误信息。
     * @param key
     * @param fields
     * @return
     */
    public static Long sadd(String key, int liveTime, String... fields)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            Long res = redis.sadd(key, fields);
            redis.expire(key, liveTime);
            return res;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
    /**
     * 获取Set中成员的数量。返回Set中成员的数量，如果该Key并不存在，返回0。
     * @param key
     * @return
     */
    public static Long scard(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.scard(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
    /**
     * 判断参数中指定成员是否已经存在于与Key相关联的Set集合中。
     * @param key
     * @param member
     * @return
     */
    public static boolean sismember(String key, String member)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.sismember(key, member);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return false;
    }
    /**
     * 返回Set中所有的成员。
     * @param key
     * @param member
     * @return
     */
    public static Set<String> smembers (String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.smembers(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
    /**
     * 从Set中实际移除的成员数量，如果没有则返回0。
     * @param key
     * @param member
     * @return
     */
    public static Long srem (String key,String... member)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.srem(key, member);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 通过正则匹配keys
     * 
     * @param pattern
     * @return
     */
    public static Set<String> keys(String pattern)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.keys(pattern);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static Long publish(String channel, String message)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.publish(channel, message);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static void psubscribe(JedisPubSub listener, String... patterns)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.psubscribe(listener, patterns);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    public static void subscribe(JedisPubSub listener, String... patterns)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.subscribe(listener, patterns);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    public static void incr(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.incr(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }
    
    public static void incr(String key, int liveTime)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.incr(key);
            redis.expire(key, liveTime);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }
   
    /**
     * 添加key value 并且设置存活时间
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void expire(String key, int liveTime)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            redis.expire(key, liveTime);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }
    
    /**
     * 检查key是否已经存在
     * 
     * @param key
     * @return
     */
    public static Boolean exists(String key)
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.exists(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 清空redis 所有数据
     * 
     * @return
     */
    public static String flushDB()
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.flushDB();
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;

    }

    /**
     * 查看redis里有多少数据
     */
    public static Long dbSize()
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.dbSize();
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 检查是否连接成功
     * 
     * @return
     */
    public static String ping()
    {
        Jedis redis = null;
        try
        {
            redis = getInstance();
            return redis.ping();
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }
}
