package cc.mcyou.bbsindex.service;

import cc.mcyou.bbsindex.data.EntityChart;
import cc.mcyou.bbsindex.data.ResData;
import cc.mcyou.bbsindex.data.SeriesData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Entity2ResData {
    public ResData trans1(List<EntityChart> list){
        ResData resData = new ResData();
        SeriesData seriesData = new SeriesData();
        seriesData.setName("服务器总数");
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        for(EntityChart entity : list){
            numList.add(entity.getNum());
            dateList.add(entity.getDate());
        }
        seriesData.setData(numList);
        resData.setXAxis(dateList);
        resData.setSeries(seriesData);
        return resData;
    }

    public ResData trans2(List<EntityChart> list){
        ResData resData = new ResData();
        SeriesData seriesData = new SeriesData();
        seriesData.setName("服务器指数");
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        for(EntityChart entity : list){
            numList.add(entity.getServer_index());
            dateList.add(entity.getDate());
        }
        seriesData.setData(numList);
        resData.setXAxis(dateList);
        resData.setSeries(seriesData);
        return resData;
    }
}
