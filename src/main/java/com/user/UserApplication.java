package com.user;

import com.user.controller.UserController;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.flywaydb.core.Flyway;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.Objects;

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

        // JDBI'nin ilgili veritabaninda etkin olmasi saglandi
        Jdbi jdbi = Jdbi.create(configuration.getDatabase().getUrl(),
                Objects.requireNonNull(configuration.getDatabase().getUser()),
                Objects.requireNonNull(configuration.getDatabase().getPassword()));
        jdbi.installPlugin(new SqlObjectPlugin());

        // DAO oluşturma
        UserRepository userRepository = jdbi.onDemand(UserRepository.class);

        // Servis oluşturma
        UserService userService = new UserServiceImpl(userRepository);

        // REST API kaynağını kaydetme
        environment.jersey().register(new UserController(userService));

    }

}