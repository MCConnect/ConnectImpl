package org.connect.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.connect.api.entity.ICommandSender;
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

			if (!commandLine.contains(" ")) {
				// "Unknown command. Type '/help' for help." message would be here
				staticLogger().i("Unknown command. Type '/help' for help.");
				return;
			}

			String[] cmds = command.split(" ");

			if (cmds.length != 0) {
				ArrayList<String> cmdsArgs2 = new ArrayList<>();
				for (String s : cmds) {
					if (!s.equalsIgnoreCase(cmds[0])) {
						cmdsArgs2.add(s);
					}
				}

				String[] cmdArgs = new String[cmdsArgs2.size()];
				cmdArgs = cmdsArgs2.toArray(cmdArgs);

				if (cmdsArgs2.size() == 0) {
					staticServer().getConsoleSender().performCommand(commandLine, new String[] {});
					return;
				}
				
				staticServer().getConsoleSender().performCommand(commandLine, cmdArgs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void command(String cmds, ICommandSender sender) {
		String[] cmd = cmds.split(" ");
		if (cmd.length == 1) {
			
		}
		String label = cmd[0];
		
		staticServer().getConsoleSender().performCommand(label, cmd);
	}
	
	private String cmdCheck(String message) {
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
