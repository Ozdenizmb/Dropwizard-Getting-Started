CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.users
(
    id                  uuid DEFAULT uuid_generate_v4(),
    first_name               VARCHAR NOT NULL,
    last_name                VARCHAR NOT NULL,
    email                    VARCHAR NOT NULL UNIQUE,
    password                 VARCHAR NOT NULL,
    PRIMARY KEY (id)
);
