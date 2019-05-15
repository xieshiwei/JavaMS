package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClient {


    /**
     * 单独调用一台Redis服务器
     */
    private Jedis jedis;
    /**
     * 单独调用一台Redis服务器连接池
     */
    private JedisPool jedisPool;
    /**
     * 主从，哨兵客户端连接
     */
    private ShardedJedis shardedJedis;
    /**
     * 主从，哨兵客户端连接池
     */
    private ShardedJedisPool shardedJedisPool;

}
