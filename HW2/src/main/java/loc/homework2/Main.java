package loc.homework2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Animal[] animals = {
                new Dog("Шарик", 3),
                new Cat("Барсик", 3),
                new Dog("Рекс", 6),
                new Cat("Мурка", 3),
                new Cat("Снежок", 6)
        };

        Set<Class<?>> classSet = new HashSet<>();
        for (Animal a : animals) {
            classSet.add(a.getClass());
        }
        for (Class<?> clazz : classSet) {
            System.out.println("Класс: " + clazz.getName());
            System.out.println("Поля класса");
            Arrays.stream(clazz.getDeclaredFields())
                    .forEach(field -> System.out.println("\t" + field.getName()));
            Arrays.stream(clazz.getSuperclass().getDeclaredFields())
                    .forEach(field -> System.out.println("\t" + field.getName()));
            System.out.println("Методы класса");
            Arrays.stream(clazz.getDeclaredMethods())
                    .forEach(field -> System.out.println("\t" + field.getName()));
            Arrays.stream(clazz.getSuperclass().getDeclaredMethods())
                    .forEach(field -> System.out.println("\t" + field.getName()));
            System.out.println("-----------------------------------------------");

        }
        for (Animal a : animals) {
            System.out.println(a);
            try {
                Method makeSoundMethod = a.getClass().getMethod("makeSound");
                makeSoundMethod.invoke(a);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException ignored) {}
        }

    }
}