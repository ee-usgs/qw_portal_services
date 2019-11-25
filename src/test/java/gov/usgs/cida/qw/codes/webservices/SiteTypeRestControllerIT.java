package gov.usgs.cida.qw.codes.webservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DatabaseSetup("classpath:/testData/siteType.xml")
public class SiteTypeRestControllerIT extends BaseCodesRestControllerTest {

	public static String TEST_ENDPOINT = "/sitetype";
	public static String CODE_VALUE = "Lake, Reservoir, Impoundment";
	public static String CODE_JSON = "{\"value\":\"Lake, Reservoir, Impoundment\",\"providers\":\"STEWARDS\"}";
	public static String CODE_XML = XML_HEADER +"<Code value=\"Lake, Reservoir, Impoundment\" providers=\"STEWARDS\"/>";
	public static String SEARCH_TEXT = "re";
	public static String SEARCH_JSON = "{\"codes\":[{\"value\":\"Atmosphere\",\"providers\":\"NWIS STEWARDS\"}],\"recordCount\":5}";
	public static String SEARCH_XML = XML_HEADER + "<Codes><Code value=\"Atmosphere\" providers=\"NWIS STEWARDS\"/><recordCount>5</recordCount></Codes>"; 
	public static String COMPARE_FILE_JSON = "siteType.json";
	public static String COMPARE_FILE_XML = "siteType.xml";

	@Test
	public void getListAsJsonTest() throws Exception {
		runGetListAsJsonTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_JSON, SEARCH_JSON);
	}

	@Test
	public void getListAsXmlTest() throws Exception {
		runGetListAsXmlTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_XML, SEARCH_XML);
	}

	@Test
	public void getCodeAsJsonTest() throws Exception {
		runGetCodeAsJson(TEST_ENDPOINT, CODE_VALUE, CODE_JSON);
	}

	@Test
	public void getCodeAsXmlTest() throws Exception {
		runGetCodeAsXml(TEST_ENDPOINT, CODE_VALUE, CODE_XML);
	}

}
