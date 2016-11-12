package cm.ioc.context;

import java.util.List;
import java.util.Map;

import cm.ioc.io.XmlReader;
import cm.ioc.ref.CreateObject;

public class CreateInstances {
	private XmlReader reader;
	private Context context = Context.getContext();
	private CreateObject createObject = new CreateObject();
	public CreateInstances(String xmlPath){
		reader = new XmlReader(xmlPath);
	}
	public void Create(){
		List<String> allId = reader.getAllId();
		for(String id:allId){
			String className = reader.getClassById(id);
			Object o = createObject.createInstance(className);
			context.put(id, o);
		}
		for(String id:allId){
			Map<String,String> properties = reader.getPropertysById(id);
			Object o = Context.getContext().getInstance(id);
			try {
				createObject.loadPropertys(o, properties);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
