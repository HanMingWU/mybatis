package fun.hanmingwu.dao;

import fun.hanmingwu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
     List<User> getUserList();
     User getUserById(int id);
     int addUser(User user);
     int updateUser(User user);
     int update(Map<String, Object> map);
     List<User> getUserByLimit(Map<String,Integer> map);

}
