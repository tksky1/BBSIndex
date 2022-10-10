package cc.mcyou.bbsindex;

import cc.mcyou.bbsindex.dao.Chart1Repository;
import cc.mcyou.bbsindex.service.Spider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class BbsIndexApplicationTests {

	@Autowired
	Chart1Repository chart1Repository;

	@Autowired
	Spider spider;

	@Test
	public void test() throws IOException {
		//chart1Repository.save(new EntityChart1("2022-10-8",233));
		spider.start();
	}

}