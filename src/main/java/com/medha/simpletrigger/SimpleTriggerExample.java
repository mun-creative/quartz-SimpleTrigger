package com.medha.simpletrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.medha.job.HelloWorld;

public class SimpleTriggerExample {

	public static void main(String[] args) {
		
	      
		JobDetail job=JobBuilder.newJob(HelloWorld.class).withIdentity("dummyJobName","group1").build();
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("dummyTriggerName","group1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
		try {
			Scheduler  scheduler=new StdSchedulerFactory().getScheduler();
			System.out.println("Before Starting the job ");
			Date dNow = new Date( );
		      SimpleDateFormat ft = 
		      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		      System.out.println("Current Date: " + ft.format(dNow));

			System.out.println("Job Starting");
			scheduler.start();
			scheduler.scheduleJob(job,trigger);
			
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			Date dComp = new Date( );
		      SimpleDateFormat comp = 
		      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

		      System.out.println("After job: " + comp.format(dComp));
		}
		
	}
}
