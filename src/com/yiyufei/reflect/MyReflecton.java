package com.yiyufei.reflect;

import com.yiyufei.domain.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者：王宇
 * 创建时间：2019/2/26 0026 15:25
 * 描述：java的反射
 */
public class MyReflecton {
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
