package cm.ioc.view;

import cm.ioc.context.Context;
import cm.ioc.context.CreateInstances;
import cm.ioc.io.XmlReader;
import cm.ioc.model.boss;

public class test {
	public static void main(String[] args) {
		new CreateInstances("src/cm/ioc/doc/bean.xml").Create();
		boss boss = (boss) Context.getContext().getInstance("boss");
		boss.getBoss();
		
		
		
		XmlReader reader = new XmlReader("src/cm/ioc/doc/bean.xml");
		System.out.println(reader.getPropertysById("office"));
	}
}
