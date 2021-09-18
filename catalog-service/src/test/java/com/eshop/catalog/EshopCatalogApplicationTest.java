package com.eshop.ordering;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/data.sql"})
class EshopOrderingApplicationTest {


	@Test
	void dispatchRunsheetTest() {

	}

}
