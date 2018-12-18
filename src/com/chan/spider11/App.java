package com.chan.spider11;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class App {
	
	 // alt +/
	public static void main(String[] args) {
		
		//线程池
		//固定大小
		ExecutorService pool = Executors.newFixedThreadPool(8);
		
		//无限（缓存）
		pool = Executors.newCachedThreadPool();
		//一个线程
		//pool = Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list = new ArrayList<>();
		String url = "https://movie.douban.com/top250?start=";
		
		for(int i = 0; i <= 10; i++) {
			String path = String.format("%s%d", url, i*25); 
			pool.submit(new Spider(path, list));
		}
	}

}
