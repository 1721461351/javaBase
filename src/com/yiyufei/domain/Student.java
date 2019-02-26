package com.yiyufei.domain;

/**
 * 作者：王宇
 * 创建时间：2019/2/26 0026 14:58
 * 描述：
 */
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void myStudent(){
        System.out.println("这是我自己定义的私有方法！"+name);
    }
}
