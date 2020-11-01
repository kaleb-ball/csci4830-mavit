package uno.csci4830.mavitapi;

import org.springframework.security.core.context.SecurityContextHolder;
import uno.csci4830.mavitapi.enums.UserRoleEnum;

public class AuthUtils {


    public static boolean canEdit() {
        Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return credentials.toString().contains(UserRoleEnum.ADMIN.name()) ||
                credentials.toString().contains(UserRoleEnum.MODERATOR.name());
    }

}
