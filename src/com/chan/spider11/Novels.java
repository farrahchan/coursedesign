package com.chan.spider11;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Novels {
	
	public static void main(String[] args) {
		
		String url = "https://www.qidian.com/rank/recom?dateType=3&page=";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements es = doc.select(".book-img-text li"); 
			ArrayList<Novelclass> list = new ArrayList<>();
			
			for(Element e : es) {
				Novelclass n = new Novelclass();
				
				n.name = e.select(".book-mid-info a").first().text();
				n.id = Integer.parseInt(e.select(".book-img-box span").first().text());
				n.intro = e.select(".intro").first().text();
				n.poster = e.select("img").first().attr("src");
				System.out.println(n);
				list.add(n);		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
