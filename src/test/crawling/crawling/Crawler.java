package crawling;

import java.io.IOException;

import com.crawljax.core.configuration.CrawljaxConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration.CrawljaxConfigurationBuilder;

import utils.UtilsCrawler;





public class Crawler {
	
	public static void crawl() throws Exception {

		CrawljaxConfigurationBuilder b = Crawler.initCrawljax();
		Crawler.runCrawljax(b);

	}
	
	private static CrawljaxConfigurationBuilder initCrawljax() throws Exception {
		
		CrawljaxConfigurationBuilder builder = CrawljaxConfiguration.builderFor("http://automationpractice.com/index.php");
		
		try {
			UtilsCrawler.myCrawlRules(builder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	private static void runCrawljax(CrawljaxConfigurationBuilder builder) {
		
	}
	
	


}
