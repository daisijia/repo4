package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    private CmsPageService cmsPageService;
    /**
     * 分页查询所有
     * @param page 页码从1计数
     * @param size 每页记录条数
     * @param queryPageRequest 查询条件
     * @return
     */
    @RequestMapping("/list/{page}/{size}")
    @Override
    public QueryResponseResult findList(@PathVariable(value = "page") int page,@PathVariable(value = "size") int size, QueryPageRequest queryPageRequest) {
        /*ResultCode resultCode=CommonCode.SUCCESS;
        QueryResult queryResult=new QueryResult<CmsPage>();
        queryResult.setTotal(1);
        List<CmsPage> list=new ArrayList<CmsPage>();
        CmsPage cmsPage=new CmsPage();
        cmsPage.setPageName("华为");
        list.add(cmsPage);
        queryResult.setList(list);
        QueryResponseResult result=new QueryResponseResult(resultCode,queryResult);*/
        System.out.println("11111111111111111");
        return cmsPageService.findList(page,size,queryPageRequest);
    }
}
