package cz.cvut.fit.umati.ui.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import com.vaadin.ui.CustomComponent;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface View {
	public Class<? extends CustomComponent> viewClass();
}
