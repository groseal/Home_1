package com.company.hw3_7;

public class Tests {
    @Test(priority = 3)
    public static void test2() { System.out.println("test 2"); }

    @Test(priority = 3)
    public static void test3(){
        System.out.println("test 3");
    }

//    @BeforeSuite
    @Test(priority = 5)
    public static void test4(){
        System.out.println("test 4");
    }

    @BeforeSuite
    public static void test1(){
        System.out.println("test 1");
    }

    @AfterSuite
    public static void test5(){
        System.out.println("test 5");
    }

}
