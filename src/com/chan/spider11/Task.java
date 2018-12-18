package com.chan.spider11;

/*  定义一个可以交给线程完成的任务
 * 
 * @author chan
 * 
 */
public class Task implements Runnable{

	//编号
	int n;
	
	
	public Task(int n) {
		super();
		this.n = n;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "开始 : "+ n);
		//延时
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "完成 : "+ n);
	}
	
	

}
