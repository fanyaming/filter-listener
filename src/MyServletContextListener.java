/**
 * Created by lenovo on 2020/4/7.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@WebListener()
public class MyServletContextListener implements ServletContextListener{
    // Public constructor is required by servlet spec
    public MyServletContextListener() {
    }
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context创建了...");
        //开启一个定时任务调度——每天晚上12点计息一次
        Timer timer = new Timer();
        //实际计时器开始后,需要执行的任务
        //1.起始时间，定义成晚上12点
        //2.间隔时间：24小时
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = "2019-01-01 00:00:00";
        Date date = null;
        try {
            date = format.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务开启了...");
            }
        }, date, 24*60*60*1000);
    }
    //监听context域对象的销毁
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context销毁了...");
    }

}
