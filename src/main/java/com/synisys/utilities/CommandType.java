package com.synisys.utilities;

import com.synisys.securityUtil.CommandNotFoundException;
import com.synisys.services.CommandRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Garik Kalashyan on 2/16/2017.
 */
public enum CommandType {
    READ_ALL_DATA("readAllData"),
    READ_ONLY_NUMBERS("readOnlyNumbers"),
    EXIT("exit"),
    READ_ONLY_LETTERS("readOnlyLetters");

    private static final Logger LOGGER = Logger.getLogger(CommandType.class.getName());
    private static final Map<String,CommandType> _values = new HashMap<>(values().length);

    static {
        for (CommandType commandType:values()){
            _values.put(commandType.getCommandName(), commandType);
        }
    }

    private String commandName;

    CommandType(String commandName){
        this.commandName =commandName;
    }

    public String getCommandName() {
        return commandName;
    }


    public static CommandType valueOff(String commandName){
        if( _values.get(commandName) == null) {
            CommandNotFoundException commandNotFoundException =  new CommandNotFoundException("Command with name: " + commandName + " not found");
            commandNotFoundException.printStackTrace();
            throw commandNotFoundException;
        }
        return _values.get(commandName);
    }
}
