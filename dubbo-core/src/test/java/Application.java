import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.fugf.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class Application {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("spring-context.xml");
//        applicationContext.start();
//        System.out.println("服务已经启动");
//        synchronized (Application.class){
//            while (true){
//                try {
//                    applicationContext.stop();
//                }catch (Exception e){
//                    System.out.println(e);
//                }
//            }
//        }
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(new ApplicationConfig("spring-context"));
        //优雅关闭dubbo
        //ProtocolConfig.destroyAll();
    }
}
