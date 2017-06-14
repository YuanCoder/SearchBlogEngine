package com.yuan.engine.utils;

 
/**
 * 字符串工具类
 * @author Yuanjp
 * @date 2017年6月7日 下午4:52:07
 *
 */
public class StringUtils {
	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	 
}
