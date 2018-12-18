package com.chan.spider11;
/**
 * 
 * @author Chan
 *
 */

public class Novelclass {
	/**
	 * 排行
	 */
	int id;

	/*
	 * 小说名
	 */
	String name;
	
	/*
	 * 小说介绍
	 */
	String intro;
	
	/**
	 *海报
	 */
	String poster;

	@Override
	public String toString() {
		return "Novelclass [id]=" + id + ",[name]=" + name + ", [intro]=" + intro + "[poster]=" + poster;
	}
}
