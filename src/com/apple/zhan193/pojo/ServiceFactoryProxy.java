package com.apple.zhan193.pojo;

public class ServiceFactoryProxy extends ServiceFactory {
    private ServiceFactoryProxy() {
        super();
    }

    public static Student createStudentService() {
        return getOrInjectInstance(Student.class, Student::new);
    }

    public static Car createCarService() {
        return getOrInjectInstance(Car.class, Car::new);
    }
}
