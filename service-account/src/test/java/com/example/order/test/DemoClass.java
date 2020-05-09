package com.example.order.test;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-03 21:48
 */
public class DemoClass extends ParentClass {



    public DemoClass(){
        super(34);
        System.out.println("In demoClass construct");
    }

    public void printStatement(){
        System.out.println("Just on line");
    }



    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();
    }
}

class ParentClass{
    static {
        System.out.println("parent static block");
    }

    ParentClass(){
        System.out.println("In parent Construct");
    }

    ParentClass(int varible){
        System.out.println("In parent Constuct"+varible);
    }

}