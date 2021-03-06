/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.TaskTime;
import java.util.Date;

public class TaskTimeFactory {
    public TaskTime getTaskTime(int taskId, int userId, Date createDate, int timeSpent){
        TaskTime taskTime = new TaskTime();
        taskTime.setCreateDate(createDate);
        taskTime.setTaskId(taskId);
        taskTime.setUserId(userId);
        taskTime.setTimeSpent(timeSpent);
        return taskTime;
    }
}
