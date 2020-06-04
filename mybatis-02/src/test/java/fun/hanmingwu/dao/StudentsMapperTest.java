package fun.hanmingwu.dao;

import fun.hanmingwu.pojo.Students;
import fun.hanmingwu.pojo.Teacher;
import fun.hanmingwu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentsMapperTest {
    @Test
    public void testGetStudents(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        List<Students> students = mapper.getStudents2();
        for (Students student : students) {
            System.out.println(student);

        }

        sqlSession.close();
    }

    @Test
    public void getTeachetTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(2);
        System.out.println(teacher);
        sqlSession.close();
    }
}
