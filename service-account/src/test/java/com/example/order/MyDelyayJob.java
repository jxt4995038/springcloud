package com.example.order;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-03 10:03
 */
public class MyDelyayJob implements Delayed {


    private LocalDateTime createTime;

    private static int expireTime  = 10000;

    private String name;

    @Override
    public long getDelay(TimeUnit unit) {
        return createTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()+expireTime-LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    @Override
    public int compareTo(Delayed o) {

        return this.createTime .compareTo(((MyDelyayJob) o).getCreateTime());
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        DelayQueue<MyDelyayJob> queue = new DelayQueue<>();
        LocalDateTime now = LocalDateTime.now();
        MyDelyayJob myDelyayJob1 = new MyDelyayJob();
        myDelyayJob1.setName("1");
        myDelyayJob1.setCreateTime(now.plus(20, ChronoUnit.SECONDS));
        queue.put(myDelyayJob1);

        MyDelyayJob myDelyayJob2 = new MyDelyayJob();
        myDelyayJob2.setName("2");
        myDelyayJob2.setCreateTime(now.plus(25, ChronoUnit.SECONDS));
        queue.put(myDelyayJob2);

        MyDelyayJob myDelyayJob3 = new MyDelyayJob();
        myDelyayJob3.setName("3");
        myDelyayJob3.setCreateTime(now.plus(30, ChronoUnit.SECONDS));
        queue.put(myDelyayJob3);

        MyDelyayJob myDelyayJob4 = new MyDelyayJob();
        myDelyayJob4.setName("4");
        myDelyayJob4.setCreateTime(now.plus(35, ChronoUnit.SECONDS));
        queue.put(myDelyayJob4);

        MyDelyayJob myDelyayJob5 = new MyDelyayJob();
        myDelyayJob5.setName("5");
        myDelyayJob5.setCreateTime(now.plus(15, ChronoUnit.SECONDS));
        queue.put(myDelyayJob5);

        while (true){
            MyDelyayJob job = null;
            try {
                job = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(job.getName() + "现在时间是："+LocalDateTime.now()+"创建时间：" + job.getCreateTime());
        }


    }
}