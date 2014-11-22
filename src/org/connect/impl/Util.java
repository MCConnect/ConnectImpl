package org.connect.impl;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class Util {

	// Not working, if anyone knows how to do
	// this, feel free to make a pull request
	@SuppressWarnings("resource")
	public static String getUUID(String player) {
		String uuid = null;
		try {
			String MCurl = "https://api.mojang.com/profiles/minecraft/";
			URL url = new URL(MCurl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setUseCaches(false);
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("Cache-Control", "no-chache, no-store, must revalidate");
			con.setRequestProperty("Content-Type", "application/json");
			
			String json = new Scanner(con.getInputStream(), "UTF-8").next();
			System.out.println(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return uuid;
    }

}
