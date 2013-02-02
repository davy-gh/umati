package cz.cvut.fit.umati;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.portlet.context.PortletApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationPortlet;

public class VaadinSpringAppPortlet extends AbstractApplicationPortlet {
	private ApplicationContext ctx;
	private Class<? extends Application> applicationClass;
	private String applicationBean;

	@SuppressWarnings("unchecked")
	public void init(PortletConfig portletConfig) throws PortletException {
		super.init(portletConfig);
		applicationBean = portletConfig.getInitParameter("applicationBean");

		if (applicationBean == null) {
			throw new PortletException("ApplicationBean not specified in servlet parameters");
		}

		ctx = PortletApplicationContextUtils.getWebApplicationContext(portletConfig.getPortletContext());
		applicationClass = (Class<? extends Application>) ctx.getType(applicationBean);
	}

	protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
		System.out.println("Tohle neco dela??");
		return applicationClass;
	}

	protected Application getNewApplication(HttpServletRequest request) {
		return (Application) ctx.getBean(applicationBean);
	}
}