package cc.mcyou.bbsindex.service;

import cc.mcyou.bbsindex.data.EntityChart;
import cc.mcyou.bbsindex.data.ResData;
import cc.mcyou.bbsindex.data.SeriesData;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class Entity2ResData {
    public ResData trans1(List<EntityChart> list){
        ResData resData = new ResData();
        SeriesData seriesData = new SeriesData();
        seriesData.setName("服务器总数");
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> extraList = new ArrayList<>();
        for(EntityChart entity : list){
            numList.add((long) entity.getNum());
            dateList.add(entity.getDate());
            extraList.add(entity.getCnt_gy());
        }
        seriesData.setData(numList);
        resData.setXAxis(dateList);
        resData.setSeries(seriesData);
        resData.setExtraData(extraList);
        return resData;
    }

    public ResData trans2(List<EntityChart> list){
        ResData resData = new ResData();
        SeriesData seriesData = new SeriesData();
        seriesData.setName("服务器指数");
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        for(EntityChart entity : list){
            numList.add((long) entity.getServer_index());
            dateList.add(entity.getDate());
        }
        seriesData.setData(numList);
        resData.setXAxis(dateList);
        resData.setSeries(seriesData);
        return resData;
    }

    public ResData trans3(List<EntityChart> list){
        ResData resData = new ResData();
        SeriesData seriesData = new SeriesData();
        seriesData.setName("浏览量指数");
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        for(EntityChart entity : list){
            numList.add(entity.getView_index());
            dateList.add(entity.getDate());
        }
        seriesData.setData(numList);
        resData.setXAxis(dateList);
        resData.setSeries(seriesData);
        return resData;
    }

    public List<Object> trans4(List<EntityChart> list){
        ArrayList<Object> outerList = new ArrayList<>();
        ArrayList<Object> tmpList = new ArrayList<>();
        tmpList.add("日期");
        for(EntityChart entityChart : list){
            tmpList.add(entityChart.getDate());
        }
        outerList.add(tmpList);
        for(int i = 1;i<=6;i++){
            ArrayList<Object> innerList = new ArrayList<>();
            innerList.add(
                    switch (i){
                        case 1 -> "生存";
                        case 2 -> "创造";
                        case 3 -> "混合";
                        case 4 -> "战争";
                        case 5 -> "RPG";
                        case 6 -> "小游戏";
                        default -> throw new IllegalStateException("Unexpected value: " + i);
                    }
            );
            for(EntityChart entity : list){
                switch (i) {
                    case 1 -> innerList.add(entity.getCnt_sc());
                    case 2 -> innerList.add(entity.getCnt_cz());
                    case 3 -> innerList.add(entity.getCnt_hh());
                    case 4 -> innerList.add(entity.getCnt_zz());
                    case 5 -> innerList.add(entity.getCnt_rpg());
                    case 6 -> innerList.add(entity.getCnt_xyx());
                }
            }
            outerList.add(innerList);
        }
        return outerList;
    }


}
