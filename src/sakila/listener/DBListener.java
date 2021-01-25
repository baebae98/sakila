package sakila.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {
    // TOMCAT이 켜질 때 실행
	public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("Debug: DBListener.contextInitialized() 실행");
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");
    		System.out.println("Debug: MariaDB 드라이버 로딩");
    	} catch(ClassNotFoundException e) {
    		System.out.println("Debug: MariaDB 드라이버 로딩 실패");
    		e.printStackTrace();
    	}
    }
    
    // TOMCAT이 꺼질 때 실행
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // 주석
    }
}