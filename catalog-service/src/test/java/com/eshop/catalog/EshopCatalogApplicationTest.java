package com.eshop.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/data.sql"})
class EshopCatalogApplicationTest {


	@Test
	void dispatchRunsheetTest() {

	}

}
