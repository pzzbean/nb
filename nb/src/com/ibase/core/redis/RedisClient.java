package com.ibase.core.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibase.core.utils.StringUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * Redis 客户端操作
 * @author admin
 *
 */
public class RedisClient {
    
	protected final static Logger logger = LoggerFactory.getLogger(RedisClient.class);

    public RedisClient() {
    	
    }

    private static JedisPool pool;

    public void init() {
        initRedis();
        checkConnectRedisServer();
    }

    private void initRedis() {
        synchronized (RedisClient.class) {
            if (pool != null) {
                return;
            }
            Properties redisConf = new Properties();
            try {
                redisConf.load(RedisClient.class.getClassLoader().getResourceAsStream("redis.properties"));
            } catch (Exception e) {
                logger.error("初始化失败...", e);
                throw new RuntimeException(e);
            }
            int maxTotal = Integer.parseInt(redisConf.getProperty("redis.pool.maxTotal"));
            int maxIdle = Integer.parseInt(redisConf.getProperty("redis.pool.maxIdle"));
            int maxWaitMillis = Integer.parseInt(redisConf.getProperty("redis.pool.maxWaitMillis"));
            boolean testOnBorrow = Boolean.valueOf(redisConf.getProperty("redis.pool.testOnBorrow"));
            boolean testOnReturn = Boolean.valueOf(redisConf.getProperty("redis.pool.testOnReturn"));
            String ip = redisConf.getProperty("redis.ip");
            int port = Integer.parseInt(redisConf.getProperty("redis.port"));
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxWaitMillis(maxWaitMillis);// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setTestOnBorrow(testOnBorrow);// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
            config.setTestOnReturn(testOnReturn);// 当调用return
                                                 // Object方法时，是否进行有效性检查
            String password = "pass123";
            pool = new JedisPool(config, ip, port,Protocol.DEFAULT_TIMEOUT, password);
        }
    }

