/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.Role;

public class RoleFactory {
    public Role getRole(String rol){
        Role role = new Role();
        role.setRole(rol);
        return role;
    }
}
