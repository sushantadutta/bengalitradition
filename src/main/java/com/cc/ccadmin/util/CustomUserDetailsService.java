package com.cc.ccadmin.util;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cc.ccadmin.model.admin.ADM_USER;

public class CustomUserDetailsService implements UserDetailsService {

	private HibernateTemplate hibernateTemplate;

	public CustomUserDetailsService(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Collection<GrantedAuthorityImpl> authorities = new ArrayList<GrantedAuthorityImpl>();
		authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		authorities.add(new GrantedAuthorityImpl("LOY_ADMIN"));
		ADM_USER user = getHibernateTemplate().get(ADM_USER.class, username);
		User user1 = null;
		if (user != null) {
			String user_name = user.getAus_user_name();
			try {
				String password =/* PasswordService.decrypt(user.getPassword());*/user.getAus_password();
				user1 = new User(user_name, password, true, true, true, true,
						authorities);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return user1;
		} else {
			throw new UsernameNotFoundException(username + "not found");
		}
	}
}
