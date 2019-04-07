package com.blueBottleProject.misc;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


@Provider
@PreMatching
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

	    @Override
	    public void filter(ContainerRequestContext request,
	            ContainerResponseContext response) throws IOException {
	        response.getHeaders().add("Access-Control-Allow-Origin", "*");
	        response.getHeaders().add("Access-Control-Allow-Headers",
	                "origin, content-type, accept, authorization");
	        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
	        response.getHeaders().add("Access-Control-Allow-Methods",
	                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	    }
	    
	    @Override
		public void filter(ContainerRequestContext request) throws IOException {
			if (isPreflightRequest(request)) {
	            request.abortWith(Response.ok().build());
	            return;
	        }
		}

		private boolean isPreflightRequest(ContainerRequestContext request) {
			 return request.getHeaderString("Origin") != null
		                && request.getMethod().equalsIgnoreCase("OPTIONS");
		}
}
