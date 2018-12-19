package com.chan.spider11;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class APP2 {
	
	public static void main(String[] args) {
		String url = "https://movie.douban.com/subject/1292052/";
		
		try {
			Document d = Jsoup.connect(url).get();
			
			Element e = d.getElementById("content");
			
			String name = e.selectFirst("h1 span").text();
			String year = e.selectFirst(".year").text();
			
			String director = e.select("#info .attrs").get(0).selectFirst("a").text();
			
			String script = e.select("#info .attrs").get(1).text();
			String actor = e.selectFirst("。actor .attrs").text();
			
			System.out.println(name);
			System.out.println(year);
			System.out.println(director);
			System.out.println(script);
			System.out.println(actor);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
