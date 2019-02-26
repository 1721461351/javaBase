package com.yiyufei.reflect;

import java.lang.reflect.Method;

/**
 * 作者：王宇
 * 创建时间：2019/2/26 0026 15:29
 * 描述：
 */
public class SortReflection {
    /***
     * 测试排序算法的用时，利用了java的反射原理
     * @param className
     * @param arr
     */
    public static void testSort(String className,Comparable[] arr){
        try {
            // 利用了java的反射原理
            Class aClass = Class.forName(className);
            Method sort = aClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] o = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            //第一个参数是构造器
            sort.invoke(null, o);
            long endTime = System.currentTimeMillis();
//            assert isSort(arr);
            System.out.println(className+"用时"+(endTime-startTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
