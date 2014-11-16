/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.Session;

public class SessionFactory {
    public Session getSession(String id, Integer userId){
        Session session = new Session();
        session.setId(id);
        session.setUserId(userId);
        return session;
    }
}
