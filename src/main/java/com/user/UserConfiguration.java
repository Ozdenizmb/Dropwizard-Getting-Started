package com.user;

import io.dropwizard.core.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class UserConfiguration extends Configuration {
    // TODO: implement service configuration
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database;

    @Valid
    @NotNull
    @JsonProperty("flyway")
    private FlywayFactory flyway;

    public DataSourceFactory getDatabase() {
        return database;
    }

    public void setDatabase(DataSourceFactory database) {
        this.database = database;
    }

    public FlywayFactory getFlywayFactory() {
        return flyway;
    }

    public void setFlywayFactory(FlywayFactory flyway) {
        this.flyway = flyway;
    }
}
