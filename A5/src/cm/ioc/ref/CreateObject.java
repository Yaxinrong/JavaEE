package cm.ioc.ref;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import cm.ioc.context.Context;
import cm.ioc.exception.MethodNotFoundException;

public class CreateObject {
	public Object createInstance(String classPath){
		Object o = null;
		try {
			Class c = Class.forName(classPath);
			o = c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public void loadPropertys(Object o,Map<String,String> properties) throws Exception{
		if(properties==null){
			return;
		}
		Class c = o.getClass();
		Method[] methods = c.getMethods();
		Set<Entry<String,String>> ps = properties.entrySet();
		for(Entry<String,String> en:ps){
			String key = en.getKey();
			String value = en.getValue();
			Method m = getMethod(methods, key);
			m.invoke(o, Context.getContext().getInstance(value));
		}
		
	}
	
	private Method getMethod(Method[] methods,String methodName){
		for(Method m:methods){
			if(m.getName().equalsIgnoreCase("set"+methodName)){
				return m;
			}
		}
		throw new MethodNotFoundException("方法：set"+methodName+"没有找到");
	}
}
