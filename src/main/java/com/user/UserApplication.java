package com.user;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class UserApplication extends Application<UserConfiguration> {

    public static void main(String[] args) throws Exception {
        new UserApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<UserConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(UserConfiguration userConfiguration, Environment environment) {

    }

}