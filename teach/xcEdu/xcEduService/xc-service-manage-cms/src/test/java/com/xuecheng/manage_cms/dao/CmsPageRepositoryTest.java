package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsPageRepositoryTest  {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     * 分页查询所有
     */
    @Test
    public void testCmsPageRepository(){
//        List list = cmsPageRepository.findAll();
        Pageable pageable= PageRequest.of(0,10);

        Page<CmsPage> list = cmsPageRepository.findAll(pageable);
        System.out.println(list.getSize());
        for (CmsPage cmsPage : list) {
            System.out.println(cmsPage);
        }
    }

    /**
     * 分页条件查询
     */
    @Test
    public void testCmsPageRepositoryFindAll(){
        Pageable pageable= PageRequest.of(0,10);
        CmsPage cmsPage=new CmsPage();
        //cmsPage.setPageName("百度");
        cmsPage.setPageAliase("轮播图");

        
        ExampleMatcher exampleMatcher=ExampleMatcher.matching();
        exampleMatcher=exampleMatcher.withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsPage> example=Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> list = cmsPageRepository.findAll(example,pageable);
        System.out.println(list.getSize());
        for (CmsPage cmsPage1 : list) {
            System.out.println(cmsPage);
        }
    }
    /**
     * 添加
     */
    @Test
    public void testCmsPageRepositoryAdd() {
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("百度");
        cmsPageRepository.save(cmsPage);

    }
    /**
     * 修改
     */
    @Test
    public void testCmsPageRepositoryUpdate() {


        Optional<CmsPage> byId = cmsPageRepository.findById("5d35d01225d33014d8d85114");
        if(byId.isPresent()){
            CmsPage cmsPage1 = byId.get();
            cmsPage1.setPageName("baidu");
            cmsPageRepository.save(cmsPage1);
        }

    }
}
