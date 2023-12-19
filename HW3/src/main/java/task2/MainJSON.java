package task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static task2.Tools.readFromFile;
import static task2.Tools.saveToFile;

public class MainJSON {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Linus Benedict Torvalds", 53, 4.69);
        System.out.println("-- Исходный объект ----------------------------------");
        System.out.println(student);

        //формируем JSON представление объекта
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);
        System.out.println("-- JSON представление объекта -----------------------");
        System.out.println(json);

        //записываем в "jsonStudent.json" файл
        saveToFile(json,"jsonStudent.json");

        //считываем представление объекта в JSON из файла "jsonStudent.json"
        json = readFromFile("jsonStudent.json");
        System.out.println("-- считанное JSON представление объекта -----------------------");
        System.out.println(json);

        //восстанавливаем обхъект из JSON
        Student student1 = objectMapper.readValue(json,Student.class);
        System.out.println("-- Восстановленный объект ----------------------------------");
        System.out.println(student1);
    }
}
