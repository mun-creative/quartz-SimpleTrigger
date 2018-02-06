package com.medha.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorld implements Job {

	public void execute(JobExecutionContext jobExecContext) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		System.out.println("Hello Quartz!!!");
	}
	
	

}
