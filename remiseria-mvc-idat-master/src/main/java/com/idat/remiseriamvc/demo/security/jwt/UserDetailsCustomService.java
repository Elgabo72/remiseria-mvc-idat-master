package com.idat.remiseriamvc.demo.security.jwt;

import com.idat.remiseriamvc.demo.models.User;
import com.idat.remiseriamvc.demo.repositorys.crud.IUserCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

//en esta clase le indica a spring que sobreescriba el metodo de registro de usuarios
@Service("userDetailsService")
public class UserDetailsCustomService implements UserDetailsService {
    // por ahora solo tiene un usuario en memoria
    @Autowired
    private IUserCR crud;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // si encuentra un resultado devuelve el cliente si no null
        User findUser = crud.findByUsername(username).map(user -> {
            return user;
        }).orElse(null);

        if (findUser == null) {
            throw new UsernameNotFoundException(username);
        }
        /* creo array de roles */
        var roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("PADMIN"));

        // obligatoriamente los roles se tiene que llamar|
        return new org.springframework.security.core.userdetails.User(findUser.getUsername(), "{bcrypt}" + findUser.getPassword(), roles);
    }
}
