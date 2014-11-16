/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Entity;

@Entity
@XmlRootElement
public class Status implements Serializable{
    private int id;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
