package com.pig;

import javax.script.*;

import static javax.script.ScriptContext.ENGINE_SCOPE;
import static javax.script.ScriptContext.GLOBAL_SCOPE;

public class Scope {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        manager.put("n1", 1);
        String script = "var sum = n1 + n2;" +
                "  print(msg + "
                + "' n1=' + n1 + ', n2=' + n2 + " + "', sum=' + sum);";

        engine.put("n2", 2);
        engine.put("msg", "a string");
        engine.eval(script);

        Bindings bindings = engine.createBindings();
        bindings.put("n2", 3);
        bindings.put("msg", "another string");
        engine.eval(script, bindings);

        ScriptContext ctx = new SimpleScriptContext();
        Bindings ctxGlobalBindings = engine.createBindings();
        ctx.setBindings(ctxGlobalBindings, GLOBAL_SCOPE);
        ctx.setAttribute("n1", 4, ENGINE_SCOPE);
        ctx.setAttribute("n2", 5, ENGINE_SCOPE);
        ctx.setAttribute("msg", "ScriptContext:", ENGINE_SCOPE);
        engine.eval(script, ctx);

        engine.eval(script);
    }
}
