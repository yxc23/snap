package com.atguigu.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MysqlSessionFactory {

	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {

		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// MysqlSessionFactory.class.getClassLoader().getResourceAsStream("mybatis-conf.xml");
		// Resources.getResourceAsStream("mybatis-conf.xml");
		if (sqlSessionFactory == null) {
			InputStream resourceAsStream = null;
			try {
				resourceAsStream = MysqlSessionFactory.class.getClassLoader().getResourceAsStream("mybatis-conf.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			sqlSessionFactory = sessionFactoryBuilder.build(resourceAsStream);
		}

		return sqlSessionFactory;
	}

}
