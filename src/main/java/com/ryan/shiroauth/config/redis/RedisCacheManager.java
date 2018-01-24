package com.ryan.shiroauth.config.redis;

import javax.annotation.Resource;

import com.ryan.shiroauth.config.shiro.ShiroCache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lr
 * @date 2018/1/23
 */
public class RedisCacheManager implements CacheManager {
    
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new ShiroCache<K, V>(name, redisTemplate);
    }
    
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
    
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
}