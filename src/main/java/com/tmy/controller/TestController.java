package com.tmy.controller;

import com.tmy.entry.Blog;
import com.tmy.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/page")
public class TestController {
    
    @Autowired BlogRepository blogRepository;

    @RequestMapping("/returnpage")
    public String page(){
        return "pagination";
    }

    @RequestMapping(value = "/showpage", method=RequestMethod.GET)
    @ResponseBody
    public Page<Blog> showPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Sort sort = new Sort(Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return blogRepository.findAll(pageable);
    }
    
    @RequestMapping(value = "/params", method=RequestMethod.GET)
    @ResponseBody
    public Page<Blog> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return blogRepository.findAll(pageable);
    }
    
    @RequestMapping(value = "", method=RequestMethod.GET)
    @ResponseBody
    public Page<Blog> getEntryByPageable(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) 
        Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

}
