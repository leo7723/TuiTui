package com.netplus.leo.tuitui;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.netplus.leo.tuitui.module.CompanyFragment;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private CompanyFragment companyFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        companyFragment=new CompanyFragment();
        Fragment f;
        f=companyFragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
