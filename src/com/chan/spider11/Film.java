package com.chan.spider11;
/**
 * 
 * @author Chan
 *
 */

public class Film {
	
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

	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}
	
	

}
