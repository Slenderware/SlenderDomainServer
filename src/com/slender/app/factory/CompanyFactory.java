/*
 * All source is copyrighted by Slenderware 
 */
package com.slender.app.factory;

import com.slender.domain.Company;
import java.util.Date;

public class CompanyFactory {
    public Company getCompany(String name, int adminUser){
        Company company = new Company();
        Date d = new Date();
        company.setCompanyName(name);
        company.setAdminUser(adminUser);
        company.setCreateDate(d);
        return company;
    }
}
