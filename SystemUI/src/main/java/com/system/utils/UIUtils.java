package com.system.utils;

public class UIUtils {
	private static String userToken;

	public static void setUserToken(String userToken) {
		UIUtils.userToken = userToken;
	}

	public static String getUserToken() {
		return userToken;
	}
}
