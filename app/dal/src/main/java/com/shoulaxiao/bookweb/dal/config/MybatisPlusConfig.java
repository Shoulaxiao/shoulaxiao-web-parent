package com.shoulaxiao.bookweb.dal.config;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Slf4j
@Configuration
@MapperScan(basePackages = {"com.shoulaxiao.bookweb.dal.mp.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisPlusConfig {

}
