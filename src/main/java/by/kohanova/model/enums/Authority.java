package by.kohanova.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority{
	ROLE_ADMIN,
    ROLE_PERSON,    
    GUEST;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
