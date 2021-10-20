package com.mybatisexample.service;

import com.mybatisexample.configuration.MyBatisConfig;
import com.mybatisexample.entity.UsersEntity;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersMapperImpl implements UsersMapper {

    @Override
    public void insertNewUser(UsersEntity usersEntity) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.insertNewUser(usersEntity);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertNewUserSP(Map<String, String> test) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.insertNewUserSP(test);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public UsersEntity getUsersById(Integer id_user) {

        UsersEntity usersEntityResult = new UsersEntity();

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.getUsersById(id_user);

            usersEntityResult = usersMapper.getUsersById(id_user);

        }catch (Exception e){
            e.printStackTrace();
        }

        return usersEntityResult;
    }

    @Override
    public List<UsersEntity> getAllUsers() {

        List<UsersEntity> usersEntityListResult = new ArrayList<>();

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(); // si apre una sessione tramite la classe di configurazione
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.getAllUsers();

            usersEntityListResult = usersMapper.getAllUsers();

        }catch (Exception e){
            e.printStackTrace();
        }

        return usersEntityListResult;
    }

    @Override
    public void updateUserNameSP(Map<String, Object> test) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.updateUserNameSP(test);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserSurnameSP(Map<String, Object> test) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.updateUserSurnameSP(test);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserEmailSP(Map<String, Object> test) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.updateUserEmailSP(test);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUsersAllFieldsSP(Map<String, Object> test) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.updateUsersAllFieldsSP(test);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUsersIDsSP(Integer id_user) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.updateUsersIDsSP(id_user);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id_user) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.deleteUser(id_user);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserSP(Integer id_user) {

        try{

            SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            usersMapper.deleteUserSP(id_user);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
