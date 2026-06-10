package org.example.friendapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendapp.domain.Article;
import org.example.friendapp.serviece.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    //추가
    @GetMapping("/add")
    public String articleAddForm() {
        return "article/add";
    }
    @PostMapping("/addProc")
    public String articleAddProc(@ModelAttribute Article article) {
        articleService.addArticle(article);
        return "redirect:/articles";
    }

    //목록
    @GetMapping
    public String articleList(Model model,
                            RedirectAttributes redirectAttributes,
                            @PageableDefault(size = 5, sort = "id",
                                    direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Article> articles = articleService.getArticles(pageable);
        model.addAttribute("articles", articles);
        return "article/list";
    }

    //view
    @GetMapping("/{id}")
    public String articleView(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try{
            Article article = articleService.getArticle(id);
            model.addAttribute("article", article);
            return "article/view";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "없는 계시물입니다.");
            return "redirect:/articles";
        }

    }

    //수정
    @GetMapping("/{id}/edit")
    public String articleEditForm(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article/edit";
    }
    @PostMapping("/{id}/editProc")
    public String articleEditProc(@PathVariable("id") Long id,
                                @ModelAttribute Article article) {
        article.setId(id);
        articleService.updateArticle(article);
        return "redirect:/articles/" + id;
    }

    //삭제
    @PostMapping("/{id}/delete")
    public String articleDelete(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return "redirect:/articles";
    }
}