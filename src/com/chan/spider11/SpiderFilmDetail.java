package com.chan.spider11;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class SpiderFilmDetail implements Runnable {
	
	/**
	 * 影片的url
	 * 
	 */
	String url;
	
	/**
	 * 影片列表
	 */
	ArrayList<Film> list;
	
	public  SpiderFilmDetail(String url,ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Document doc = Jsoup.connect(url).get();
			Element e = doc.getElementById("content");
			
			String name = e.selectFirst("h1 span").text();
			String year = e.selectFirst(".year").text();
			
			String director = e.select("#info .attrs").get(0).selectFirst("a").text();
			
			String script = e.select("#info .attrs").get(1).text();
			String actor = e.selectFirst("。actor .attrs").text();
			
			System.out.printf("%s,%s,%s,%s\n",
					name,
					year,
					director,
					script);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		
	}

}
