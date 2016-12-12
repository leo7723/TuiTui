package com.netplus.leo.tuitui.bean;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by leo on 2016/11/28.
 */

public class Company implements MvpView {
    private  String icon;
    private String name;
    private String companyName;
    private String jobDescribsion;
    Company(){}
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobDescribsion() {
        return jobDescribsion;
    }

    public void setJobDescribsion(String jobDescribsion) {
        this.jobDescribsion = jobDescribsion;
    }
}
