package com.pig;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class JsMain {

   static String base = "E:\\javaweb\\magic\\app\\test\\pigasuo\\src\\main\\java\\script\\" ;

    public static void main(final String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException,
            InterruptedException {
        extracted();
    }

    /**
     * todo
     */
    public static String aa(final String name) {
        System.out.format("Hi there from Java, %s", name);
        return "  greetings from java";
    }

    private static void extracted() throws FileNotFoundException, ScriptException, NoSuchMethodException,
            InterruptedException {
        final ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        final ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");

      
        final Bindings bindings = engine.createBindings();
        bindings.put("count", 3);
        bindings.put("name", "baeldung");



        System.out.println("00000000");
        // engine.eval(script,bindings);


       // evaluateJScriptCode(engine);

        // evaluate JavaScript code that defines a function with one parameter

        userScriptFunctionInJava(engine);

        // java 对象到
        // putJavaObjectToScript(engine);

        
        //  callFuncByText(engine);
        
       

       // userScopt(engine);

 

      
        // loadJsFileByText(engine);
     
       // injectJsVariable(engine);

  
      //  callJsFunction(engine);
        
    }


    private static void callJsFunction(ScriptEngine engine) throws NoSuchMethodException, ScriptException {
        //Object tt = engine.eval("  function a   () { print(a.toString() );}");
        //System.out.println(tt);
        final Invocable invocable = (Invocable) engine;
        // final Object result = invocable.invokeMethod("s.a", "Peter Parker");
        invocable.invokeFunction("a", "");
    }

    private static void injectJsVariable(ScriptEngine engine) throws ScriptException {
        Object t = engine.eval(" projectId;");
        System.out.println(t);
    }

    private static void loadJsFileByText(ScriptEngine engine) throws ScriptException, FileNotFoundException {
        engine.put("base",base);
        engine.eval("load(base +'tool.js') ");
        String a = base + "thread.js";
        engine.eval(new FileReader(a));
    }

    private static void userScopt(ScriptEngine engine) throws ScriptException {
        engine.put("good", "2222222");
        Bindings simpleBindings =  engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE);
        simpleBindings.put("globalValue", "11111"); 
        engine.eval("print (globalValue + ' ---- '   )",simpleBindings);

        System.out.println(" context -------");
        engine.getContext().setAttribute("good", 11, ScriptContext.ENGINE_SCOPE);
        engine.eval("print (  good )");
    }

    private static void callFuncByText(ScriptEngine engine) throws ScriptException {
        System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" )); 
    
    }

    private static void userScriptFunctionInJava(ScriptEngine engine) throws ScriptException, InterruptedException,
            NoSuchMethodException {

        engine.eval("function run() { print('run() function called') }");
        engine.eval("function run() { print('xxxxxxx() function called') }");
        engine.eval("var a ={}  ;  a.fun =run");
        
        final Invocable invocable = (Invocable) engine;
        final Runnable r = invocable.getInterface(Runnable.class);
        final Thread th = new Thread(r);
        invocable.invokeMethod("a", "fun");

        th.start();
        th.join();
    }


    private static void evaluateJScriptCode(ScriptEngine engine) throws NoSuchMethodException, ScriptException {

        // evaluate JavaScript code that defines an object with one method
        engine.eval("var obj = new Object()");
        engine.eval("obj.hello = function(name) { print('Hello, ' + name) }");
        final Object obj = engine.get("obj");
        final Invocable inv = (Invocable) engine;
        inv.invokeMethod(obj, "hello", "Script Method!");
    }

    private static void putJavaObjectToScript(ScriptEngine engine) throws ScriptException {
          // put java object to javascript
          final File f = new File("test.txt");
          engine.put("file", f);
          engine.put("test", new Test());

  
          engine.eval("print(file.getAbsolutePath())");
          engine.eval("print(test.getA())");

          System.out.println("-------11111-------");
  
    }

    

    public void executeFile(  final ScriptEngine engine) throws FileNotFoundException, ScriptException, NoSuchMethodException {

        final String nashorn1 = 
             "E:\\javaweb\\magic\\app\\test\\pigasuo\\src\\main\\java\\script\\function.js";
        
        engine.eval(new FileReader(nashorn1));
        final Invocable invocable = (Invocable) engine;

        final Object result = invocable.invokeFunction("fun1", "Peter Parker");
        System.out.println(result);
        System.out.println(result.getClass());

    }

    private static void executeJsFile(final ScriptEngine nashorn) {
        final String name = "Mahesh";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");

        } catch (final ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }
        System.out.println(result.toString());
    }

    public static void fun2(final Object object) {
        System.out.println("----------");
        System.out.println(object.getClass().getName());

    }

    public static void fun3(final ScriptObjectMirror mirror) {
        System.out.println("00000000000000000");
        System.out.println(mirror.getClassName() + ": " + Arrays.toString(mirror.getOwnKeys(true)));

    }

    public static void fun4(final ScriptObjectMirror person) {
        System.out.println("Full Name is: " + person.callMember("getFullName"));
    }


}