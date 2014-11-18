package org.connect.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.connect.api.ILogger;

public class Logger implements ILogger {

	private String name;

	public Logger(String name) {
		this.name = name;
	}

	public void i(String message) {
		info(message);
	}

	public void info(String message) {
		System.out.println("[" + time() + " INFO]: " + message);
	}

	public void w(String message) {
		warn(message);
	}

	public void warn(String message) {
		System.out.println("[" + time() + " WARN]: " + message);
	}

	public String time() {
		TimeZone timeZone = Calendar.getInstance().getTimeZone();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(timeZone);
		return dateFormat.format(date);
	}

}
