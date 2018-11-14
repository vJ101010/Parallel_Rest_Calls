package com.poc.ParallelProgramming;

import java.io.IOException;

public class MyThread implements Runnable {
	ServerInvocation serverInvocation = new ServerInvocation();
	static int threadId = 0;
	String rest_url;
	String userName;
	String password;

	public MyThread(String rest_url, String userName, String password) {
		this.rest_url = rest_url;
		this.userName = userName;
		this.password = password;
	}

	public void run() {

		try {
			threadId = threadId+1;
			System.out.println("Thread Id:" + threadId);
			Long startTime = System.currentTimeMillis();
			serverInvocation.serverCall(rest_url, userName, password);
			System.out.println("Thread Id:" + threadId + " Executed In " + (System.currentTimeMillis() - startTime));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
