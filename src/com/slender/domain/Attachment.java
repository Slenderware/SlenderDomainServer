/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Nick
 */
@Entity
@XmlRootElement
public class Attachment implements Serializable{
    private int id;
    private String attachmentName;
    private String attachment;
    private Date createDate;
    private Integer projectId ;
    private Integer taskId;
    private Integer userId;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     *
     * @param attachmentName
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     *
     * @return
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     *
     * @param attachment
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    /**
     *
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @return
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * @return
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     *
     * @param taskId
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     *
     * @return
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
