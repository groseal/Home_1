package com.company.hw3_7;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        start(Tests.class);
    }

    public static void start(Class cl) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Method[] allMethods = cl.getDeclaredMethods();//получаю все методы кдасса

        int numberOfAnnotationBefor = 0;
        int numberOfAnnotationAfter = 0;
        Method befor = null;
        Method after = null;
        List<Method> test = new  ArrayList<>();
//        Map<Method, Integer> test = new HashMap<>();
//        int priority=0;

        for (Method method : allMethods) {
            Annotation[] allMethodAnno = method.getDeclaredAnnotations();//получаю все аннотации указанного метода
            for (Annotation annotation : allMethodAnno) {
                if (annotation instanceof BeforeSuite) {
                    befor = method;//получаю метод с аннотацией BeforeSuite
                    numberOfAnnotationBefor++;
                } else if (annotation instanceof AfterSuite) {
                    after = method;//получаю метод с аннотацией AfterSuite
                    numberOfAnnotationAfter++;
                } else if (annotation instanceof Test) {
                    test.add(method);
//                    Test t = (Test) annotation;
//                    test.put(method, t.priority());
//                    if (priority<t.priority()){priority=t.priority();}
                }
            }
        }
        if (numberOfAnnotationBefor > 1 || numberOfAnnotationAfter > 1) {
            throw new RuntimeException();
        }

        befor.invoke(cl);//запускаю метод с аннотацией BeforeSuite

        //сортировка map с методами с аннотацией Test
        test.sort(Comparator.comparingInt((Method i)->{
            return i.getAnnotation(Test.class).priority();
        }).reversed());

        for (Method method:test){
            method.invoke(cl);
        }


        after.invoke(cl);
    }
}

