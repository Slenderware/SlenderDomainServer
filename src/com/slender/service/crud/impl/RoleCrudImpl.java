/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.service.crud.impl;

import com.slender.domain.Role;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.RoleCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RoleCrudImpl implements RoleCrud{
    private Session session;
    private Query query;

    @Override
    public Role findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Role role = (Role) session.get(Role.class, id);
        
        session.getTransaction().commit();
        session.close();
        return role;
    }

    @Override
    public List<Role> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Role");
        List<Role> roles;
        roles = query.list();
        
        session.getTransaction().commit();
        session.close();
        return roles;
    }

    @Override
    public Role persist(Role entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Role");
        int id = Integer.parseInt(query.list().get(0).toString());
        
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Role entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.merge(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Role entity) {
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
        
        Role entity = new Role();
        entity.setId(entityId);
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Role");
        List<Role> roles = query.list();
        int count = roles.size();
        
        session.getTransaction().commit();
        session.close();
        return count;
    }

    @Override
    public Role getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Role.class);
        Role entity = (Role) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Role getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Role.class);
        Role entity = (Role) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public List<Role> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Role.class);
        List<Role> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    @Override
    public List<Role> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Role.class);
        List<Role> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }
}
