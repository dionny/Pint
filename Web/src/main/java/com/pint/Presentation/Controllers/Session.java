package com.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Dionny on 11/26/2015.
 */
public class Session {
    public static User getUser() throws Exception {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserAuthentication) {
            User user = ((UserAuthentication) authentication).getDetails();
            return user;
        }

        throw new Exception("Not authenticated.");
    }
}
