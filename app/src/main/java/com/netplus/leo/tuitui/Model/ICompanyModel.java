package com.netplus.leo.tuitui.Model;

import com.netplus.leo.tuitui.bean.Company;

/**
 * Created by leo on 2016/12/21.
 */

public interface ICompanyModel {
    void setName(String name);
    void setCompanyName(String companyName);
    void setIcon(String icon);

    Company load(int id);
}
