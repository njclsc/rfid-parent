package com.pyyh.login.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisDataSource {
	@Value("${redis.ip}")
	private String ip;
	@Value("${redis.port}")
	private String port;
	@Value("${redis.pool.maxTotal}")
	private String maxTotal;
	@Value("${redis.pool.maxIdle}")
	private String maxIdle;
	@Value("${redis.pool.minIdle}")
	private String minIdle;
	@Value("${redis.pool.maxWaitMillis}")
	private String maxWaitMillis;
	@Value("${redis.pool.testOnBorrow}")
	private String testOnBorrow;
	@Value("${redis.pool.testOnReturn}")
	private String testOnReturn;
	@Value("${redis.pool.testOnCreate}")
	private String testOnCreate;
	@Value("${redis.pool.timeBetweenEvictionRunsMillis}")
	private String timeBetweenEvictionRunsMillis;
	@Value("${redis.pool.testWhileIdle}")
	private String testWhileIdle;
	@Value("${redis.pool.numTestsPerEvictionRun}")
	private String numTestsPerEvictionRun;
	@Bean(name = "redisSource")
	public JedisPool initRedisSource(){
		JedisPoolConfig config = new JedisPoolConfig();
    	config.setMaxTotal(Integer.parseInt(maxTotal));
    	config.setMaxIdle(Integer.parseInt(maxIdle));
    	config.setMinIdle(Integer.parseInt(minIdle));
    	config.setMaxWaitMillis(Long.parseLong(maxWaitMillis));
    	config.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
    	config.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
    	config.setTestOnCreate(Boolean.parseBoolean(testOnCreate));
    	config.setTimeBetweenEvictionRunsMillis(Long.parseLong(timeBetweenEvictionRunsMillis));
    	config.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
    	config.setNumTestsPerEvictionRun(Integer.parseInt(numTestsPerEvictionRun));
    	JedisPool pool = new JedisPool(config, ip, Integer.parseInt(port));
    	return pool;
	}
}
