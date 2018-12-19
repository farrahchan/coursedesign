package com.chan.spider11;
/**
 * 
 * @author Chan
 *
 */

public class Film implements Comparable<Film> {
	
	/**
	 * 影片标题
	 */
	String title;
	
	/**
	 *导演
	 */
	String info;
	
	/**
	 * 影片评分
	 */
	double rating;
	
	/**
	 * 评分人数
	 */
	int num;
	
	/**
	 * 影片排名
	 */
	int id;
	
	/**
	 * 海报
	 */
	String poster;
	
	/**
	 * 影片介绍
	 */
	String quote;
	
	/**
	 *影片详细信息路径 
	 */
	String url;
	
	/**
	 * 导出为CSV文件
	 * @return
	 */
	public String toCSV() {
		return String.format("%d,%s,%d,%.1f\n", 
				id,
				title,
				num,
				rating
				);
	}



	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + ", url=" + url + "]";
	}



	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return id - o.id;
	}
	
	

}
