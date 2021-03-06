package net.javaguildes.springboot.JWT;

import java.util.Collection;
import java.util.Collections;


import net.javaguildes.springboot.Model.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
    private Account user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {   //lay thong tin role cua user giup de dang xac thuc quyen han
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole_id().getRole_name()));
    }
    

    public UserDetailsImpl(Account user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //lay thong tin user co bi khoa ko, neu bi khoa thi ko login vao dc
//       if(user.getIs_blocked()==true)
//            return false; 
        //else
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
}