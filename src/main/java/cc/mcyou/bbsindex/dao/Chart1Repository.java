package cc.mcyou.bbsindex.dao;

import cc.mcyou.bbsindex.data.EntityChart1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Chart1Repository extends JpaRepository<EntityChart1, Integer> {

}
