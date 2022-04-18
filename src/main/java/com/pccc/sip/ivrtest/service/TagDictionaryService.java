package com.pccc.sip.ivrtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pccc.sip.ivrtest.pojo.TagDictionary;

public interface TagDictionaryService extends IService<TagDictionary> {
    int addTagDictionary(TagDictionary tagDictionary);

    int updateTagDictionary(TagDictionary tagDictionary);

    int deleteTagDictionaryById(int id);

    TagDictionary findTagDictionaryById(int id);
}
