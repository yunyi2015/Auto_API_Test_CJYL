package com.classes.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 读取用例文件，取得当前类对应的参数
 * @author hongquan
 *
 */

public class bs_GetParameter {
	private static String ExcUrl; 
	private static Map<String, String> map = new HashMap<String, String>();
	
	public static Map<String, String> GetParameter(String CaseID){
		
		bs_Configuration ini = new bs_Configuration();  
		ExcUrl = ini.getProperty("TestCase"); 
		bs_JxlUtil Excel = new bs_JxlUtil(ExcUrl,CaseID); 
		//读取Excel中的参数
		map = Excel.ReadExcelMap();
		return map;
	}
}
