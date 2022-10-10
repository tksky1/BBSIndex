package cc.mcyou.bbsindex.controller;

import cc.mcyou.bbsindex.dao.Chart1Repository;
import cc.mcyou.bbsindex.data.EntityChart1;
import cc.mcyou.bbsindex.data.ResData;
import cc.mcyou.bbsindex.service.Entity2ResData;
import cc.mcyou.bbsindex.service.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charts")
public class JsonController {

    @Autowired
    Chart1Repository chart1Repository;

    @Autowired
    Entity2ResData entity2ResData;

    public static ResData resDataCache;

    @GetMapping("/chart1")
    public ResData getChart1(){
        return resDataCache;

    }

    public void refreshCache(){
        resDataCache = entity2ResData.trans(chart1Repository.findAll());
    }


}
