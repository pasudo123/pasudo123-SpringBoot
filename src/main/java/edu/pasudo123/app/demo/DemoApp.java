package edu.pasudo123.app.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {

    public static void main(String[]args){

        /** 방법 1 **/
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(DemoAppConfig.class);
//
//        Car car = context.getBean(Car.class);
//        car.move();


        /**
         * 방법 2
         * - register() 를 통해 Bean 을 등록할 설정 어노테이션(@Configuration) 을 추가한다.
         * - 이후에 refresh() 를 통해 컨텍스트가 해당 등록한 어노테이션 내 @Bean 어노테이션들에 대한 객체를 빈으로 등록한다.
         */
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();

        context.register(DemoAppConfig.class);
        context.refresh();

        Car car = context.getBean(Car.class);
        car.move();
    }
}
