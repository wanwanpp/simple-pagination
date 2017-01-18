package com.tmy.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmy.entry.Blog;
import com.tmy.repository.BlogRepository;

@Service
public class DataInit {
    
    @Autowired BlogRepository blogRepository;
    
    @PostConstruct
    public void dataInit(){
        for(Integer i = 0; i < 123; i++){
            Blog blog = new Blog();
            blog.setContent("this is blog content");
            blog.setTitle("blog" + i);
            blog = blogRepository.save(blog);
        }
    }

}
