package gov.usgs.cida.qw.codes.webservices;

import gov.usgs.cida.qw.LastUpdateDao;
import gov.usgs.cida.qw.codes.Code;
import gov.usgs.cida.qw.codes.CodeList;
import gov.usgs.cida.qw.codes.CodeType;
import gov.usgs.cida.qw.codes.dao.CodeDao;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(value={"codes/characteristicnames", "codes/characteristicname"}, produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class CharacteristicNameRestController extends CodesRestController {

    private static final Logger LOG = LoggerFactory.getLogger(CharacteristicNameRestController.class);

    @Autowired
	public CharacteristicNameRestController(@Qualifier("lastUpdateDao") final LastUpdateDao lastUpdateDao,
			@Qualifier("codeDao") final CodeDao codeDao) {
    	this.lastUpdateDao = lastUpdateDao;
    	this.codeDao = codeDao;
    }

    @RequestMapping(params="!value", method=RequestMethod.GET)
    public CodeList getCharacteristicNames(final @RequestParam(value="text", required=false) String text,
    		final @RequestParam(value="pagenumber", required=false) String pageNumber,
    		final @RequestParam(value="pagesize", required=false) String pageSize,
    		WebRequest webRequest) {
        LOG.debug("characteristicNames");
        return getList(CodeType.CHARACTERISTICNAME, text, pageNumber, pageSize, null, webRequest);
    }

    @RequestMapping(params="value", method=RequestMethod.GET)
    public Code getCharacteristicName(final @RequestParam(value="value") String value,
    		WebRequest webRequest, HttpServletResponse response) {
        LOG.debug("characteristicName");
        return getCode(CodeType.CHARACTERISTICNAME, value, webRequest, response);
    }

}