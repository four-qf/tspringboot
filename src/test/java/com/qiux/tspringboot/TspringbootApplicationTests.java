package com.qiux.tspringboot;

import com.qiux.tspringboot.component.RedisHelp;
import com.qiux.tspringboot.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class TspringbootApplicationTests {

//    @Autowired
//    private StudentService studentService;

    @Autowired
    private RedisHelp redisHelp;

    @Test
    public void testRedisAddString() {
        Student student = new Student();
        student.setAge(19);
        student.setName("bn");
        student.setId(8);

        redisHelp.set("user", student);
    }

    @Test
    public void testRedisGetString() {
        Student user = redisHelp.get("user");
        System.out.println(user);
    }

    @Test
    void contextLoads() throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        generateArtifacts();
    }

    private void generateArtifacts() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {

        List<String> warnings = new ArrayList();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        //加载配置文件
        Configuration config = cp.parseConfiguration(this.getClass().
                getResourceAsStream("/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

//    @Test
//    void save() {
//        Student student = new Student();
//        student.setAge(24);
//        student.setEmail("qiuxian@163.com");
//        student.setName("qx4");
//        student.setPhone("18981752567");
//        System.out.println(studentService.save(student));
//    }
//
//    @Test
//    public void show() {
//        System.out.println(studentService.getById(1));
//    }

}
