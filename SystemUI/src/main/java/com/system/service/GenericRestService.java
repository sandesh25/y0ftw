package com.system.service;

import org.springframework.http.HttpMethod;

import com.google.gson.Gson;
import com.system.model.MyType;

public class GenericRestService<T> {
	protected Gson gson = new Gson();
	protected String serviceName;

	public GenericRestService(String serviceName) {
		this.serviceName = serviceName;
	}

	public MyType add(T instance) {
		return gson.fromJson(ServiceCallerRest.getInstance().makePostServiceCall(serviceName + "/add", "{\"newObject\":" + gson.toJson(instance) + "}"), MyType.class);
	}

	public MyType update(T instance) {
		return gson.fromJson(ServiceCallerRest.getInstance().makePostServiceCall(serviceName + "/update", "{\"existingObject\":" + gson.toJson(instance) + "}"), MyType.class);
	}

	public MyType get(Long id) {
		return gson.fromJson(ServiceCallerRest.getInstance().makeGetServiceCall(serviceName + "/get", HttpMethod.GET), MyType.class);
	}
}
