package com.yiyufei;

import com.yiyufei.domain.Student;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Set;

/**
 * 作者：王宇
 * 创建时间：2019/2/25 0025 12:34
 * 描述：
 */
public class PropertiesDEmo {

    @Test
    public void tes1() throws IOException {
        Properties properties = new Properties();
        properties.put("1","you");
        properties.put("2","are");
        properties.put("3","the");

        //只能设置字符串类型的key和value
        properties.setProperty("5","haha");
//        properties.put(4,"best");

        Object o = (String)properties.get(1);
//        System.out.println(o);

        //得到的是key的集合
        Set<Object> set = properties.keySet();



        //写入的key必须为字符串类型
//        properties.store(new FileWriter("propertiestest.txt"), "写入测试");

        properties.load(new FileReader("propertiestest.txt"));

        for (Object key:set){
            System.out.println("key = " + key);
            System.out.println("value = " + properties.get(key).toString());
        }


    }

    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.yiyufei.domain.Student");
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        System.out.println(        constructor.getName());
        //利用构造方法传值
        Student student = (Student) constructor.newInstance("王宇", 18);
        System.out.println(student.getName()+student.getAge());

        Field myStudent = aClass.getDeclaredField("name");//获取的是字段
        //能够访问私有的字段
        myStudent.setAccessible(true);
        String o = (String)myStudent.get(student);
        System.out.println(o);
    }

}
