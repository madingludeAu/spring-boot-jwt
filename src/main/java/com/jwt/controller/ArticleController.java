package com.jwt.controller;

import com.jwt.domain.Article;
import com.jwt.mapper.ArticleMapper;
import com.jwt.mapper.ArticleRepository;
import com.jwt.response.ResultResponse;
import com.jwt.utils.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("getContent")
    public ResultResponse getContent(){

        List<Article> articles = articleMapper.selectList(null);
        for (Article article : articles) {
            articleRepository.save(article);
        }
        return new ResultResponse(0,"success",articles);
    }

    @RequestMapping("chax")
    public ResultResponse chax(){
        List<String> strings = EsUtils.listSuggestCompletion("content", "世界一流大学", 10, "mydoct", "mybean", elasticsearchTemplate);


        return new ResultResponse(0,"success",strings);
    }

    @RequestMapping("del")
    public ResultResponse del(){
        articleRepository.deleteAll();
        return new ResultResponse(0,"success","");
    }
}
