package com.chan.spider11;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
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
		
		for(int i = 0; i <= 9; i++) {
			String path = String.format("%s%d", url, i*25); 
			pool.submit(new Spider(path, list));
		}
		
		/**
		 * 程序运行结束 红色图标变灰
		 */
		pool.shutdown();

		while(!pool.isTerminated()) {
			//延时
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//数据排序
		
		Collections.sort(list);
		System.out.println(list.size());
		
		
		ExecutorService pool2 = Executors.newFixedThreadPool(4);
		
		for(Film film : list) {
			
			System.out.println(film.url);
			pool2.execute(new SpiderFilmDetail(film.url,null));
			
		}
		pool2.shutdown();
		
		//写入文件
//		String file = "d:/film.csv"; //绝对路径
//		file = "film.csv";//相对路径
//		
//		//排序
//		Collections.sort(list,null);
//		System.out.println("list.size()");
//		for(Film film:list) {
//			System.out.println(film.url);
//		}
//		
//		//io
//		try (FileWriter out = new FileWriter(file)) {
//			//写数据
//			for (Film film : list) {
//				out.write(film.toCSV());
//			}
//			System.out.println("ok");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}
}
