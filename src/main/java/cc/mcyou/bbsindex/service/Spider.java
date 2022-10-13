package cc.mcyou.bbsindex.service;

import cc.mcyou.bbsindex.dao.ChartRepository;
import cc.mcyou.bbsindex.data.EntityChart;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Data
@NoArgsConstructor
public class Spider {
    //private ArrayList<String> dateList = new ArrayList<>();
    //private ArrayList<Integer> serverNumberList = new ArrayList<>();

    @Autowired
    ChartRepository chartRepository;
    @Autowired
    Entity2ResData entity2ResData;

    private long totView = 0;
    private long tot = 0;
    private long cnt_sc= 0,cnt_cz = 0,cnt_hh = 0,cnt_zz = 0, cnt_rpg = 0,cnt_xyx = 0,cnt_gy = 0;
    final private String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.70";

    public void start() throws IOException {
        // 启动爬虫

        tot = 0; totView = 0;cnt_sc= 0;cnt_cz = 0;cnt_hh = 0;cnt_zz = 0;cnt_rpg = 0;cnt_xyx = 0;cnt_gy = 0;
        Document document = Jsoup.connect("https://www.mcbbs.net/forum-server-1.html").userAgent(userAgent).get();
        int page_amount;
        String string =   (document.getElementsByClass("last").text()).substring(4,6);
        page_amount = Integer.parseInt(string);

        for(int i = 1;i<=page_amount;i++) getData(i);

        EntityChart entityChart = new EntityChart();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        entityChart.setDate(simpleDateFormat.format(date));
        entityChart.setNum((int) tot);

        entityChart.setServer_index((int)(tot - chartRepository.findFirstById().getNum()));
        chartRepository.save(entityChart);

    }

    void getData(int page) throws IOException {
        // 获取服务器列表某页的全部信息

        System.out.println("正在获取第"+page+"页");
        String url = "https://www.mcbbs.net/forum-server-"+page+".html";
        Document document = Jsoup.connect(url).userAgent(userAgent).get();

        //遍历服务器名字
        Elements elements = document.getElementsByClass("s xst");
        boolean lock = true;
        for(Element element : elements){
            if(lock){
                if(element.text().contains("——")) lock = false;
                if (!(page!=1 && !lock))
                    continue;
            }
            tot++; // 统计服务器总数
        }

        //遍历流量
        elements = document.getElementsByClass("num");
        lock = true;
        for(Element element : elements){
            if(lock){
                if(element.toString().contains("<td class=\"num\"></td>")) lock = false;
                continue;
            }
            String text = element.text();
            int cnt = Integer.parseInt(text);
            totView+=cnt;
        }

        //遍历公益服
        elements = document.select("img[src=\"static/image/stamp/010.small.gif\"]");
        for(Element element : elements){
            cnt_gy++;
        }

        //在第一页获取各类服务器的数字
        if(page!=1) return;
        elements = document.getElementsByClass("ttp bm cl");
        for(Element element : elements){
            String content = element.text();
            content = content.replace("全部 公告",""); content = content.replace("生存","");
            content = content.replace("创造",""); content = content.replace("混合","");
            content = content.replace("战争",""); content = content.replace("RPG","");
            content = content.replace("小游戏",""); content = content.replace("| 服务器","");
            String[] out = content.split(" ");
            cnt_sc = Integer.parseInt(out[1]);
            cnt_cz = Integer.parseInt(out[2]);
            cnt_hh = Integer.parseInt(out[3]);
            cnt_zz = Integer.parseInt(out[4]);
            cnt_rpg = Integer.parseInt(out[5]);
            cnt_xyx = Integer.parseInt(out[6]);
        }

    }

/*
    public static void main(String[] args) throws IOException {
        init();
        //getData(2);
        System.out.println("服务器总数："+tot);
        System.out.println("浏览量总数："+totView);
        System.out.println("公益服总数："+cnt_gy);
        System.out.printf("生存：%d 创造：%d 混合：%d 战争：%d RPG：%d 小游戏：%d",cnt_sc,cnt_cz,cnt_hh,cnt_zz,cnt_rpg,cnt_xyx);
    }
*/
}
