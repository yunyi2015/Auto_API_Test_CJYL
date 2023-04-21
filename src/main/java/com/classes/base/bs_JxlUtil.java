package com.classes.base;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 读取excel
 * @author hongquan
 *
 */

public class bs_JxlUtil {
      
    private String FilePath;
    private String CaseID;
    //使用LIST存储数据
    private ArrayList<String[]> list = new ArrayList();
    //使用MAP存储数据
    private Map<String, String> map = new HashMap<String, String>();
      
    
    public bs_JxlUtil(String FilePath, String CaseID){
        this.FilePath = FilePath;
        this.CaseID = CaseID;
    }  
    
    //使用MAP存储数据
    public Map<String, String> ReadExcelMap(){  
    	
    	//定义
    	Cell head = null;
        Cell body = null;  

        //创建输入流  
        InputStream stream = null;
		try {
			stream = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        //获取Excel文件对象  
        Workbook wBook = null;
		try {
			wBook = Workbook.getWorkbook(stream);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
        //获取文件的指定工作表 默认的第一个  
        Sheet sheet = wBook.getSheet(0);  
        //行数(表头的目录不需要，从1开始)  
        //System.out.print(sheet.getRows());
        for(int i=1; i<sheet.getRows(); i++){  
            body = sheet.getCell(1,i); 
            if (CaseID.equals(body.getContents().trim())) {
            	for(int j=5; j<sheet.getColumns(); j++){
                	head = sheet.getCell(j,0);
                	body = sheet.getCell(j,i); 
                	//把刚获取的列存入list  
                	map.put(head.getContents().trim(),body.getContents().trim()); 
	            }
            }
        }
        wBook.close();
        return map;
    }  
    
    
    
    //使用LIST存储数据
    public ArrayList<String[]> ReadExcelList(){  
        //创建输入流  
        InputStream stream = null;
		try {
			stream = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        //获取Excel文件对象  
        Workbook wBook = null;
		try {
			wBook = Workbook.getWorkbook(stream);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
        //获取文件的指定工作表 默认的第一个  
        Sheet sheet = wBook.getSheet(0);    
        //行数(表头的目录不需要，从1开始)  
        //System.out.print(sheet.getRows());
        String[] str = new String[sheet.getColumns()-6];
        for(int i=1; i<sheet.getRows(); i++){  
            Cell cell = null;  
            cell = sheet.getCell(1,i); 
            if (CaseID.equals(cell.getContents())) {
            	//创建一个数组 用来存储每一列的值
            	for(int j=5; j<sheet.getColumns(); j++){
	            	cell = sheet.getCell(j,i); 
	            	str[j-5] = cell.getContents();
	            	//把刚获取的列存入list   
	            }
            }
            
            //列数  
//          for(int j=0; j<sheet.getColumns(); j++){  
//            	//获取第i行，第j列的值  
//            	cell = sheet.getCell(j,i); 
//            	str[j] = cell.getContents();  
//          }   
        }
        wBook.close();
        list.add(str);
        return list;
    }  
    
    //test
//    public void outData(){  
//         String[] str = (String[])list.get(0);  
//         for(int j=0;j<str.length;j++){  
//        	 System.out.print(str[j]+'\t');  
//         }  
//         System.out.println();  
//    }  
//      
//    public static void main(String args[]) throws BiffException, IOException{  
//    	bs_JxlUtil excel = new bs_JxlUtil("./testcase/caiwu.xls","testNGtc.caiwu.account.ng_AddAccount");  
//        excel.ReadExcelList();  
//        excel.outData();  
//        
//    }  
}
