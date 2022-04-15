package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pccc.sip.ivrtest.mapper.TagDictionaryMapper;
import com.pccc.sip.ivrtest.pojo.TagDictionary;
import com.pccc.sip.ivrtest.service.TagDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagDictionaryServiceImpl extends ServiceImpl<TagDictionaryMapper, TagDictionary> implements TagDictionaryService {
    @Autowired
    private TagDictionaryMapper tagDictionaryMapper;


    @Override
    public int addTagDictionary(TagDictionary tagDictionary) {
        return tagDictionaryMapper.insert(tagDictionary);
    }

    @Override
    public int updateTagDictionary(TagDictionary tagDictionary) {
        return tagDictionaryMapper.updateById(tagDictionary);
    }

    @Override
    public int deleteTagDictionaryById(String id) {
        return tagDictionaryMapper.deleteById(id);
    }

    @Override
    public TagDictionary findTagDictionaryById(String id) {
        return tagDictionaryMapper.selectById(id);
    }
}
