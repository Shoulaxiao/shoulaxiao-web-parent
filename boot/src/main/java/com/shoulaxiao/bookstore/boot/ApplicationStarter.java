package com.shoulaxiao.bookstore.boot;

import com.shoulaxiao.bookstore.boot.logs.Log4j2Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @athor : shoulaxiao
 * @description:
 * @date: 2021-03-16 19:17
 **/
@SpringBootApplication(scanBasePackages = {"com.shoulaxiao.bookstore.*"},
        exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@PropertySource(value = {
        "classpath:db.properties",
        "classpath:applicationconf.properties"
})
@EnableAsync
@ImportResource(locations = {"classpath*:/biz-beans.xml"})
public class ApplicationStarter extends SpringBootServletInitializer implements ApplicationRunner, EnvironmentAware {

    private Environment environment;


    private static final Logger logger = LoggerFactory.getLogger(ApplicationStarter.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationStarter.class);
        Log4j2Startup.startup();
        try {
            springApplication.run(args);
        } catch (Exception e) {
            logger.error("项目启动失败", e);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        Log4j2Startup.startup();
        return builder.sources(ApplicationStarter.class);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("====================应用启动成功==========================");
        logger.info("----\tDSF端口:{}", this.environment.getProperty("PORT1"));
        logger.info("----\t环境为:{}", this.environment.getProperty("sof-env"));
        logger.info("==============================================");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
