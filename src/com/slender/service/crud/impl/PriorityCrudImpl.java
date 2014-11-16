/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.service.crud.impl;

import com.slender.domain.Priority;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.PriorityCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PriorityCrudImpl implements PriorityCrud{
    private Session session;
    private Query query;

    @Override
    public Priority findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Priority priority = (Priority) session.get(Priority.class, id);
        
        session.getTransaction().commit();
        session.close();
        return priority;
    }

    @Override
    public List<Priority> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Priority");
        List<Priority> prioritys;
        prioritys = query.list();
        
        session.getTransaction().commit();
        session.close();
        return prioritys;
    }

    @Override
    public Priority persist(Priority entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Priority");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Priority entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.merge(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Priority entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Priority entity = new Priority();
        entity.setId(entityId);
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Priority");
        List<Priority> prioritys = query.list();
        int count = prioritys.size();
        
        session.getTransaction().commit();
        session.close();
        return count;
    }

    @Override
    public Priority getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Priority.class);
        Priority entity = (Priority) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Priority getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Priority.class);
        Priority entity = (Priority) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public List<Priority> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Priority.class);
        List<Priority> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    @Override
    public List<Priority> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Priority.class);
        List<Priority> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }
}
