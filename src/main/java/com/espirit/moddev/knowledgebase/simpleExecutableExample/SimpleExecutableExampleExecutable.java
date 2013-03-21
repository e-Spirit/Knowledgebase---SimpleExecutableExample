package com.espirit.moddev.knowledgebase.simpleExecutableExample;

import java.io.Writer;
import java.util.Map;

import de.espirit.firstspirit.access.ScriptContext;
import de.espirit.firstspirit.access.script.Executable;
import de.espirit.firstspirit.access.script.ExecutionException;
import de.espirit.firstspirit.agency.OperationAgent;
import de.espirit.firstspirit.ui.operations.RequestOperation;

/*
 * Example of a simple executable class, which shows a dialog with the message "Hello World!".
 *
 * Script:
 * #!executable-class
 * com.espirit.moddev.knowledgebase.simpleExecutableExample.SimpleExecutableExampleExecutable
*/

public class SimpleExecutableExampleExecutable implements Executable {

    public Object execute(Map<String, Object> params) throws ExecutionException {
        ScriptContext context = (ScriptContext) params.get("context");

        OperationAgent operationAgent = context.requireSpecialist(OperationAgent.TYPE);
    	RequestOperation operation = operationAgent.getOperation(RequestOperation.TYPE);
        operation.perform("Hello World!");

        return true;
    }

    public Object execute(Map<String, Object> context, Writer out, Writer err) throws ExecutionException {
        return execute(context);
    }
}
