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
		String response = ServiceCallerRest.getInstance().makePostServiceCall(serviceName + "/login", urlParameters);
		if (response != null) {
			return gson.fromJson(response, User.class);
		} else {
			return null;
		}
	}

	public User login1(String username, String password) {
		String content = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
		String response = ServiceCallerRest.getInstance().makePostServiceCall(serviceName + "/login", content);
		if (response != null) {
			return gson.fromJson(response, User.class);
		} else {
			return null;
		}
	}

	public User addNew(User user) {
		String response = ServiceCallerRest.getInstance().makePostServiceCall(serviceName + "/create", gson.toJson(user));
		if (response != null) {
			return gson.fromJson(response, User.class);
		} else {
			return null;
		}
	}
}
