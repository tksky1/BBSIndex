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
}
