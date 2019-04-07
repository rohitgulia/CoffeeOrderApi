package com.blueBottleProject.misc;

import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;

import com.blueBottleProject.redis.RedisConnectionBinder;

@Provider
public class AppRegister extends ResourceConfig {

	public AppRegister() {
    packages("com.blueBottleProject.misc");
    register(new RedisConnectionBinder());
 }
}