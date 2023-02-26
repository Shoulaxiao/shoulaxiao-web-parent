package com.shoulaxiao.bookweb.boot.logs;

import org.slf4j.MDC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @athor : shoulaxiao
 * @description:
 * @date: 2021-03-16 19:18
 **/
public class Log4j2Startup {

    private static final String LOG_ROOT = "log.root";

    public static void startup() {
        Properties prop = new Properties();
        InputStream inputStream = Log4j2Startup.class.getClassLoader().getResourceAsStream("log4j2.properties");
        try {
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MDC.put(LOG_ROOT, prop.getProperty(LOG_ROOT));
    }

}
