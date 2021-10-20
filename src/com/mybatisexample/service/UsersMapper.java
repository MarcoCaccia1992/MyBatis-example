package com.mybatisexample.service;

import com.mybatisexample.entity.UsersEntity;

import java.util.List;
import java.util.Map;

/*
* interfaccia nella quale andiamo a definire quelli che poi dovranno essere i meodi richiamati
* e il corpo verrà dato tramite il file di configurazione XML
* */

public interface UsersMapper {

    public void insertNewUser(UsersEntity usersEntity);

    public void insertNewUserSP(Map<String, String> test);

    public UsersEntity getUsersById(Integer id_user);

    public List<UsersEntity> getAllUsers();

    public void updateUserNameSP(Map<String, Object> test);

    public void updateUserSurnameSP(Map<String, Object> test);

    public void updateUserEmailSP(Map<String, Object> test);

    public void updateUsersAllFieldsSP(Map<String, Object> test);

    public void updateUsersIDsSP(Integer id_user);

    public void deleteUser(Integer id_user);

    public void deleteUserSP(Integer id_user);
}
