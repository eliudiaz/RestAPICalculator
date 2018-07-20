package com.upwork.computation.config;

import com.upwork.computation.controller.ComputationsEndpoint;
import com.upwork.computation.controller.ReverseEndpoint;
import com.upwork.computation.controller.Endpoint;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(Endpoint.class);
		register(ReverseEndpoint.class);
		register(ComputationsEndpoint.class);
	}

}
