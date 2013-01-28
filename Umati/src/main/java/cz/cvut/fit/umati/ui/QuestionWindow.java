package cz.cvut.fit.umati.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.ui.Window;

import cz.cvut.fit.umati.model.WebApiElaborated;
import cz.cvut.fit.umati.ui.composite.QuestionComposite;

@org.springframework.stereotype.Component
@Scope("session")
public class QuestionWindow extends Window {
	private static final long serialVersionUID = 1L;

	@Autowired
	private QuestionComposite questionComposite;
	
	@PostConstruct
	public void init() {
		setContent(questionComposite);
		setModal(true);
	}

	public void fireWindowOpen(WebApiElaborated webApiElaborated) {
		// Fire to composite
		questionComposite.fireCompositeOpen(webApiElaborated);
	}
}
