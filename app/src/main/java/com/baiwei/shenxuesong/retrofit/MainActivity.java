package com.baiwei.shenxuesong.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.baiwei.shenxuesong.retrofit.Bean.Bean;
import com.baiwei.shenxuesong.retrofit.Model.RetorfitHelper;
import com.baiwei.shenxuesong.retrofit.Model.ServerApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rlv.setLayoutManager(manager);
        ServerApi serverApi= RetorfitHelper.getServerApi();

        Call<Bean> beanCall=serverApi.bean();

        beanCall.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
              Bean bean=response.body();
                Adpter adpter = new Adpter(MainActivity.this,bean.getResults());
                rlv.setAdapter(adpter);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }
        });

    }
}











