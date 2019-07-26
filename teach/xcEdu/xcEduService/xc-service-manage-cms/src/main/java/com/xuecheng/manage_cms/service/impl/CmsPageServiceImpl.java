package com.xuecheng.manage_cms.service.impl;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResultCode;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CmsPageServiceImpl implements CmsPageService {
    @Autowired
    private CmsPageRepository cmsPageRepository;
    /**
     * 分页查询所有
     * @param page 页码从1计数
     * @param size 每页记录条数
     * @param queryPageRequest 查询条件
     * @return
     */
    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        System.out.println("2222222222222222222222");
         if(page<=0){
            page=1;
        }
        if(size<=0){
            size=10;
        }
        if(queryPageRequest==null){
            queryPageRequest=new QueryPageRequest();
        }

        Pageable pageable = PageRequest.of(page, size);
        CmsPage cmsPage=new CmsPage();
        if(queryPageRequest.getTemplateId()!=null){
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        if(queryPageRequest.getSiteId()!=null){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        System.out.println(queryPageRequest.getPageAliase());
        if(queryPageRequest.getPageAliase()!=null){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        ExampleMatcher exampleMatcher =ExampleMatcher.matching();
        exampleMatcher=exampleMatcher.withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsPage> example=Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(example,pageable);
        ResultCode commonCode=CommonCode.SUCCESS;
        QueryResult queryResult=new QueryResult();
        queryResult.setList(cmsPages.getContent());
        queryResult.setTotal(cmsPages.getTotalPages());
        QueryResponseResult queryResponseResult=new QueryResponseResult(commonCode, queryResult);
        return queryResponseResult;
    }
}
