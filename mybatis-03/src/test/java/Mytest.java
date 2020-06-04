import fun.hanmingwu.dao.BlogMapper;
import fun.hanmingwu.pojo.Blog;
import fun.hanmingwu.utils.IDUtils;
import fun.hanmingwu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {
    @Test
    public void addBolg(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setAuthor("houdongun");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        blog.setTitle("first");

        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("second");
        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("third");
        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("forth");
        blogMapper.addBlog(blog);
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void testQuery(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title","second");
        List<Blog> blogs = blogMapper.queryBlog(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);

        }

    }
}
