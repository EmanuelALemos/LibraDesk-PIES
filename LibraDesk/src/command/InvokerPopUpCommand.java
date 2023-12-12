package command;

import java.util.HashMap;
import java.util.Map;
import model.IModel;

public class InvokerPopUpCommand {
    private Map<String, PopUpCommand> commandMap = new HashMap<>();

    public void register(String commandName, PopUpCommand command) {
        commandMap.put(commandName, command);
    }

    public void invoke(String commandName, IModel model) throws Exception {
        PopUpCommand command = commandMap.get(commandName);
        if (command != null) {
            command.execute(model);
        }
    }
}
