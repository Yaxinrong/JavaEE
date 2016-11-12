package cm.ioc.context;

import java.util.HashMap;
import java.util.Map;

public class Context {
	private Map<String,Object> boxes = new HashMap<String,Object>();
	private static final Context context = new Context();
	private Context(){
		
	}
	public static Context getContext(){
		return context;
	}
	//将初始化实体放入map集合
	public void put(String id,Object o){
		boxes.put(id, o);
	}
	//获得初始化实体
	public Object getInstance(String id){
		if(boxes.containsKey(id)){
			return boxes.get(id);
		}else{
			return null;
		}
	}
}
