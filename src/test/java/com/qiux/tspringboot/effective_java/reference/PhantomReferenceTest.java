package com.qiux.tspringboot.effective_java.reference;

import com.qiux.tspringboot.entity.Student;
import org.springframework.util.CollectionUtils;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiux
 * @Date 2022/5/30
 * @since
 */


public class PhantomReferenceTest {

    private List<Student> list = new ArrayList<>();

    private ReferenceQueue<Student> referenceQueue = new ReferenceQueue<>();

    private PhantomReference<Student> phantomReference = new PhantomReference<>(createStudent(), referenceQueue);

    public void add() {
        list.add(createStudent());
    }

    public void remove(int size){
        if (size <= list.size()&& CollectionUtils.isEmpty(list)) {
            Student student = list.get(size);
            if (student != null) {
                student = null;
                list.remove(size);
            }
        }

    }

    private Student createStudent() {
        Student student = new Student();
        list.add(student);
        return student;
    }

    //启动一个线程监控回收队列
    public void referenceQueueMonitor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Reference<Student> reference;
                while (true) {
                    try {
                        reference = (Reference<Student>) referenceQueue.remove();
                        reference.get();
                        if (reference != null) {
                            System.out.println("collect:" + reference);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }

    public void validStudent() {
        System.out.println(phantomReference.get());
    }

    public static void main(String[] args) {

//        ReferenceQueue<Student> referenceQueue = new ReferenceQueue();
//        PhantomReference<Student> phantomReference = new PhantomReference<>(new Student(),referenceQueue);
//        System.out.println(phantomReference.get());
//        System.gc();
        int i =0;
        while ( i++ <10) {
            PhantomReferenceTest phantomReferenceTest = new PhantomReferenceTest();
            phantomReferenceTest.referenceQueueMonitor();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phantomReferenceTest.validStudent();
            phantomReferenceTest.add();
            if (i%2 ==0) {
                System.out.println(i);
                phantomReferenceTest.remove(i/2);
            }
            System.gc();
            phantomReferenceTest.validStudent();
            System.out.println("--------------------------------------------------");
        }

    }

}
