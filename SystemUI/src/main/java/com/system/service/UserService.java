package com.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.system.model.User;
import com.system.service.GenericRestService;
import com.system.service.ServiceCallerRest;

public class UserService extends GenericRestService<User> {
	public UserService() {
		super("UserService");
	}

	public User login(String username, String password) {
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("username", username));
		urlParameters.add(new BasicNameValuePair("password", password));
		return gson.fromJson(ServiceCallerRest.getInstance().makePostServiceCall(serviceName + "/login", urlParameters), User.class);
	}
}
