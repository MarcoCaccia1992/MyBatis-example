package com.mybatisexample.configuration;


import com.mybatisexample.service.UsersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/*
* classe di configurazione che si rifarà ad un file di configurazione a sua volta .XML
* nominato appunto nel metodo "getResourceAsReader(myBatisConfig);
* "*/

public class MyBatisConfig {

    private static SqlSessionFactory sqlSessionFactory;

    static{

        String myBatisConfig = "mybatis-config.xml";
        Reader reader = null;

        try{

            reader = Resources.getResourceAsReader(myBatisConfig);

        }catch(IOException e){
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    }

    public static SqlSessionFactory getSqlSessionFactory(){

        return sqlSessionFactory;
    }
}
