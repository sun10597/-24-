package org.example.friendapp.serviece;

import lombok.RequiredArgsConstructor;

import org.example.friendapp.Repository.ArticleRepository;
import org.example.friendapp.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public Article getArticle(Long id) {
        return articleRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Article> getArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }
}