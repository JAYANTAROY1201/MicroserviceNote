package com.todo.utility;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;

public class JsoupImpl {
	/**
	 * This method is written to get title  
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getTitle(String url) throws IOException {
		return Jsoup.connect(url).get().title();
	}

	/**
	 * This method is written to get Image URL  
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getImage(String url) throws IOException {
		return Jsoup.connect(url).get().select("img").first().attr("abs:src");
	}

	/**
	 * This method is written to get domain  
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getDomain(String url) throws IOException {
		return new URL(url).getHost();
	}

}
