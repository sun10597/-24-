package org.example.friendapp.Repository;
import org.springframework.data.repository.CrudRepository;
import org.example.friendapp.domain.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends CrudRepository<Article, Long>, PagingAndSortingRepository<Article, Long> {
}