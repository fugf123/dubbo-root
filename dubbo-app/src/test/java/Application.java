import com.fugf.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class Application {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context.xml");
        applicationContext.start();
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService.listUserName());
    }
}
