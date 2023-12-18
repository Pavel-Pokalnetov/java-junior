package loc.homework;

import loc.homework.model.Course;
import loc.homework.model.CoursesDAO;
import loc.homework.model.DataBaseSQLTools;

import java.util.ArrayList;
import java.util.List;

public class App {
    private final String DELIMITER = "\n===========================================================\n";
    public static void main(String[] args) {
        CoursesDAO dao = new DataBaseSQLTools(); //объект для работы с DB
        //Создаем исходный список для записи в базу
        List<Course> courseList = getCourseListStatic();

        //запись всего списка в базу в одной транзакции
        dao.saveCourseListToDB(courseList);

        //запись одной строки в базу
        dao.saveOneCourseToDB(new Course(10, "Микроэлектроника и ВТ", 9));

        //чтение всей таблицы из базы
        System.out.println("Чтение всей таблицы из базы");
        List<Course> courseListRead = dao.readCoursesFromDB();
        printCourses(courseListRead);

        //чтение одного элемента по id
        int id = 236;
        System.out.println("чтение одного элемента по id=" + id);
        Course course = dao.readCourseFromDBByID(id);
        System.out.println(course);

        //обновление записи по id
        id = 328;
        System.out.println("обновление записи по id=" + id);
        course = new Course("Занимательная кибернетика для самых маленьких", 4);
        System.out.println("до Update: " + dao.readCourseFromDBByID(id));
        dao.updateCoursesByID(course, id);
        System.out.println("после Update: " + dao.readCourseFromDBByID(id));

        //удаление записи по полю duration
        int duration=4;
        System.out.println("Удаление запси по полю duration = "+duration);
        System.out.printf("удалено %s записей\n",dao.deleteCourseFromDBByDuration(duration));
        printCourses(dao.readCoursesFromDB("from Course"));
    }

    /** просто вывод в консоль
     * @param courseListRead список курсов
     */
    private static void printCourses(List<Course> courseListRead) {
        if (courseListRead != null && !courseListRead.isEmpty()) {
            courseListRead.forEach(System.out::println);
        } else {
            System.out.println("Запрос вернул NULL");
        }
    }


    /**
     * Возвращает статичный список Courses
     *
     * @return List of Courses
     */
    private static List<Course> getCourseListStatic() {
        List<Course> courseList = new ArrayList<>(10);
        courseList.add(new Course("Основы программирования", 1));
        courseList.add(new Course("Web-разработка", 6));
        courseList.add(new Course("Базы данных", 2));
        courseList.add(new Course("Мобильная разработка", 12));
        courseList.add(new Course("Data Science", 5));
        courseList.add(new Course("ИТ-инфраструктура", 6));
        courseList.add(new Course("Информационная безопасность", 7));
        courseList.add(new Course("DevOps", 5));
        courseList.add(new Course("Искусственный интеллект", 2));
        courseList.add(new Course("Киберфизические системы", 1));
        return courseList;
    }
}
