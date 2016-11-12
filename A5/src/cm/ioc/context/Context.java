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
	//����ʼ��ʵ�����map����
	public void put(String id,Object o){
		boxes.put(id, o);
	}
	//��ó�ʼ��ʵ��
	public Object getInstance(String id){
		if(boxes.containsKey(id)){
			return boxes.get(id);
		}else{
			return null;
		}
	}
}
