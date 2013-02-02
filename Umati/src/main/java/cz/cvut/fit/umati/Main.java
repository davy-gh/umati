package cz.cvut.fit.umati;

import javax.portlet.Portlet;

public class Main {
	Portlet portlet;

//	public Main() {
//		ClassLoader _classLoader = ClassLoader.getSystemClassLoader();
//		Class<?> portletClass = null;
//
//		try {
//			portletClass = _classLoader.loadClass(portlet.getPortletClass());
//		} catch (Throwable e) {
//			
//		}
//
//		javax.portlet.Portlet portletInstance = (javax.portlet.Portlet) portletClass.newInstance();
//
//		portlet = new VaadinSpringAppPortlet();
//		System.out.println("Stalo se neco");
//	}

	public static void main(String[] args) {
		new Main();
	}
}