    /**
     * 判断Redis服务器是否启动或者是否连接成功
     */
    public boolean checkConnectRedisServer() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String ret = jedis.ping();
            if ("PONG".equals(ret)) {
                logger.info("connect redis server success.");
                return true;
            } else {
                logger.error("connect redis server failure." + ret);
            }
        } catch (Exception e) {
            logger.error("connect redis server failure.", e);
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
        return false;
    }

    /**
     * 将一个或多个 member元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略 假如 key 不存在，则创建一个只包含
     * member 元素作成员的集合 当 key 不是集合类型时，返回一个错误
     * 
     * @param key
     * @param members
     * @return 被添加到集合中的新元素的数量，不包括被忽略的元素
     */
    public <T> Long sadd(String key, T[] members) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[members.length][1];
            for (int i = 0; i < members.length; i++) {
                byteValue[i] = this.serialize(members[i]);
            }
            Long l = jedis.sadd(bKey, byteValue);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略 假如 key 不存在，则创建一个只包含
     * member 元素作成员的集合 当 key 不是集合类型时，返回一个错误
     * 
     * @param key
     * @param members
     * @param seconds
     *            过期时间
     * @return 被添加到集合中的新元素的数量，不包括被忽略的元素
     */
    public <T> Long sadd(String key, T[] members, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[members.length][1];
            for (int i = 0; i < members.length; i++) {
                byteValue[i] = this.serialize(members[i]);
            }
            Long l = jedis.sadd(bKey, byteValue);
            jedis.expire(bKey, seconds);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略 当 key 不是集合类型，返回一个错误
     * 
     * @param key
     * @param members
     * @return 被成功移除的元素的数量，不包括被忽略的元素
     */
    public <T> Long srem(String key, T[] members) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[members.length][1];
            for (int i = 0; i < members.length; i++) {
                byteValue[i] = this.serialize(members[i]);
            }
            Long l = jedis.srem(bKey, byteValue);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 移除并返回集合中的一个随机元素
     * 
     * @param key
     * @return 被移除的随机元素 当 key 不存在或 key 是空集时，返回 nil
     */
    public <T> T spop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            return deserialize(jedis.spop(bKey));
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @return 执行 LPUSH 命令后,列表的长度
     */
    public <T> Long lpush(String key, T[] t) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[t.length][1];
            for (int i = 0; i < t.length; i++) {
                byteValue[i] = this.serialize(t[i]);
            }
            return jedis.lpush(bKey, byteValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @param seconds
     *            过期时间
     * @return 执行 LPUSH 命令后,列表的长度
     */
    public <T> Long lpush(String key, T[] t, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[t.length][1];
            for (int i = 0; i < t.length; i++) {
                byteValue[i] = this.serialize(t[i]);
            }
            Long l = jedis.lpush(bKey, byteValue);
            jedis.expire(bKey, seconds);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @return 执行 LPUSH 命令后,列表的长度
     */
    public <T> Long lpush(String key, T t) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] byteValue = this.serialize(t);
            return jedis.lpush(bKey, byteValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @param seconds
     *            过期时间
     * @return 执行 LPUSH 命令后,列表的长度
     */
    public <T> Long lpush(String key, T t, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] byteValue = this.serialize(t);
            Long l = jedis.lpush(bKey, byteValue);
            jedis.expire(bKey, seconds);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 移除并返回列表 key 的头元素
     * 
     * @param key
     * @return 列表的头元素 当 key 不存在时，返回 nil
     */
    public <T> T lpop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] byteValue = jedis.lpop(bKey);
            return deserialize(byteValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边) 如果 key 不存在，一个空列表会被创建并执行 RPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @return 执行 RPUSH 操作后，表的长度
     */
    public <T> Long rpush(String key, T[] t) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[t.length][1];
            for (int i = 0; i < t.length; i++) {
                byteValue[i] = this.serialize(t[i]);
            }
            return jedis.rpush(bKey, byteValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边) 如果 key 不存在，一个空列表会被创建并执行 RPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @param seconds
     *            过期时间
     * @return 执行 RPUSH 操作后，表的长度
     */
    public <T> Long rpush(String key, T[] t, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] byteValue = new byte[t.length][1];
            for (int i = 0; i < t.length; i++) {
                byteValue[i] = this.serialize(t[i]);
            }
            Long l = jedis.rpush(bKey, byteValue);
            jedis.expire(bKey, seconds);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边) 如果 key 不存在，一个空列表会被创建并执行 RPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @return 执行 RPUSH 操作后，表的长度
     */
    public <T> Long rpush(String key, T t) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] byteValue = this.serialize(t);
            return jedis.rpush(bKey, byteValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边) 如果 key 不存在，一个空列表会被创建并执行 RPUSH 操作 当 key
     * 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param t
     * @param seconds
     *            过期时间
     * @return 执行 RPUSH 操作后，表的长度
     */
    public <T> Long rpush(String key, T t, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] byteValue = this.serialize(t);
            Long l = jedis.rpush(bKey, byteValue);
            jedis.expire(bKey, seconds);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 移除并返回列表 key 的尾元素
     * 
     * @param key
     * @return 列表的尾元素 当 key 不存在时，返回 nil
     */
    public <T> T rpop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] byteValue = jedis.rpop(bKey);
            return deserialize(byteValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定 下标(index)参数 start 和 stop 都以 0
     * 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。 也可以使用负数下标，以 -1 表示列表的最后一个元素，
     * -2 表示列表的倒数第二个元素，以此类推
     * 
     * @param key
     * @param start
     * @param end
     * @return 一个列表，包含指定区间内的元素
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> lrange(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            List<byte[]> returnList = jedis.lrange(bKey, start, end);
            List<T> list = new ArrayList<T>();
            for (byte[] bytes : returnList) {
                list.add((T) deserialize(bytes));
            }
            return list;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 返回列表 key 的长度 如果 key 不存在，则 key 被解释为一个空列表，返回 0 如果 key 不是列表类型，返回一个错误
     * 
     * @param key
     * @return 列表 key 的长度
     */
    public Long llen(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            Long len = jedis.llen(bKey);
            return len;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 返回列表 key 中，下标为 index 的元素 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0
     * 表示列表的第一个元素，以 1 表示列表的第二个元素 也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素 如果
     * key 不是列表类型，返回一个错误
     * 
     * @param key
     * @param index
     * @return 列表中下标为 index 的元素 如果 index 参数的值不在列表的区间范围内(out of range)，返回 nil
     */
    public <T> T lindex(String key, long index) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] value = jedis.lindex(bKey, index);
            return deserialize(value);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将列表 key 下标为 index 的元素的值设置为 value 当 index 参数超出范围，或对一个空列表( key 不存在)进行 LSET
     * 时，返回一个错误
     * 
     * @param key
     * @param index
     * @param value
     * @return 操作成功,返回true,否则返回false
     */
    public <T> boolean lset(String key, long index, T value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            String ret = jedis.lset(bKey, index, serialize(value));
            return "ok".equalsIgnoreCase(ret);
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
        return false;
    }

    /**
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除 当 key 不是列表类型时，返回一个错误
     * 
     * @param key
     * @param start
     * @param end
     * @return 操作成功,返回true,否则返回false
     */
    public boolean ltrim(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            String ret = jedis.ltrim(bKey, start, end);
            return "ok".equalsIgnoreCase(ret);
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
        return false;
    }

    /**
     * 根据参数 count 的值，移除列表中与参数 value 相等的元素 count 的值可以是以下几种： count > 0 :
     * 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count count < 0 : 从表尾开始向表头搜索，移除与 value
     * 相等的元素，数量为 count 的绝对值 count = 0 : 移除表中所有与 value 相等的值
     * 
     * 
     * @param key
     * @param count
     * @param value
     * @return 被移除元素的数量, 当 key 不存在时返回0
     */
    public <T> long lrem(String key, long count, T value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            return jedis.lrem(bKey, count, serialize(value));
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
        return 0;
    }

    /**
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略
     * 
     * @param key
     * @param fields
     * @return 被成功移除的域的数量，不包括被忽略的域
     */
    public Long hdel(String key, String... fields) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[][] bFields = new byte[fields.length][1];
            for (int i = 0; i < fields.length; i++) {
                bFields[i] = StringUtil.getUTF8Bytes(fields[i]);
            }
            return jedis.hdel(bKey, bFields);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 返回哈希表 key 中给定域 field 的值
     * 
     * @param key
     * @param field
     *            指定域
     * @return 给定域的值 当给定域不存在或是给定 key 不存在时，返回 nil
     */
    public <T> T hget(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] bField = StringUtil.getUTF8Bytes(field);
            byte[] value = jedis.hget(bKey, bField);
            return deserialize(value);
        } catch (Exception e) {
            logger.error(e.getMessage());
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 返回哈希表 key 中，所有的域和值 在返回值里，紧跟每个域名(field
     * name)之后是域的值(value)，所以返回值的长度是哈希表大小的两倍
     * 
     * @param key
     * @return 以列表形式返回哈希表的域和域的值 若 key 不存在，返回空列表
     */
    @SuppressWarnings("unchecked")
    public <T> Map<String, T> hgetAll(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            Map<byte[], byte[]> hashmap = jedis.hgetAll(bKey);
            Map<String, T> returnmap = new HashMap<String, T>();
            for (Iterator<Map.Entry<byte[], byte[]>> it = hashmap.entrySet().iterator(); it.hasNext();) {
                Map.Entry<byte[], byte[]> entry = it.next();
                byte[] byteKey = entry.getKey();
                byte[] byteValue = entry.getValue();
                returnmap.put(new String(byteKey), (T) deserialize(byteValue));
            }
            return returnmap;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作 如果域 field
     * 已经存在于哈希表中，旧值将被覆盖
     * 
     * @param key
     * @param field
     * @param value
     * @return 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回
     *         0
     */
    public Long hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] bField = StringUtil.getUTF8Bytes(field);
            byte[] bValue = StringUtil.getUTF8Bytes(value);
            return jedis.hset(bKey, bField, bValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作 如果域 field
     * 已经存在于哈希表中，旧值将被覆盖
     * 
     * @param key
     * @param field
     * @param o
     * @return 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回
     *         0
     */
    public <T> Long hset(String key, String field, T o) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] bField = StringUtil.getUTF8Bytes(field);
            byte[] bValue = this.serialize(o);
            return jedis.hset(bKey, bField, bValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作 如果域 field
     * 已经存在于哈希表中，旧值将被覆盖
     * 
     * @param key
     * @param field
     * @param value
     * @param seconds
     *            过期时间
     * @return 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回
     *         0
     */
    public Long hset(String key, String field, String value, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] bField = StringUtil.getUTF8Bytes(field);
            byte[] bValue = StringUtil.getUTF8Bytes(value);
            Long l = jedis.hset(bKey, bField, bValue);
            jedis.exists(bKey);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作 如果域 field
     * 已经存在于哈希表中，旧值将被覆盖
     * 
     * @param key
     * @param field
     * @param o
     * @param seconds
     *            过期时间
     * @return 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回
     *         0
     */
    public <T> Long hset(String key, String field, T o, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] bField = StringUtil.getUTF8Bytes(field);
            byte[] value = serialize(o);
            Long l = jedis.hset(bKey, bField, value);
            jedis.expire(bField, seconds);
            return l;
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 保存对象至Redis.
     * 
     * @param key
     * @param t
     */
    public <T> void setObject(String key, T t) {
        Jedis jedis = null;
        try {
            if (t == null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("No Object need save in cache.");
                }
                return;
            }
            jedis = pool.getResource();
            byte[] keyBytes = StringUtil.getUTF8Bytes(key);
            jedis.set(keyBytes, this.serialize(t));
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 保存对象并设置过去时间
     * 
     * @param key
     * @param t
     * @param seconds
     */
    public <T> void setObject(String key, T t, int seconds) {
        Jedis jedis = null;
        try {
            if (t == null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("No Object need save in cache.");
                }
                return;
            }
            jedis = pool.getResource();
            byte[] keyBytes = StringUtil.getUTF8Bytes(key);
            jedis.set(keyBytes, this.serialize(t));
            jedis.expire(keyBytes, seconds);
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 获取对象
     * 
     * @param key
     * @return
     */
    public <T> T getObject(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] keyBytes = StringUtil.getUTF8Bytes(key);
            byte[] bytes = jedis.get(keyBytes);
            return deserialize(bytes);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 设置过期时间
     * 
     * @param key
     *            字符串的形式存在
     * @param seconds
     */
    public void expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            jedis.expire(bKey, seconds);
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 删除给定的一个或多个 key 不存在的 key 会被忽略 删除单个字符串类型的 key ，时间复杂度为O(1)
     * 删除单个列表、集合、有序集合或哈希表类型的 key ，时间复杂度为O(M)， M 为以上数据结构内的元素数量
     * 
     * @param key
     * @return 被删除 key 的数量
     */
    public Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            return jedis.del(bKey);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 删除给定的一个或多个 key 不存在的 key 会被忽略 删除单个字符串类型的 key ，时间复杂度为O(1)
     * 删除单个列表、集合、有序集合或哈希表类型的 key ，时间复杂度为O(M)， M 为以上数据结构内的元素数量
     * 
     * @param key
     * @return 被删除 key 的数量
     */
    public Long del(String... keys) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[][] bKeys = new byte[keys.length][1];
            for (int i = 0; i < keys.length; i++) {
                bKeys[i] = StringUtil.getUTF8Bytes(keys[i]);
            }
            return jedis.del(bKeys);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }
    
    /**
     * 递增序列
     * @param key
     * @return
     */
    public Long incr(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            return jedis.incr(bKey);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }
    
    /**
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bKey = StringUtil.getUTF8Bytes(key);
            byte[] bValue = jedis.get(bKey);
            return StringUtil.toUTF8String(bValue);
        } catch (Exception e) {
            returnBrokenResource( jedis);
            return null;
        } finally {
            returnResource(jedis);
        }
    }
    
    /**
     * @param key
     */
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            if(value != null){
                jedis = pool.getResource();
                byte[] bKey = StringUtil.getUTF8Bytes(key);
                byte[] bValue = StringUtil.getUTF8Bytes(value);
                jedis.set(bKey, bValue);
            }
        } catch (Exception e) {
            returnBrokenResource( jedis);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 序列化Object
     * 
     * @param o
     * @return
     */
    public <T> byte[] serialize(T o) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            ois = new ObjectOutputStream(baos);
            ois.writeObject(o);
            ois.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * 序列化Object
     * 
     * @param o
     * @return
     * @throws
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }
            if (bais != null) {
                try {
                    bais.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    
    /**
     * 释放对象
     * 
     * @param pool
     * @param jedis
     */
    public void returnBrokenResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 返回连接池
     * 
     * @param pool
     * @param jedis
     */
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
