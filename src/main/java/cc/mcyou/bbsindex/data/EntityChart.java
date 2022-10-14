package cc.mcyou.bbsindex.data;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name="server_count")
@Table(name="server_count")
@NoArgsConstructor
public class EntityChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String date;
    @NonNull
    private int num;
    @NonNull
    private int server_index;
    @NonNull
    private long tot_view;
    @NonNull
    private int cnt_sc;
    @NonNull
    private int cnt_cz;
    @NonNull
    private int cnt_hh;
    @NonNull
    private int cnt_zz;
    @NonNull
    private int cnt_rpg;
    @NonNull
    private int cnt_xyx;
    @NonNull
    private long view_index;
    @NonNull
    private int cnt_gy;
}
