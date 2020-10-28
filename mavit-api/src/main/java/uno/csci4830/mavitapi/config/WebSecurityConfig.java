
package uno.csci4830.mavitapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfiguration {
    @Autowired
    private UserDetailsService userDetailsService;

//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
}
