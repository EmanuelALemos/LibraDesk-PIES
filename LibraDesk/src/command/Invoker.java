package command;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Map<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void invoke(String commandName) throws Exception {
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute();
        }
    }
}
