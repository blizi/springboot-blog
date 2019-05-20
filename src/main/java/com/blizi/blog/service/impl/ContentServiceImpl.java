package com.blizi.blog.service.impl;

import com.blizi.blog.entity.Markdown;
import com.blizi.blog.entity.User;
import com.blizi.blog.mapper.MarkdownMapper;
import com.blizi.blog.service.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private MarkdownMapper markdownMapper;

    @Override
    public Markdown getMarkDownById(Integer id) {
        Example example = new Example(Markdown.class);
        example.createCriteria().andEqualTo("id",id);
        List<Markdown> markdowns = markdownMapper.selectByExample(example);
        return markdowns.get(0);
    }

    @Override
    public PageInfo<Markdown> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Markdown.class);
        PageInfo<Markdown> info = new PageInfo<>(markdownMapper.selectByExample(example));
        return info;
    }

    @Override
    public void addContent(Markdown markdown) {
        markdownMapper.insert(markdown);
    }
}
