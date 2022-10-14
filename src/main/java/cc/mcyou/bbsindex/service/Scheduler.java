package cc.mcyou.bbsindex.service;

import cc.mcyou.bbsindex.controller.JsonController;
import cc.mcyou.bbsindex.dao.ChartRepository;
import cc.mcyou.bbsindex.data.EntityChart;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@ConfigurationProperties(prefix = "bbsindex")
@Data
public class Scheduler {

    @Autowired
    Spider spider;
    @Autowired
    Entity2ResData entity2ResData;
    @Autowired
    ChartRepository chartRepository;

    static int refreshTime = 10;

    @Scheduled(cron="${cron1:* * * * * ?}")
    public void updateSpider() throws IOException {
        spider.start();
        List<EntityChart> entityChartList = chartRepository.findAll();
        JsonController.resDataCache = entity2ResData.trans1(entityChartList);
        JsonController.resDataCache2 = entity2ResData.trans2(entityChartList);
        JsonController.resDataCache3 = entity2ResData.trans3(entityChartList);
        JsonController.resDataCache4 = entity2ResData.trans4(entityChartList);
    }

    @Scheduled(cron="${cron2:* * * * * ?}")
    public void refreshCache(){
        List<EntityChart> entityChartList = chartRepository.findAll();
        JsonController.resDataCache = entity2ResData.trans1(entityChartList);
        JsonController.resDataCache2 = entity2ResData.trans2(entityChartList);
        JsonController.resDataCache3 = entity2ResData.trans3(entityChartList);
        JsonController.resDataCache4 = entity2ResData.trans4(entityChartList);
    }

}
