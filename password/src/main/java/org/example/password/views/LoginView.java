package org.example.password.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = LoginView.ROUTE)
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private static final long serialVersionUID = 1L;
    public static final String ROUTE = "login";
    private LoginForm login = new LoginForm();

    public LoginView() {

	setSizeFull();

	setJustifyContentMode(JustifyContentMode.CENTER);
	setAlignItems(Alignment.CENTER);

	login.setAction("login");
	login.setForgotPasswordButtonVisible(false);

	add(new H1("Test app"), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
	if (event.getLocation().getQueryParameters().getParameters().containsKey("error")) {
	    login.setError(true);
	}
    }

}
