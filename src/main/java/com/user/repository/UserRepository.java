package com.user.repository;

import com.user.model.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.UUID;

import static com.user.repository.sql.UserSqlQueries.DELETE_QUERY;
import static com.user.repository.sql.UserSqlQueries.INSERT_QUERY;
import static com.user.repository.sql.UserSqlQueries.SELECT_QUERY_FOR_EMAIL;
import static com.user.repository.sql.UserSqlQueries.SELECT_QUERY_FOR_ID;
import static com.user.repository.sql.UserSqlQueries.UPDATE_QUERY;

@RegisterBeanMapper(User.class)
public interface UserRepository {

    @SqlQuery(INSERT_QUERY)
    UUID save(@BindBean User user);

    @SqlQuery(SELECT_QUERY_FOR_ID)
    User getById(@Bind("id") UUID id);

    @SqlQuery(SELECT_QUERY_FOR_EMAIL)
    User getByEmail(@Bind("email") String email);

    @SqlQuery(UPDATE_QUERY)
    User update(@Bind("id") UUID id, @BindBean User user);

    @SqlUpdate(DELETE_QUERY)
    Boolean delete(@Bind("id") UUID id);

}
