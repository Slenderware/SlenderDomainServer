/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Entity;

@Entity
@XmlRootElement
public class UserTask implements Serializable{
    private int id;
    private Integer userId;
    private Integer taskId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    
}
