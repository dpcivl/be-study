package com.study.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 할 일과 카테고리를 한 번에 가져오기
    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.category")
    List<Todo> findAllWithCategory();
}