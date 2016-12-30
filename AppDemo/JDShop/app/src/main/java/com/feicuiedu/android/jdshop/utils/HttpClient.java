package com.feicuiedu.android.jdshop.utils;


import com.feicuiedu.android.jdshop.bean.Configer;

public class HttpClient {

	public HttpClient() {
		if (Configer.DEBUG) {
			enableDebug();
		}
	}
	
//啓動調試模式
	private void enableDebug() {
		java.util.logging.Logger.getLogger("org.apache.http").setLevel(
				java.util.logging.Level.FINEST);
		java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(
				java.util.logging.Level.FINER);
		java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(
				java.util.logging.Level.OFF);
		
	}
	
	
}
