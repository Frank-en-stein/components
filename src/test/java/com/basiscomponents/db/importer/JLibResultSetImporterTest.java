package com.basiscomponents.db.importer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.basiscomponents.db.DataRow;
import com.basiscomponents.db.ResultSet;

public class JLibResultSetImporterTest {
	String filename = "src/test/resources/CUSTOMER";
	String template = "CUST_NUM:C(6):LABEL=CUST_NUM:,FIRST_NAME:C(20):LABEL=FIRST_NAME:,LAST_NAME:C(30):LABEL=Last:,COMPANY:C(30):LABEL=Company:,BILL_ADDR1:C(30):LABEL=BILL_ADDR1:,BILL_ADDR2:C(30):LABEL=BILL_ADDR2:,CITY:C(20):LABEL=CITY:,STATE:C(2):LABEL=STATE:,COUNTRY:C(20):LABEL=COUNTRY:,POST_CODE:C(12):LABEL=POST_CODE:,PHONE:C(15):LABEL=PHONE:,FAX:C(15):LABEL=FAX:,SALESPERSON:C(3):LABEL=SALESPERSON:,SHIP_ZONE:C(2):LABEL=SHIP_ZONE:,SHIP_METHOD:C(5):LABEL=SHIP_METHOD:,CURRENT_BAL:N(12):LABEL=CURRENT_BAL:,OVER_30:N(12):LABEL=OVER_30:,OVER_60:N(12):LABEL=OVER_60:,OVER_90:N(12):LABEL=OVER_90:,OVER_120:N(12):LABEL=OVER_120:,SALES_MTD:N(12):LABEL=SALES_MTD:,SALES_YTD:N(12):LABEL=SALES_YTD:,SALES_LY:N(12):LABEL=SALES_LY:,LAST_PURCH_DATE:N(7):LABEL=LAST_PURCH_DATE:,LAST_PAY_DATE:N(7):LABEL=LAST_PAY_DATE:,CREDIT_CODE:C(2):LABEL=CREDIT_CODE:";

	@Test
	public void testFilter() throws Exception {
		String path = getClass().getClassLoader().getResource("CUSTOMER").getPath();
		JLibResultSetImporter jlrsi = new JLibResultSetImporter(path, template);
		DataRow filter = new DataRow();
		filter.setFieldValue("STATE", "NM");
		jlrsi.setFilter(filter);
		ResultSet rs = jlrsi.retrieve();
		// rs.getDataRows().forEach(System.out::println);
		assertEquals(14, rs.size());

	}
}
