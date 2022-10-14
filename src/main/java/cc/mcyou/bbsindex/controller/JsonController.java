package cc.mcyou.bbsindex.controller;

import cc.mcyou.bbsindex.data.Chart4Data;
import cc.mcyou.bbsindex.data.ResData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class JsonController {

    public static ResData resDataCache;
    public static ResData resDataCache2;
    public static ResData resDataCache3;
    public static List<Object> resDataCache4;

    @GetMapping("/chart1")
    public ResData getChart1(){
        return resDataCache;
    }

    @GetMapping("/chart2")
    public ResData getChart2(){
        return resDataCache2;
    }

    @GetMapping("/chart3")
    public ResData getChart3(){
        return resDataCache3;
    }

    @GetMapping("/chart4")
    public Chart4Data getChart4(){
        return new Chart4Data(resDataCache4);
    }

}
