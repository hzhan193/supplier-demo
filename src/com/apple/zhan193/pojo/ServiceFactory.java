package com.apple.zhan193.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class ServiceFactory {
    private static final Map<Class<?>, Object> repository = new HashMap<>();

    protected ServiceFactory() {};

    protected static <T> T getOrInjectInstance(Class<T> clazz, Supplier<T> instanceSupplier) throws IllegalStateException {
        Object instance = repository.get(clazz);
        if(instance == null) {
            instance = instanceSupplier.get();
            repository.put(clazz, instance);
        }

        if(!clazz.isAssignableFrom(instance.getClass())) {
            String name = instance.getClass().getName();
            throw new IllegalStateException(name + "is not a implementation of" + clazz.getName());
        }else {
            return clazz.cast(instance);
        }
    }

    public static int getSize() {
        return repository.size();
    }
}
