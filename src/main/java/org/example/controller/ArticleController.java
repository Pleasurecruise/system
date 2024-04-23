package org.example.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.Article;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.ArticleService;
import org.example.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
        @Autowired
        private ArticleService articleService;
        //新增文章
        @PostMapping
        public Result add(@RequestBody @Validated Article article) {
            articleService.add(article);
            return Result.success();
        }
        //获取文章列表
        @GetMapping
        public Result<PageBean<Article>> list(Integer pageNum, Integer pageSize, @RequestParam(required = false) String categoryId, @RequestParam(required = false) String state) {
            PageBean<Article> pageBean = articleService.list(pageNum, pageSize, categoryId, state);
            return Result.success(pageBean);
        }
        //获取文章详情
        @GetMapping("/detail")
        public Result<Article> detail(@RequestParam Integer id) {
            Article article = articleService.findById(id);
            return Result.success(article);
        }
        //更新文章
        @PutMapping
        public Result update(@RequestBody Article article) {
            articleService.update(article);
            return Result.success();
        }
        //删除文章
        @PostMapping("/delete")
        public Result delete(@RequestParam Integer id) {
            articleService.deleteById(id);
            return Result.success();
        }
}
