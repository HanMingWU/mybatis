package fun.hanmingwu.dao;

import fun.hanmingwu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yuki
 */
public interface TeacherMapper {
    @Select("select * from mybatis.teacher where id=#{id}")
    public Teacher getTeacher(@Param("id") int id2);
}
