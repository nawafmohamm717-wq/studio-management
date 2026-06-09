package com.studio.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {  
       protected Connection connection;
    protected String tableName;
 
     protected int executeUpdate(
            String sql,
            Object... params) {

        try (
                Connection conn = DBHelper.connection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    protected ResultSet executeQuery(
            String sql,
            Object... params) throws SQLException {

        Connection conn = DBHelper.connection();

        PreparedStatement ps = conn.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }

        return ps.executeQuery();
    }


 
    public BaseDAO(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    public abstract boolean insert(T entity) throws SQLException;
    public abstract boolean update(T entity) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
}
