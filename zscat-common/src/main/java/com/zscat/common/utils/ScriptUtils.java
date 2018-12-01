package com.zscat.common.utils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 脚本工具类
 * TODO 目前有性能问题，不建议使用
 *
 * @author zscat
 * @version 1.0
 */
public class ScriptUtils {

	/** 脚本引擎管理实例*/
	private static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

	/** 脚本引擎map*/
	private static Map<String, ScriptEngine> scriptEngines = new ConcurrentHashMap<>();

	public static ScriptEngineManager getScriptEngineManager() {
		return scriptEngineManager;
	}

	public static Map<String, ScriptEngine> getScriptEngines() {
		return scriptEngines;
	}

	static {
		javaScriptEngine();
//		groovyScriptEngine();
	}

	/**
	 * 获取对应引擎名字的脚本引擎
	 * @param engineName 引擎名，如javascript、groovy
	 * @return
	 */
	public static ScriptEngine getScriptEngine(String engineName) {
		if(engineName == null) {
			return null;
		}
		ScriptEngine scriptEngine = scriptEngines.get(engineName);
//		ScriptEngine scriptEngine = threadLocal.get();
		if(scriptEngine == null) {
			scriptEngine = scriptEngineManager.getEngineByName(engineName);
			if(scriptEngine != null) {
				scriptEngines.put(engineName, scriptEngine);
			}
		}
		return scriptEngine;
	}

	/**
	 * groovy引擎
	 * @return
	 */
	public static ScriptEngine groovyScriptEngine() {
		return getScriptEngine("groovy");
	}

	/**
	 * javascript引擎
	 * @return
	 */
	public static ScriptEngine javaScriptEngine() {
		return getScriptEngine("JavaScript");
	}

	/**
	 * 快速执行脚本
	 * @param engine 脚本引擎
	 * @param script 脚本内容
	 * @param method 脚本中的方法，必须有
	 * @param args 脚本方法中的参数
	 * @return
	 */
	public static synchronized Object highEval(ScriptEngine engine, String script, String method, Object...args) {
		long beginTime = System.currentTimeMillis();
		if(engine == null || script == null || "".equals(script.trim()) || method == null || "".equals(method.trim())) {
			return null;
		}
		try {
			engine.eval(script);
			Invocable invoke = (Invocable)engine;
			Object obj = invoke.invokeFunction(method, args);
			//log.info("执行脚本时间为：{}ms",(System.currentTimeMillis() - beginTime));
			return obj;
		} catch (Exception e) {

			return null;
		}
	}

	public static Object highEval(String script, Object...args) {
		return highEval(javaScriptEngine(), script, "exec", args);
	}

	public static Object highEval(String script, String method, Object...args) {
		return highEval(javaScriptEngine(), script, method, args);
	}

	public static void main(String[] args) throws Exception {
		long begin = System.currentTimeMillis();
		//String content= "function exec(invite){ return invite==3;}";
		/*for(int i=0;i<10000;i++) {
			System.out.println(highEval(content, "exec",3l));
		}*/

		/*String content = "function contains(labelIdList, labelId){" +
                "for (var i = 0; i < labelIdList.length; i++) {" +
                "var id = labelIdList[i];" +
                "  if (id == labelId) { return true; }}" +
                "return false;" +
                "}";*/

		String content = "function exec() {return 1 in [1, 2, 3]}";
        List<Integer> labelIdList = new ArrayList<>();
        labelIdList.add(11);
        labelIdList.add(25);

        Integer[] arr = new Integer[] { 10, 20, 30};

		System.out.println(highEval(content, "exec"));

		System.out.println("cost:"+(System.currentTimeMillis() - begin));
	}
}
