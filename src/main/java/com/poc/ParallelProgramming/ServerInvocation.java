package com.poc.ParallelProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class ServerInvocation {

	public void serverCall(String rest_url, String userName, String password) throws IOException {
		String userCredentials = userName + ":" + password;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
		HttpURLConnection urlConnection = (HttpURLConnection) new URL(rest_url).openConnection();
		urlConnection.setRequestProperty("Authorization", basicAuth);
		System.out.println(readStream(urlConnection.getInputStream()));
	}

	private static String readStream(InputStream in) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
			String nl = "";
			String nextLine = "";
			while ((nextLine = reader.readLine()) != null) {
				sb.append(nl + nextLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
