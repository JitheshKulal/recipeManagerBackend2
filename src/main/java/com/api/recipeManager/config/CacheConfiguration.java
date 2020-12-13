package com.api.recipeManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.api.recipeManager.model.UserRole;


public class CacheConfiguration {

	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	

	RedisTemplate<String, UserRole> redisTemplate(){
		RedisTemplate<String, UserRole> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
}
