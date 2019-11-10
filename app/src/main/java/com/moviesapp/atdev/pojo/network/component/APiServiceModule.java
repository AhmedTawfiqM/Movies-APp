package com.moviesapp.atdev.pojo.network.component;

import com.moviesapp.atdev.pojo.network.APIClient;
import com.moviesapp.atdev.utils.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class APiServiceModule {

    @Provides
    @ScopeNetworkComp
    public APIClient getAPiClient(Retrofit retrofit) {

        return retrofit.create(APIClient.class);
    }

    @Provides
    @ScopeNetworkComp
    public Retrofit getRetrofit(OkHttpClient client) {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
