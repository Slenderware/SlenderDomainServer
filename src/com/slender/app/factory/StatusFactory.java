/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.Status;

public class StatusFactory {
    public Status getStatus(String stat){
        Status status = new Status();
        status.setStatus(stat);
        return status;
    }
}
