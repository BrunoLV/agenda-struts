package com.valhala.agenda.persistencia.factories;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


public class MyBatisSessionFactory {

    private static final String CONFIG_RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIG_RESOURCE);
            if (factory == null) {
                factory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return factory;
    }

}
