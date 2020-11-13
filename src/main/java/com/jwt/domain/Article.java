package com.jwt.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.io.Serializable;

@Data
@TableName("cms_article_data")
@Document(indexName = "mydoct", type = "mybean")
public class Article implements Serializable {


    private static final long serialVersionUID = -6097833530571181748L;

    @Id
    private String id;


    private String content;


}
