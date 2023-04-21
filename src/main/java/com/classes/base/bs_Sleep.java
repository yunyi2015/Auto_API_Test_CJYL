package com.classes.base;

//@SuppressWarnings("unused")
public class bs_Sleep {
	public static void ThreadSleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
