package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length > 3 ) {
            throw new Exception("missing arguments in the input");
        }
        ManipulationDetails details = new ManipulationDetails(args[0], args[1],  args[2]);

        List<String> lines = FileUtil.readFileToList(details.getInputTextFile());
        invokeCurrentAction(lines, details.getAction());
        FileUtil.writeListToFile(details.getOutputTextFile(), lines);

       JDBC.updateDB(details);
    }

    private static void invokeCurrentAction(List<String> lines, String action) throws Exception {
        try {
            Actions actions = new ActionsImpl();
            Method method = actions.getClass().getMethod(action, List.class);
            method.invoke(actions, lines);
        }

        catch (NoSuchMethodException | IllegalAccessException| InvocationTargetException e) {
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }
}


