package com.adu;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupTest extends BaseTest {
	private File file = new File(this.getClass().getResource("/").getPath(), "jsoup.html");

	@Test
	public void connect() throws IOException {
		Document res = Jsoup.connect("http://www.open-open.com/jsoup/").get();
		logger.debug("res={}", res);
	}

	@Test
	public void parse() throws Exception {
		String html = Files.toString(file, Charsets.UTF_8);
		Document res = Jsoup.parse(html);
		logger.debug("res={}", res);
	}

	@Test
	public void parse1() throws Exception {
		URL url = new URL("http://www.open-open.com/jsoup/");
		Document res = Jsoup.parse(url, 3000);
		logger.debug("res={}", res);
	}

	@Test
	public void parseBodyFragment() throws Exception {
		String html = Files.toString(file, Charsets.UTF_8);
		Document res = Jsoup.parseBodyFragment(html);
		logger.debug("res={}", res);
	}

}
