package cc.mcyou.bbsindex.controller;

import cc.mcyou.bbsindex.data.ResData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charts")
public class JsonController {

    public static ResData resDataCache;
    public static ResData resDataCache2;

    @GetMapping("/chart1")
    public ResData getChart1(){
        return resDataCache;
    }

    @GetMapping("/chart2")
    public ResData getChart2(){
        return resDataCache2;
    }



}
