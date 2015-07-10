package com.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import com.system.model.Login;
import com.system.model.User;

@Component
public class LoginService extends GenericRestService<Login> {
	public LoginService() {
		super("LoginService");
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
}
