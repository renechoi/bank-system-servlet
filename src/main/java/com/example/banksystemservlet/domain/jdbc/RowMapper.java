package com.example.banksystemservlet.domain.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper {
    Object mapRow(ResultSet resultSet) throws SQLException;
}
