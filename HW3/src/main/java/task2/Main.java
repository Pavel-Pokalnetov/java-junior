package task2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Linus Benedict Torvalds",53,4.69);
        System.out.println("-- Исходный объект ----------------------------------");
        System.out.println(student);
        XmlMapper xmlMapper = new XmlMapper();
        String xmlStudent = xmlMapper.writeValueAsString(student);
        System.out.println("-- XML представление --------------------------------");
        System.out.println(xmlStudent);
        //запись в файл
        try(FileWriter fw = new FileWriter("xmlStudent.xml")) {
            fw.write(xmlStudent);
        }catch (IOException e){
            throw new IOException(e);
        }

    }
}
