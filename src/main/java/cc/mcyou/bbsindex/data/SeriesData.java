package cc.mcyou.bbsindex.data;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@ToString
@Data
public class SeriesData {
    String name;
    String type = "line";
    boolean smooth = true;
    String symbol = "none";
    List<Long> data;
}



