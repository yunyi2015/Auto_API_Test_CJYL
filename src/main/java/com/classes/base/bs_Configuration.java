package com.classes.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

//@SuppressWarnings("unused")
public class bs_Configuration {


    //private static String configpath = "./IMG.txt";
    private static String configpath = "./conifg.ini";
    private static Properties properties = new Properties();
    FileInputStream fis = null; //read
    OutputStream fos ;

    public bs_Configuration() {
        try {
            fis = new FileInputStream(configpath);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key)  //read
    {
        Object object = properties.get(key);
        return object.toString();
    }

    public void setProperty(String key, String value)  //write
    {
        try {
            fos = new FileOutputStream(configpath,true);// 加载读取文件流
            properties.setProperty(key, value);
            properties.store(fos, null);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//public static void main(String[] args) {
//Configuration ini = new Configuration();
//System.out.println(ini.getProperty("current_selectCase"));
//ini.setProperty("你的标题", "你的内容");
//System.out.println(ini.getProperty("reportFile"));
//}