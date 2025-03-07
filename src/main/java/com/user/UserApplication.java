package com.user;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class UserApplication extends Application<UserConfiguration> {

    public static void main(final String[] args) throws Exception {
        new UserApplication().run(args);
    }

    @Override
    public String getName() {
        return "User";
    }

    @Override
    public void initialize(final Bootstrap<UserConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final UserConfiguration configuration, final Environment environment) {
        // TODO: implement application

    }

}
