package org.example.controller;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Result;
import org.example.pojo.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category){
        categoryService.add(category);
        return Result.success();
    }
    //获取文章分类列表
    @GetMapping
    public Result<List<Category>> list(){
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }
    //获取文章分类详情
    @GetMapping("/detail")
    public  Result<Category> detail(Integer id){
        Category c = categoryService.findById(id);
        return Result.success(c);
    }
    //更新文章分类
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category){
        categoryService.update(category);
        return Result.success();
    }
    //删除文章分类
    @DeleteMapping
    public Result delete(Integer id){
        categoryService.deleteById(id);
        return Result.success();
    }
}
