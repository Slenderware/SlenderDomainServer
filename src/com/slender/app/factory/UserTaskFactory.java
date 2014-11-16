/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.UserTask;

public class UserTaskFactory {
    public UserTask getUserTask(int userId, int taskId){
        UserTask userTask = new UserTask();
        userTask.setTaskId(taskId);
        userTask.setUserId(userId);
        return userTask;
    }
}
