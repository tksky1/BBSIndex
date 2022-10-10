package cc.mcyou.bbsindex.data;

import lombok.*;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
public class ResData {
    List<String> xAxis;
    SeriesData series;
}

