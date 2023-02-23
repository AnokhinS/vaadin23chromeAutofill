package org.example.password.views;

import javax.annotation.security.PermitAll;

import org.example.password.entities.Client;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PermitAll
public class EditForm extends FlexLayout {

    private static final long serialVersionUID = 1L;

    protected Binder<Client> binder;
    protected TextField username;
    protected PasswordField password;

    public EditForm() {
	super();
	init();
	bind();
    }

    protected void bind() {
	bindValidation();
	password.addValueChangeListener(e -> updateEnables());
	username.addValueChangeListener(e -> updateEnables());
    }

    protected void bindValidation() {
	binder.forField(username).withValidator(new Validator<String>() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public ValidationResult apply(String value, ValueContext context) {
		return ValidationResult.ok();
	    }
	}).bind(Client::getUsername, Client::setUsername);

	binder.forField(password).withValidator(new Validator<String>() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public ValidationResult apply(String arg0, ValueContext arg1) {
		return ValidationResult.ok();
	    }
	}).bind(Client::getPassword, Client::setPassword);
    }

    protected void init() {
	binder = new Binder<>(Client.class);
	binder.setBean(new Client());
	initComponents();
	add(getContent());
    }

    protected Component getContent() {
	FormLayout form = new FormLayout();
	form.addFormItem(username, "username");
	form.addFormItem(password, "password");
	return form;
    }

    protected void initComponents() {
	username = new TextField();
	username.setWidthFull();
	password = new PasswordField();
	password.setWidthFull();
    }

    protected void updateEnables() {
	binder.validate();
    }

}
