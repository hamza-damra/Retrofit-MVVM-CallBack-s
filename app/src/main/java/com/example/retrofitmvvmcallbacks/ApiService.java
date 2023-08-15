package com.example.retrofitmvvmcallbacks;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    static ApiService apiService;
    PostApiService postApiService;

    public ApiService()
    {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        postApiService = retrofit.create(PostApiService.class);
    }


    static public ApiService getInstance()
    {
        if(apiService == null)
        {
            apiService = new ApiService();
        }
        return apiService;
    }

    public Call<List<Post>> getPosts()
    {
        return postApiService.getPosts();
    }


}
