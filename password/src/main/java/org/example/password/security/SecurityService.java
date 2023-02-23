package org.example.password.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;

/**
 * service for accessing user information and logging out
 * 
 * @author goran
 *
 */
@Controller
public class SecurityService {
    
    private static final String LOGOUT_SUCCESS_URL = "/";

    public UserDetails getAuthenticatedUser() {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth == null ? null : auth.getPrincipal();
	if (principal != null && principal instanceof UserDetails) {
	    return (UserDetails) principal;
	}
	// Anonymous or no authentication.
	return null;
    }

    public void logout() {
	UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
	SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	//Locale.setDefault(new Locale(""));
	logoutHandler.logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
    }
}
