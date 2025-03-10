package com.user;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.flywaydb.core.Flyway;

public class UserApplication extends Application<UserConfiguration> {

    public static void main(String[] args) throws Exception {
        new UserApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<UserConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(UserConfiguration configuration, Environment environment) {

        Flyway flyway = Flyway.configure()
                .dataSource(configuration.getDatabase().getUrl(),
                        configuration.getDatabase().getUser(),
                        configuration.getDatabase().getPassword())
                .locations(configuration.getFlyway().getLocations().toArray(new String[0]))
                .load();
        flyway.migrate();

    }

}