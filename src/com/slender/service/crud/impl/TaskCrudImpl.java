/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.service.crud.impl;

import com.slender.domain.Task;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.TaskCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TaskCrudImpl implements TaskCrud{
    private Session session;
    private Query query;

    @Override
    public Task findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Task task = (Task) session.get(Task.class, id);
        
        session.getTransaction().commit();
        session.close();
        return task;
    }

    @Override
    public List<Task> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Task");
        List<Task> tasks;
        tasks = query.list();
        
        session.getTransaction().commit();
        session.close();
        return tasks;
    }

    @Override
    public Task persist(Task entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Task");
        int id = Integer.parseInt(query.list().get(0).toString());
        
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Task entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.merge(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Task entity) {
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
        
        Task entity = new Task();
        entity.setId(entityId);
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from Task");
        List<Task> tasks = query.list();
        int count = tasks.size();
        
        session.getTransaction().commit();
        session.close();
        return count;
    }

    @Override
    public Task getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Task.class);
        Task entity = (Task) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Task getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Task.class);
        Task entity = (Task) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public List<Task> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Task.class);
        List<Task> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    @Override
    public List<Task> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Task.class);
        List<Task> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }
}
