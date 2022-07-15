package org.com.panorama.utility;

import redis.clients.jedis.Jedis;

public class JedisUtility {

	private Jedis jedis;
	
	public JedisUtility() {
		/*Host : 127.0.0.1, Port : 6379*/
		jedis = new Jedis();
	}
	
	public void save(String key, String value) {
		jedis.set(key, value);
	}
	
	public String get(String key) {
		return jedis.get(key);
	}
	
}
