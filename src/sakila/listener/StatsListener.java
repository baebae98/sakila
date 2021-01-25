package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

import sakila.service.*;

@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
	
	// 세션 여부를 확인하여 생성된 경우 StatsService 객체 생성 및 countStats 메소드 실행
	// 오늘 날짜를 DB에서 확인하고 날짜를 확인 후 count를 +1
	
	// 세션이 새롭게 생성된 경우
    public void sessionCreated(HttpSessionEvent se)  {
         if (se.getSession().isNew()) {
        	 statsService = new StatsService();		// StatsServie 객체 생성
        	 statsService.countStats();		// countStats 메소드 실행
         }
    }
    
    // 세션이 종료된 경우
    public void sessionDestroyed(HttpSessionEvent se)  { 
         
    }
}
