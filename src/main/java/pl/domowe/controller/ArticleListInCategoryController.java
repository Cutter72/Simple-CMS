package pl.domowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.domowe.dao.ArticleDao;
import pl.domowe.dao.AuthorDao;
import pl.domowe.dao.CategoryDao;
import pl.domowe.entity.Article;
import pl.domowe.entity.Category;

import java.util.List;

@Controller
public class ArticleListInCategoryController {
    private ArticleDao articleDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;

    public ArticleListInCategoryController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/articleListInCategory/{id}")
    public String showAllArticlesInCategory(@PathVariable String id, Model model) {
        List<Article> articleList = articleDao.readAllInCategory(Long.parseLong(id));
        model.addAttribute("articleListInCategory", articleList);
        for (Article article : articleList) {
            System.out.println(article);
        }
        String categoryName = categoryDao.read(Long.parseLong(id)).getName();
        model.addAttribute("categoryName", categoryName);
        return "articleListInCategory";
    }
}

