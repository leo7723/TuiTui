package com.netplus.leo.tuitui;

import android.os.AsyncTask;

import com.netplus.leo.tuitui.bean.Company;

import java.util.List;

/**
 * Created by leo on 2016/12/10.
 */

public class CompanyAsyncLoader extends AsyncTask<Void,Void,List<Company>> {
    public interface CompanyLoaderListener {
        public void onSuccess(List<Company> companies);

        public void onError(Exception e);
    }

    CompanyLoaderListener listener;

    public CompanyAsyncLoader(CompanyLoaderListener listener){
        this.listener=listener;
    }

    @Override
    protected List<Company> doInBackground(Void... voids) {
        return null;
    }
}
