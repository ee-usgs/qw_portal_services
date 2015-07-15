package gov.usgs.cida.qw.codes.webservices;

import gov.usgs.cida.qw.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;

@Category(IntegrationTest.class)
@DatabaseSetups({
	@DatabaseSetup("classpath:/testData/clearAll.xml"),
	@DatabaseSetup("classpath:/testData/subjectTaxonomicName.xml")
})
public class SubjectTaxonomicNameRestControllerTest extends BaseCodesRestControllerTest {

	public static String TEST_ENDPOINT = "/codes/subjectTaxonomicName";
	public static String CODE_VALUE = "Fallacia sublucidula";
	public static String CODE_JSON = "{\"value\":\"Fallacia sublucidula\",\"providers\":\"STEWARDS STORET\"}";
	public static String CODE_XML = XML_HEADER +"<Code value=\"Fallacia sublucidula\" providers=\"STEWARDS STORET\"/>";
	public static String SEARCH_TEXT = "b";
	public static String SEARCH_JSON = "{\"codes\":[{\"value\":\"Bugula neritina\",\"providers\":\"NWIS\"}],\"recordCount\":5}";
	public static String SEARCH_XML = XML_HEADER + "<Codes><Code value=\"Bugula neritina\" providers=\"NWIS\"/><recordCount>5</recordCount></Codes>"; 
	public static String COMPARE_FILE_JSON = "subjectTaxonomicName.json";
	public static String COMPARE_FILE_XML = "subjectTaxonomicName.xml";
	
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