package com.user.repository.sql;

public class UserSqlQueries {

    private UserSqlQueries(){}

    public static final String INSERT_QUERY = "INSERT INTO util_sch.USERS(first_name, last_name, email, password) " +
            "VALUES (:firstName, :lastName, :email, :password) RETURNING id";
    public static final String SELECT_QUERY_FOR_ID = "SELECT * FROM util_sch.USERS WHERE id = :id";
    public static final String SELECT_QUERY_FOR_EMAIL = "SELECT * FROM util_sch.USERS WHERE email = :email";
    public static final String UPDATE_QUERY = "UPDATE util_sch.USERS SET first_name=:firstName, last_name=:lastName, " +
            "email=:email, password=:password WHERE id = :id RETURNING *;";
    public static final String DELETE_QUERY = "DELETE FROM util_sch.USERS WHERE id = :id";

}
