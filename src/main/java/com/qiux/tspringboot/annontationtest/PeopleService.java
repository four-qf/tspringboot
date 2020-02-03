package com.qiux.tspringboot.annontationtest;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
public class PeopleService {

//    @Autowired
//    private People people;

    public Integer getAge() {
        People people = new People("小小", 3, null);
        return people.getAge();
    }

}
