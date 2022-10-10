package cc.mcyou.bbsindex.service;

import cc.mcyou.bbsindex.controller.JsonController;
import cc.mcyou.bbsindex.dao.Chart1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Scheduler {

    @Autowired
    Spider spider;

    @Autowired
    Entity2ResData entity2ResData;

    @Autowired //
    Chart1Repository chart1Repository;

    @Scheduled(cron="0 58 23 * * ?")
    public void updateSpider() throws IOException {
        spider.start();
        JsonController.resDataCache = entity2ResData.trans(chart1Repository.findAll());
    }

    @Scheduled(cron="*/10 * * * * ?")
    public void refreshCache(){
        JsonController.resDataCache = entity2ResData.trans(chart1Repository.findAll());
    }

}
