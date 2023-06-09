package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        Blog blog=new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setPubDate(new Date());
        User user=userRepository1.findById(userId).get();

        blog.setUser(user);

        List<Blog> userBlogs=user.getBlogList();
        userBlogs.add(blog);

        User savedUser=userRepository1.save(user);
        List<Blog> blogs=savedUser.getBlogList();
        Blog blog1=blogs.get(blogs.size()-1);
        return blog1;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);

    }
}
