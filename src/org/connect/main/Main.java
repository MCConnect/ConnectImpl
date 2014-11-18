package org.connect.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;

import org.connect.api.plugin.PluginBase;
import org.connect.impl.Connect;
import org.connect.impl.ConnectImpl;
import org.connect.impl.ImplClass;

public class Main extends ConnectImpl {

	public static void main(String[] args) {
		try {
			Connect server = new Connect(new ImplClass());
			BufferedReader consoleReader = new BufferedReader(
					new InputStreamReader(System.in));
			server.init();
			System.out.print("> ");
			String command = consoleReader.readLine();

			// So much more complex then it needs to be, looking for fix
			String commandLine = "";
			String[] tmpCmdArgs, cmdArgs;

			tmpCmdArgs = command.split(" ");
			cmdArgs = cmd(Arrays.asList(tmpCmdArgs));
			command = tmpCmdArgs[0];

			staticServer().getConsoleSender().performCommand(commandLine,
					new String[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String[] cmd(List<String> list) {
		String[] ar = new String[list.size()];
		list.remove(0);
		ar = list.toArray(ar);
		return ar;
	}

}
