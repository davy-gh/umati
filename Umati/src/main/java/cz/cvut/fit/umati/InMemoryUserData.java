package cz.cvut.fit.umati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.vaadin.data.util.BeanItemContainer;

import cz.cvut.fit.umati.model.User;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("singleton")
public class InMemoryUserData extends BeanItemContainer<User> {
	private static final long serialVersionUID = 1L;

	/*
	 * Constructor
	 */
	@Autowired
	public InMemoryUserData(@Value("cz.cvut.fit.umati.model.User") Class<? super User> type) throws IllegalArgumentException {
		super(type);
	}
}
