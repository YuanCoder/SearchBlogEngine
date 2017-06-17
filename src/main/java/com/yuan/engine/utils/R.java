package com.yuan.engine.utils;

import com.yuan.engine.constant.BaseConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put(BaseConstants.CODE, 0);
	}
	
	public static R error() {
		return error(-1, BaseConstants.MSG_VALUE_A);
	}
	
	public static R error(String msg) {
		return error(-1, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put(BaseConstants.CODE, code);
		r.put(BaseConstants.MSG_KEY, msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put(BaseConstants.MSG_KEY, msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public R put( Object value) {
		super.put(BaseConstants.DATA, value);
		return this;
	}
}
