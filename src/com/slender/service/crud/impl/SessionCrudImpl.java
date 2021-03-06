/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.service.crud.impl;

import com.slender.domain.Session;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.SessionCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

public class SessionCrudImpl implements SessionCrud{

    private org.hibernate.Session session;
    private Query query;

    
    public Session findById(String id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Session sess = (Session) session.get(Session.class, id);
        
        session.getTransaction().commit();
        session.close();
        return sess;
    }

    
    public List<Session> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Session");
        List<Session> sesss;
        sesss = query.list();
        
        session.getTransaction().commit();
        session.close();
        return sesss;
    }

    public Session persist(Session entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(entity);
        session.flush();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    
    public void merge(Session entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.merge(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    
    public void remove(Session entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    
    public void removeById(String entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Session entity = new Session();
        entity.setId(entityId);
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }
    

    
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Session");
        List<Session> sesss = query.list();
        int count = sesss.size();
        
        session.getTransaction().commit();
        session.close();
        return count;
    }

    
    public Session getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Session.class);
        Session entity = (Session) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    
    public Session getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Session.class);
        Session entity = (Session) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    
    public List<Session> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Session.class);
        List<Session> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    
    public List<Session> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Session.class);
        List<Session> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }
    
}
