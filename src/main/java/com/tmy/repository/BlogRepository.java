package com.tmy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tmy.entry.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    
    Page<Blog> findByDeletedFalse(Pageable pageable);

}
