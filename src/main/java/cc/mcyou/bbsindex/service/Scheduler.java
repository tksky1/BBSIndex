package cc.mcyou.bbsindex.service;

import cc.mcyou.bbsindex.controller.JsonController;
import cc.mcyou.bbsindex.dao.ChartRepository;
import cc.mcyou.bbsindex.data.EntityChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Scheduler {

    @Autowired
    Spider spider;
    @Autowired
    Entity2ResData entity2ResData;
    @Autowired
    ChartRepository chartRepository;

    static final int refreshTime = 10;

    @Scheduled(cron="0 58 23 * * ?")
    public void updateSpider() throws IOException {
        spider.start();
        List<EntityChart> entityChartList = chartRepository.findAll();
        JsonController.resDataCache = entity2ResData.trans1(entityChartList);
        JsonController.resDataCache2 = entity2ResData.trans2(entityChartList);
    }

    @Scheduled(cron="*/"+ refreshTime + " * * * * ?")
    public void refreshCache(){
        List<EntityChart> entityChartList = chartRepository.findAll();
        JsonController.resDataCache = entity2ResData.trans1(entityChartList);
        JsonController.resDataCache2 = entity2ResData.trans2(entityChartList);
    }

}
