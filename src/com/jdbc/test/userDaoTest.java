package com.jdbc.test;

import com.jdbc.Dao.userDao;
import com.jdbc.Dto.userDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class userDaoTest {
    private userDao userDao = new userDao();


    @Test
    public void testinsetIntoUser() {
        userDto userDto = new userDto("darin", "123456");
        int i = userDao.insertIntoUser(userDto);

        assertEquals(i, 1);
    }

    @Test
    public void updateUserTest() {
        userDto userDto = new userDto(6, "darin123");
        int i = userDao.updateUser(userDto);
        assertEquals(i, 1);
    }

    @Test
    public void deleteUserTest() {
        userDto userDto = new userDto(7);
        int i = userDao.deleteUser(userDto);
        assertEquals(i, 1);
    }

    @Test
    public void queryDataTest() {
        userDto userDto = userDao.queryData("haiqing");
        System.out.println(userDto);

    }

    @Test
    public void queryDatasTest() {
        userDto userDto = userDao.queryDatas("gao");
        System.out.println(userDto);
    }

    @Test
    public void queryListDatasTest() {
        List<userDto> list = userDao.queryListDatas("gao");
        for (userDto userDto : list) {
            System.out.println(userDto);
        }
    }
}
