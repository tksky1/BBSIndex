package cc.mcyou.bbsindex.dao;

import cc.mcyou.bbsindex.data.EntityChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ChartRepository extends JpaRepository<EntityChart, Integer> {

    @Query("select e FROM server_count e where e.id = (select max(id) from server_count)")
    EntityChart findFirstById();
}
