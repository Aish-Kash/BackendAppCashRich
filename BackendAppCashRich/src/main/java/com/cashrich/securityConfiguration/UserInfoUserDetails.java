package com.cashrich.securityConfiguration;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;
import com.cashrich.model.User;

public class UserInfoUserDetails  implements UserDetails{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	    private String password;
	    private List<GrantedAuthority> authorities;
	   

	    public UserInfoUserDetails(User userInfo) {
	        name=userInfo.getUserName();
	        password=userInfo.getPassword();
	        this.authorities = List.of(
	                new SimpleGrantedAuthority("USER"),
	                new SimpleGrantedAuthority("ADMIN")
	        );
	    }

	    

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return name;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }



		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			  return authorities;
		}
}
