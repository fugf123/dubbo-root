import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.fugf.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 测试类
 */
public class Application {

    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("ddd");){
            List list = new ArrayList();
            list.stream().forEach((Object o)-> {

                }
            );

            Collections.sort(list, (String a, String b) -> {
                return b.compareTo(a);
            });
        }catch (Exception e){

        }
        try {
            ClassPathXmlApplicationContext applicationContext =
                    new ClassPathXmlApplicationContext("spring-context.xml");

        }catch (Exception e){
            e.printStackTrace();
        }
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context.xml");
        applicationContext.start();
        System.out.println("服务已经启动");
        synchronized (Application.class){
            while (true){
                try {
                    applicationContext.wait();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        //ServiceConfig serviceConfig = new ServiceConfig();
        //serviceConfig.setApplication(new ApplicationConfig("spring-context"));
        //优雅关闭dubbo
        //ProtocolConfig.destroyAll();
    }
}
