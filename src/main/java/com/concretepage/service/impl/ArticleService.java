package com.concretepage.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.concretepage.entity.Topic;
import com.concretepage.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.Article;
import com.concretepage.repository.ArticleRepository;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public Article getArticleById(long articleId) {
		Article obj = articleRepository.findById(articleId).get();
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		List<Article> list = new ArrayList<>();
		articleRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public List<Article> getArticlesByAuthor(String authorNme) {
		List<Article> list = articleRepository.findByAuthor(authorNme);
		return list;
	}

	@Override
	public synchronized boolean addArticle(Article article){
    	   articleRepository.save(article);
    	   return true;
	}


	@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleRepository.delete(getArticleById(articleId));
	}
}
