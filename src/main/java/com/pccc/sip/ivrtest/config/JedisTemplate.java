package com.pccc.sip.ivrtest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisTemplate {

    @Autowired
    private JedisPool jedisPool;

    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key, value);
        } catch (Exception e) {
            return "-1";
        } finally {
            jedisPool.close();

        }
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            return "-1";
        } finally {
            jedis.close();
        }
    }

    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.del(key);
        } catch (Exception e) {
            return -1L;
        } finally {
            jedis.close();
        }
    }

    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            return false;
        } finally {
            jedis.close();
        }
    }

    public Long lpush(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.lpush(key,value);
        } catch (Exception e) {
            return -1L;
        } finally {
            jedisPool.close();

        }
    }

    public String rpop(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.rpop(key);
        } catch (Exception e) {
            return "-1";
        } finally {
            jedisPool.close();
        }
    }
}

