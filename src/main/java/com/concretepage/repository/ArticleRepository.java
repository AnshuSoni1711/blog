package com.concretepage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.concretepage.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long>  {
    List<Article> findByAuthor(String title);
}
