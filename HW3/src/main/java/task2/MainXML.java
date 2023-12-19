package task2;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static task2.Tools.readFromFile;
import static task2.Tools.saveToFile;

public class MainXML {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Linus Benedict Torvalds", 53, 4.69);
        System.out.println("-- Исходный объект ----------------------------------");
        System.out.println(student);

        //формируем XML представление объекта
        XmlMapper xmlMapper = new XmlMapper();
        String xmlStudent = xmlMapper.writeValueAsString(student);
        System.out.println("-- XML представление --------------------------------");
        System.out.println(xmlStudent);

        //запись XML в файл "xmlStudent.xml"
        saveToFile(xmlStudent, "xmlStudent.xml");

        //чтение XML из файла "xmlStudent.xml"
        xmlStudent = readFromFile("xmlStudent.xml");
        System.out.println("-- прочитано из файла ----------------------------------");
        System.out.println(xmlStudent);

        // воссстановление объекта из XML представления
        Student studentRead = xmlMapper.readValue(xmlStudent, Student.class);
        System.out.println("-- восстановлено из xml ----------------------------------");
        System.out.println(studentRead);


    }
}
