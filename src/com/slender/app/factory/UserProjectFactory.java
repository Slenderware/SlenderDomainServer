/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.UserProject;

public class UserProjectFactory {
    public UserProject getUserProject(int userId, int porjectId){
        UserProject userProject = new UserProject();
        userProject.setProjectId(porjectId);
        userProject.setUserId(userId);
        return userProject;
    }
}
