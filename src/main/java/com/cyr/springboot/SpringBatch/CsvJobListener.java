package com.cyr.springboot.SpringBatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CsvJobListener implements JobExecutionListener {
    long stratTime;
    long endTIme;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        stratTime=System.currentTimeMillis();
        System.out.println("任务开始处理");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTIme=System.currentTimeMillis();
        System.out.println("任务处理结束:"+"耗时："+(endTIme-stratTime)+"ms");
    }
}
