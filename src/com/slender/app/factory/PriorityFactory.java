/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.Priority;

public class PriorityFactory {
    public Priority getPriority(String pri){
        Priority priority = new Priority();
        priority.setPriority(pri);
        return priority;
    }
}
