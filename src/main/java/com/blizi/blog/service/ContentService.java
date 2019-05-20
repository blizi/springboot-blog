package com.blizi.blog.service;

import com.blizi.blog.entity.Markdown;
import com.github.pagehelper.PageInfo;

public interface ContentService {
    Markdown getMarkDownById(Integer id);
    PageInfo<Markdown> page(int pageNum , int pageSize);
    void addContent(Markdown markdown);
}
