package com.qiux.tspringboot.thread;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author qiux
 * @Date 2022/2/23
 * @since
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<Boolean> call1 = executorService.submit(new Work());
//        Future<Boolean> call2 = executorService.submit(new Work());
//        Future<Boolean> call3 = executorService.submit(new Work());
//        Boolean aBoolean = call1.get();
//        aBoolean = call3.get();
//        aBoolean = call2.get();
//        executorService.shutdown();


    }

}

class Work implements Callable<Boolean> {

    static int task = 6;

    @Override
    public Boolean call() throws Exception {
        boolean flag = false;
        if (flag) {
            return flag;
        }
        while (task-- >= 0) {

            System.out.println(Thread.currentThread().getName() + ":" + task);
            synchronized (Work.class) {
                if (task == 0) {
                    System.out.println("end:" + Thread.currentThread().getName() + ":" + task);
                    flag = true;
                    return flag;
                }
            }
            Thread.sleep(1000);

        }


        return flag;
    }

}
