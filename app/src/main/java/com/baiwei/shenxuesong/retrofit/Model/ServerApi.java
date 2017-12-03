package com.baiwei.shenxuesong.retrofit.Model;

import com.baiwei.shenxuesong.retrofit.Bean.Bean;
import com.baiwei.shenxuesong.retrofit.Bean.LoginBean;
import com.baiwei.shenxuesong.retrofit.netWork.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Dell on 2017/12/1.
 */

public interface ServerApi {

     @GET(API.URL)
      Call<Bean> bean();
      @POST(API.HOSTURL)
      Call<LoginBean> loogin(@Query("mobile") String moblie,
                            @Query("password") String pwd  );
}
