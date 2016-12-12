package com.netplus.leo.tuitui.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.netplus.leo.tuitui.CompanyAsyncLoader;
import com.netplus.leo.tuitui.bean.Company;
import com.netplus.leo.tuitui.view.CompanyView;

import java.util.List;

/**
 * Created by leo on 2016/12/10.
 */

public class CompanyPresenter extends MvpBasePresenter<CompanyView> {
    public void loadCompany(final boolean pullToRefresh){
        getView().showLoading(pullToRefresh);
        CompanyAsyncLoader conpanyAsyncLoader=new CompanyAsyncLoader(new CompanyAsyncLoader.CompanyLoaderListener() {
            @Override
            public void onSuccess(List<Company> companies) {
                if (isViewAttached()){
                    getView().setData(companies);
                    getView().showContent();
                }
            }
            @Override
            public void onError(Exception e) {
                if(isViewAttached()){
                    getView().showError(e,pullToRefresh);
                }
            }
        });
        conpanyAsyncLoader.execute();
    }
}
