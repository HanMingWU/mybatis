package fun.hanmingwu.dao;

import fun.hanmingwu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    public void addBlog(Blog blog);
    public List<Blog> queryBlog(Map map);
}
