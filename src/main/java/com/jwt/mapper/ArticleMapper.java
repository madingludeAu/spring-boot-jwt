package com.jwt.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jwt.domain.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
