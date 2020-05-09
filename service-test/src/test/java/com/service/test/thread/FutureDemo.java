package com.service.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-20 11:02
 */
public class FutureDemo implements Callable<List<Integer>> {

    private Integer pageSize;

    private Integer pageNumber;

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("pageNumber="+pageNumber+",pageSize="+pageSize);
        List<Integer> numbers = new ArrayList<>();
        if (this.pageNumber>5) {
        }else if (this.pageNumber ==5){
            numbers.add(41);
        }else {
            for (int i = 0; i < pageSize; i++) {
                numbers.add(pageNumber*pageSize+i);
            }
        }
        return numbers;
    }


    public static void main(String[] args) {
        List<Integer> resultList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
                FutureDemo futureDemo = new FutureDemo(10,i);
                Future<List<Integer>> submit = executor.submit(futureDemo);
                try {
                    List<Integer> integers = submit.get();
                    resultList.addAll(integers);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

        }

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(i);
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public FutureDemo(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }
}