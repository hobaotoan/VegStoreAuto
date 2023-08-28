package cucumber.utils;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.apache.commons.validator.GenericValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.page.AbstractPage;

public class GenericValidate extends AbstractPage implements BaseTest{
    private final Logger logger = LoggerFactory.getLogger(GenericValidate.class);

	private final static String PATTERN_DATE = "yyyy-MM-dd HH:mm";
	
	
	public void isValidDateTime(String dateTime) {
		assertTrue("Invalid date time format " + dateTime, GenericValidator.isDate(dateTime, PATTERN_DATE, true));
	}
	
	public void isValidEmail(String email) {
		assertTrue("Invalid date time format " + email, GenericValidator.isEmail(email));
	}
	
	@SuppressWarnings("unused")
	private boolean isValidListDateTime(String dateTime) {
		String[] patterns = {"yyyy-MM-dd HH:mm", "yyyy-MM-dd HH"};
		String date = "2018-02-02 11:50";
		Arrays.asList(patterns).stream()
		        .anyMatch(pattern -> {
		            try {
		                LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
		                logger.info("Valid format Date time");
		                return true;
		            } catch (Exception e) {
		                logger.info("Invalid format Date time");
		                return false;
		            }
		        });
		return false;
		
	}

}
