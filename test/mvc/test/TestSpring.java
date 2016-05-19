package mvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.dao.system.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-*.xml"})
public class TestSpring {
	//private static final Logger log = LoggerFactory.getLogger(TestSpring.class);
	
	@Autowired
	UserDao userDao;
	@Test
	public void getSpring(){
		/*Session openSession = sessionFactory.openSession();
		System.out.println(openSession);
		User user = new User();
		user.setId(11111);
		Transaction transaction = openSession.beginTransaction();
		openSession.save(user);
		transaction.commit();
		openSession.close();*/
		User user = new User(11, "userName", "realName", "nb", "userKey", "password", "password", "1", "001");
	}
}
