package com.system.parser;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

public abstract class GenericParser<T> {
	private Gson gson = new Gson();
	private JsonParser jsonParser = new JsonParser();

	public String toJson(T instance) {
		return gson.toJson(instance);
	}

}
