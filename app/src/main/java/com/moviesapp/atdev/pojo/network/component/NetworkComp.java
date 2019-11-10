package com.moviesapp.atdev.pojo.network.component;

import com.moviesapp.atdev.pojo.network.APIClient;

import dagger.Component;

@ScopeNetworkComp
@Component(modules = APiServiceModule.class)
public interface NetworkComp {


    APIClient getApiClient();

}
