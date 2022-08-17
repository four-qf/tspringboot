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

    public void remove(int size) {
        if (size <= list.size() && !CollectionUtils.isEmpty(list)) {
            Student student = list.get(size);
            if (student != null) {
                student = null;
                list.remove(size);
                System.out.println("remove:" + size);
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
                        if (reference != null) {
                            System.out.println("collect:" + reference);
                            break;
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

        PhantomReferenceTest phantomReferenceTest = new PhantomReferenceTest();
        phantomReferenceTest.referenceQueueMonitor();
        phantomReferenceTest.remove(0);
        System.gc();
        phantomReferenceTest.validStudent();
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("--------------------------------------------------");

    }

}
