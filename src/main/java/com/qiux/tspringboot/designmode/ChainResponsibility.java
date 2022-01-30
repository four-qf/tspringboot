package com.qiux.tspringboot.designmode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qx
 * @Date 2022/1/30
 * @since 责任链模式是一种对象的行为模式。
 *       在责任链模式里，很多对象由每一个对象对其下家的引用而连接起来形成一条链；
 *       请求在这个链上传递，直到链上的某一个对象决定处理此请求；
 *       发出这个请求的客户端并不知道链上的哪个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态的重新组织和分配责任
 *
 */
interface Responsibility {
    public void doChain(ResponsibilityHandler chain);
}

class ResponsibilityA implements Responsibility {

    @Override
    public void doChain(ResponsibilityHandler chain) {
        System.out.println("ResponsibilityA");
        chain.handler();
    }
}

class ResponsibilityB implements Responsibility {

    @Override
    public void doChain(ResponsibilityHandler chain) {
        System.out.println("ResponsibilityB");
        chain.handler();
    }
}

class ResponsibilityC implements Responsibility {

    @Override
    public void doChain(ResponsibilityHandler chain) {
        System.out.println("ResponsibilityC");
        chain.handler();
    }
}

class ResponsibilityHandler {

    private List<Responsibility>  responsibilities = new ArrayList<>();

    private int count =0;

    public void handler() {
        if (!CollectionUtils.isEmpty(responsibilities) && count < responsibilities.size()) {
            Responsibility responsibility = responsibilities.get(count++);
            responsibility.doChain(this);
        }
    }

    public void addResponsibility(Responsibility responsibility) {
        responsibilities.add(responsibility);
    }


}

public class ChainResponsibility {

    public static void main(String[] args) {
        ResponsibilityHandler responsibilityHandler = new ResponsibilityHandler();
        responsibilityHandler.addResponsibility(new ResponsibilityA());
        responsibilityHandler.addResponsibility(new ResponsibilityB());
        responsibilityHandler.addResponsibility(new ResponsibilityC());
        responsibilityHandler.handler();
    }

}
