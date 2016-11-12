package cm.ioc.io;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cm.ioc.exception.IdNotFoundException;
import cm.ioc.exception.PropertyNullException;

import javax.xml.parsers.DocumentBuilderFactory;
public class XmlReader {
	private Document doc;
	
	public XmlReader(String xmlPath){
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlPath);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//ͨ��bean��id���Ի�ȡ��Ӧ��Class����
	public String getClassById(String id){
		NodeList nodeList = doc.getElementsByTagName("bean");
		Element element = null;
		for(int i=0;i<nodeList.getLength();i++){
			if(((Element)nodeList.item(i)).getAttribute("id").equals(id)){
				element = (Element)nodeList.item(i);
			}
		}
		if(element==null){
			throw new IdNotFoundException("�Ҳ���id:"+id);
		}
		return element.getAttribute("class");
	}
	
	//��ȡ���е�idһ��id��һ������
	public List<String> getAllId(){
		NodeList nodeList = doc.getElementsByTagName("bean");
		List<String> allId = new ArrayList<String>();
		for(int i=0;i<nodeList.getLength();i++){
			String id = ((Element)nodeList.item(i)).getAttribute("id");
			allId.add(id);
		}
		return allId;
	}
	
	//ͨ��id��ȡ���õĳ�Ա����
	public Map<String,String> getPropertysById(String id){
		NodeList nodeList = doc.getElementsByTagName("bean");
		Map<String,String> propertys = new HashMap<String,String>();
		Element element = null;
		for(int i=0;i<nodeList.getLength();i++){
			if(((Element)nodeList.item(i)).getAttribute("id").equals(id)){
				element = (Element) nodeList.item(i);
			}
		}
		if(element==null){
			throw new IdNotFoundException("�Ҳ���id:"+id);
		}
		nodeList = element.getElementsByTagName("property");
		for(int i=0;i<nodeList.getLength();i++){
			element = (Element) nodeList.item(i);
			String name = element.getAttribute("name");
			String ref = element.getAttribute("ref");
			String value = element.getAttribute("value");
			//System.out.println(value);
			propertys.put(name, value);
		}
		if(propertys.size()==0){
			propertys = null;
		}
		return propertys;
	}
	
	public static void main(String[] args) {
		XmlReader reader = new XmlReader("src/cm/ioc/doc/bean.xml");
		System.out.println(reader.getClassById("boss"));
		System.out.println(reader.getAllId());
		System.out.println(reader.getPropertysById("office"));
		//System.out.println(reader.getPropertysById("office"));

		
	}
}
