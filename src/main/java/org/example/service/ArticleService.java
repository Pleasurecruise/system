package org.example.service;

import org.example.pojo.Article;
import org.example.pojo.PageBean;

public interface ArticleService {
    // 添加文章
    void add(Article article);
    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state);

    Article findById(Integer id);

    void update(Article article);

    void deleteById(Integer id);
}