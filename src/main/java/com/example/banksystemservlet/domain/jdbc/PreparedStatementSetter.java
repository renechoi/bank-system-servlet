package com.example.banksystemservlet.domain.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter {
    void setPreparedStatement(PreparedStatement preparedStatement) throws SQLException;
}
