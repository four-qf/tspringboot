package com.qiux.tspringboot.cache;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qiux.tspringboot.entity.Student;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author qiuxian
 * @date 2020/5/15
 */
@Component
public class StudentServiceCache implements InitializingBean {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ValueOperations<String, String> opsForValue;

    @Override
    public void afterPropertiesSet() throws Exception {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        opsForValue = redisTemplate.opsForValue();
    }



    private static final String STUDENT_KEY = "STUDENT_";

    public String getStudentKey(Integer id) {
        return STUDENT_KEY + id;
    }

    public Student getStudent(Integer id) {

        String studentStr = opsForValue.get(getStudentKey(id));
        if (StringUtils.isEmpty(studentStr)) {
            return null;
        }
        Student stduent = JSON.parseObject(studentStr, Student.class);
        return stduent;
    }

    public Integer setStudent(Student student) {
        if (student == null || student.getId() == null) {
            return null;
        }
        String key = getStudentKey(student.getId());
        String studentStr = JSON.toJSONString(student, SerializerFeature.WriteClassName);
        opsForValue.set(key, studentStr);
        return 1;
    }


}
