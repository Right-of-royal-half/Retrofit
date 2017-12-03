package com.baiwei.shenxuesong.retrofit.Model;

import com.baiwei.shenxuesong.retrofit.netWork.API;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dell on 2017/12/1.
 */

public class RetorfitHelper {
      public static OkHttpClient okHttpClient;
    public static ServerApi serverApi;
     static
     {
         initOkHttpClient();
     }

      public static OkHttpClient initOkHttpClient()
      {
          if(okHttpClient==null)
          {
              synchronized (RetorfitHelper.class)
              {
                  if(okHttpClient==null)
                  {
                      okHttpClient=new OkHttpClient();
                  }
              }
          }
          return okHttpClient;
      }

      public static ServerApi getServerApi()
      {
          if(serverApi==null)
          {
              synchronized (ServerApi.class)
              {
                  if(serverApi==null)
                  {
                      serverApi=OnCreatApi(ServerApi.class, API.HOST);
                  }
              }
          }
          return serverApi;
      }
      public static<T> T OnCreatApi(Class<T> tClass,String url)
      {

          Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

          return retrofit.create(tClass);
      }
}








































