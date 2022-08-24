package com.zldx.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到ServletContext域对象创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到ServletContext域对象销毁");
    }
}
