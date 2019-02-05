package pl.domowe.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.domowe.dao.ArticleDao;
import pl.domowe.dao.AuthorDao;
import pl.domowe.dao.CategoryDao;
import pl.domowe.entity.Article;
import pl.domowe.entity.Author;
import pl.domowe.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {
    private ArticleDao articleDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;

    public HomePageController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/")
    public String homepage(Model model) {
        List<Article> articleList = articleDao.readLastNth(5);
        List<Article> articleListWithShortenContent = new ArrayList<>();
        for (Article article : articleList) { //obcinanie contentu
            String contentToShorten = article.getContent();
            if (contentToShorten.length()>200){
                article.setContent(contentToShorten.substring(0, 200)); //obcinanie contentu do 200 znaków <0,200)
            }
            articleListWithShortenContent.add(article);
        }
        model.addAttribute("last5article", articleListWithShortenContent);

        List<Category> categoryList = categoryDao.readAll();
        model.addAttribute("categoryList", categoryList);
        return "index";
    }

    @RequestMapping("/add-article")
    public String addArticle() {
        Article articleToAdd = new Article();

        Author authorToAdd = new Author();
        authorToAdd.setFirstName("author from explorer");
        authorToAdd.setLastName("lastName from explorer");
        authorDao.create(authorToAdd);
        authorToAdd = authorDao.read(1);


        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("category fromexplorer");
        category2.setName("category2 fromexplorer");
        categoryDao.create(category1);
        categoryDao.create(category2);

        List<Category> categoryList = categoryDao.readAll();


        articleToAdd.setAuthor(authorToAdd);
        articleToAdd.setCategory(categoryList);
        articleToAdd.setContent("content from explorer");
        articleToAdd.setTitle("title from explorer");

        articleDao.create(articleToAdd);
        return "index";
    }
}

