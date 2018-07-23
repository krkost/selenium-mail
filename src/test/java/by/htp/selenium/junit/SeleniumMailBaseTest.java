package by.htp.selenium.junit;


import org.junit.Test;

import by.htp.selenium.run.MailTest;
import junit.framework.Assert;

public class SeleniumMailBaseTest {

	@Test
	public void testClientNaswer() throws InterruptedException {
				
		boolean expected = true;
		boolean actual = MailTest.MailCheck("https://mail.ru/", "tathtp", "Klopik123", "sviatlana.zakharenka@gmail.com");
		Assert.assertEquals(expected, actual);

	}

}
