package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.entity.BaseResponse;
import com.pccc.sip.ivrtest.pojo.TagDictionary;
import com.pccc.sip.ivrtest.service.TagDictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labalDic")
public class TagDictionaryController {
    @Autowired
    private TagDictionaryService tagDictionaryService;

    BaseResponse response = new BaseResponse();

    //增
    @PostMapping(value = "/add")
    public Object add(@RequestBody TagDictionary tagDictionary) {
        if (StringUtils.equals(String.valueOf(tagDictionaryService.addTagDictionary(tagDictionary)), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    //改
    @PostMapping(value = "/update")
    public Object update(@RequestBody TagDictionary tagDictionary) {
        if (StringUtils.equals(String.valueOf(tagDictionaryService.updateTagDictionary(tagDictionary)), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    //删
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody TagDictionary tagDictionary) {
        if (StringUtils.equals(String.valueOf(tagDictionaryService.deleteTagDictionaryById(tagDictionary.getId())), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    // 查
    @PostMapping(value = "/queryList")
    public TagDictionary getUserByName(@RequestBody TagDictionary tagDictionary) {
        return tagDictionaryService.findTagDictionaryById(tagDictionary.getId());
    }

}
