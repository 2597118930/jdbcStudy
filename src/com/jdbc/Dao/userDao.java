package com.jdbc.Dao;

import com.jdbc.utils.DruidUtils;
import com.jdbc.Dto.userDto;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
    private Connection connection = DruidUtils.getConnection();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public int insertIntoUser(userDto userDto) {
        int i = 0;
        try {
            String sql = "insert into User(username,password) values(?,?)";
            Object[] params = {userDto.getUsername(), userDto.getPassword()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());

            i = queryRunner.update(sql, params);
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return i;
    }

    public int updateUser(userDto userDto) {
        int i = 0;
        try {
            String sql = "update User set password=? where id=?;";
            Object params[] = {userDto.getPassword(), userDto.getId()};

            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    public int deleteUser(userDto userDto) {
        int i =0;
        try {
            String sql = "delete from User where id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());
            i= queryRunner.update(sql, userDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}

