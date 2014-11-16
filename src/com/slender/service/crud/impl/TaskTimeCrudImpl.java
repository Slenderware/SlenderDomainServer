/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.service.crud.impl;

import com.slender.domain.TaskTime;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.TaskTimeCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TaskTimeCrudImpl implements TaskTimeCrud{
    private Session session;
    private Query query;

    @Override
    public TaskTime findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        TaskTime taskTime = (TaskTime) session.get(TaskTime.class, id);
        
        session.getTransaction().commit();
        session.close();
        return taskTime;
    }

    @Override
    public List<TaskTime> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from TaskTime");
        List<TaskTime> taskTimes;
        taskTimes = query.list();
        
        session.getTransaction().commit();
        session.close();
        return taskTimes;
    }

    @Override
    public TaskTime persist(TaskTime entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from task_time");
        int id = Integer.parseInt(query.list().get(0).toString());
        
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(TaskTime entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.merge(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(TaskTime entity) {
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
        
        TaskTime entity = new TaskTime();
        entity.setId(entityId);
        session.delete(entity);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        query = session.createQuery("from TaskTime");
        List<TaskTime> taskTimes = query.list();
        int count = taskTimes.size();
        
        session.getTransaction().commit();
        session.close();
        return count;
    }

    @Override
    public TaskTime getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(TaskTime.class);
        TaskTime entity = (TaskTime) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public TaskTime getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(TaskTime.class);
        TaskTime entity = (TaskTime) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public List<TaskTime> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(TaskTime.class);
        List<TaskTime> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    @Override
    public List<TaskTime> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(TaskTime.class);
        List<TaskTime> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        
        session.getTransaction().commit();
        session.close();
        return entities;
    }
}
