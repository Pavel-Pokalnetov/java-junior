package loc.homework2;

import java.beans.ConstructorProperties;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {


        Animal[] animals = {
                new Dog("Шарик", 3),
                new Cat("Барсик", 3),
                new Dog("Рекс", 6),
                new Cat("Мурка", 3),
                new Cat("Снежок", 6)
        };

        for (Animal a : animals) {
            Class<?> classA = a.getClass();
            Class<?> seperclassA = classA.getSuperclass();
            System.out.println(classA.getName());
            List<Field> fields = Arrays.asList(classA.getDeclaredFields());
            fields.addAll(Arrays.asList(seperclassA.getDeclaredFields()));
            fields.forEach(field -> System.out.println(field.getName()));



            Method[] methods = a.getClass().getMethods();

            System.out.println();

        }

    }
}