package cn.only.dao;
import cn.only.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper mapper;
    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 导入需要测试的
        mapper = applicationContext.getBean(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception{
        User user = new User();
        user.setAge(18);
        user.setName("test");
        user.setPassword("123456");
        user.setDescription("云游四方");
        int result = mapper.insert(user);
        System.out.println(result);
        assert (result == 1);
    }

    @Test
    public void insert1() {
    }

    @Test
    public void insert2() {
    }
}