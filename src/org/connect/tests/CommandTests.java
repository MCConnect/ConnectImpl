package org.connect.tests;

import java.util.ArrayList;

public class CommandTests {

	private String exNo = "";
	private String exArgs = "help blah";
	private String ex2Args = "help blah boop";
	private String exNoArgs = "help";

	public static void main(String[] args) {
		try {
			new CommandTests();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CommandTests() {
		start();
	}

	private void start() {
		System.out.println(test(exNo));
		System.out.println(test(exArgs));
		System.out.println(test(ex2Args));
		System.out.println(test(exNoArgs));
	}

	private String test(String message) {
		if (message == "" || message == null) {
			// "Unknown command. Type '/help' for help." message would be here
			return "UNKOWN";
		}

		String[] cmds = message.split(" ");
		if (cmds.length != 0) {
			ArrayList<String> cmdsArgs = new ArrayList<>();
			for (String s : cmds) {
				if (!s.equalsIgnoreCase(cmds[0])) {
					cmdsArgs.add(s);
				}
			}


			if (cmdsArgs.size() == 0) {
				return cmds[0];
			}
			return cmds[0] + ":" + cmdsArgs;
		}
		return null;
	}

}
