package com.user;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.flywaydb.core.Flyway;

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
        Flyway flyway = Flyway.configure()
                .dataSource(configuration.getDatabase().getUrl(),
                        configuration.getDatabase().getUser(),
                        configuration.getDatabase().getPassword())
                .locations(configuration.getFlywayFactory().getLocations().toArray(new String[0]))
                .load();
        flyway.migrate();
    }

}
