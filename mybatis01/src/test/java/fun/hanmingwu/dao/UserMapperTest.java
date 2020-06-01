package fun.hanmingwu.dao;

import fun.hanmingwu.pojo.User;
import fun.hanmingwu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    private  Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public  void test() {
        //获取Sqlsession对象
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        //执行sql,获取代理对象
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }

    }
    @Test
    public void test2() throws IOException {
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);
        sqlsession.close();

    }
    @Test
    public void testInsert(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.addUser(new User(123, "hello", "1234"));
        //提交事务
        sqlsession.commit();

    }
    @Test
    public void testUpdate(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1, "qq", "1233413"));
        sqlsession.commit();
        sqlsession.close();
    }
    @Test
    public void testUpate2(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pname","nihao");
        map.put("ppwd","nihao");
        map.put("id","2");
        mapper.update(map);
        sqlsession.commit();
        sqlsession.close();
    }
    @Test
    public void log4JjTest(){

        logger.info("开始log4j方法");
        logger.debug("开始debug");
        logger.error(("错误"));
    }
    @Test
    public void testLimit(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map<String,Integer> map=new HashMap();
        map.put("startIndex",1);
        map.put("pageSize",2);
        List<User> user = mapper.getUserByLimit(map);
        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlsession.close();
    }
}
