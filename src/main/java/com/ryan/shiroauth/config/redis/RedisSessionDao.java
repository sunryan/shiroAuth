package com.ryan.shiroauth.config.redis;


import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis实现共享session
 * @author lr
 * @date 2018/1/23
 */
@Component
public class RedisSessionDao extends EnterpriseCacheSessionDAO {
    
    private static Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);
    
    /**
     * session 在redis过期时间是30分钟30*60
     */
    private static long EXPIRE_TIME = 1800;
    
    /**
     * redis key前缀
     */
    private static String PREFIX = "ryan-shiro-session:";
    
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    
    // 创建session，保存到数据库
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        logger.debug("创建session:{}", session.getId());
        redisTemplate.opsForValue().set(PREFIX + sessionId.toString(), session);
        return sessionId;
    }
    
    // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.debug("获取session:{}", sessionId);
        // 先从缓存中获取session，如果没有再去数据库中获取
        Session session = super.doReadSession(sessionId);
        if (session == null) {
            session = (Session) redisTemplate.opsForValue().get(PREFIX + sessionId.toString());
        }
        return session;
    }
    
    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        logger.debug("更新session:{}", session.getId());
        String key = PREFIX + session.getId().toString();
        if (!redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key, session);
        }
        redisTemplate.expire(key, EXPIRE_TIME, TimeUnit.SECONDS);
    }
    
    // 删除session
    @Override
    protected void doDelete(Session session) {
        logger.debug("删除session:{}", session.getId());
        super.doDelete(session);
        redisTemplate.delete(PREFIX + session.getId().toString());
    }
}