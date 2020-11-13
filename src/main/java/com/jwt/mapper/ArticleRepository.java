package com.jwt.mapper;

import com.jwt.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article,String> {



}
