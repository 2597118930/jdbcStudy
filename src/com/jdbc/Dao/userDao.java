package com.jdbc.Dao;

import com.jdbc.utils.DruidUtils;
import com.jdbc.Dto.userDto;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class userDao {
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
        int i = 0;
        try {
            String sql = "delete from User where id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());
            i = queryRunner.update(sql, userDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //查询一条记录
    public userDto queryData(String username) {
        userDto userDto = null;

        try {
            String sql = "select id Id,username username,password password from User where username=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());
            userDto = queryRunner.query(sql, new BeanHandler<userDto>(userDto.class), username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDto;
    }

    //自定义ResultSetHandle结果数据
    public userDto queryDatas(String username) {
        userDto userDto = null;

        try {
            String sql = "select id Id,username username,password password from User where username=?;";

            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());

            ResultSetHandler<userDto> resultSetHandler = new ResultSetHandler<userDto>() {
                @Override
                public userDto handle(ResultSet resultSet) throws SQLException {
                    userDto userDto = null;
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");

                        userDto = new userDto(id, username, password);
                    }
                    return userDto;
                }
            };

            userDto = queryRunner.query(sql, resultSetHandler, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userDto;
    }


    //查询多条数据
    public List<userDto> queryListDatas(String username) {
        List<userDto> list = null;

        try {
            String sql = "select id,username,password from User where username=?";

            QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());
            list = queryRunner.query(sql, new BeanListHandler<userDto>(userDto.class), username);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    //返回一条数据
    public int getconnt() {
        int count = 0;

        String sql = "select count(1) from User";

        QueryRunner queryRunner = new QueryRunner(DruidUtils.dataSource());

        ScalarHandler<Long> scalarHandler = new ScalarHandler<Long>();
        try {
            long l = queryRunner.query(sql, scalarHandler);
            count = (int) l;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }



}

