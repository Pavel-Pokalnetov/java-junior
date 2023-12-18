Задача:
Создайте базу данных (например, SchoolDB).
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
Настройте Hibernate для работы с вашей базой данных.
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.

Решение.

Предварительно:

- Создаем базу в СУБД MariaDB в контейнере докер.
- Через DBeaver подключимся к базе, создадим схему SchoolDB и выполним скрип по созданию таблицы.

Файлы решения Java:

- файл конфигурации Maven https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/pom.xml
- Класс описания сущности Course https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/java/loc/homework/model/Course.java
- файл конфигурации
  Hibernate https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/resources/hibernate.cfg.xml
- файл конфигурации мапнга
  Course https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/resources/course.hbm.xml
- Класс для работы с SessionFactory
  Hibernate https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/java/loc/homework/core/HibernateTools.java
- Интерфейс DAO
  Course https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/java/loc/homework/model/CoursesDAO.java
- Реализация DAO для работы с БД через
  Hibernate https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/java/loc/homework/model/DataBaseSQLTools.java
- Основной класс для демонтрации работы написанного
  кода https://github.com/Pavel-Pokalnetov/java-junior/blob/hw4/HW4/src/main/java/loc/homework/App.java

Шпаргалка по докер для домашки
Запуск контейнера MariaDB в Docker:

```shell
docker run --name MariaDBTest -e MARIADB_ROOT_PASSWORD=123456 -p 3306:3306 -d mariadb:latest
```

Повторный запуск контейнера:

```shell
docker start MariaDBTest
```

Скрипт для создания таблицы:

```mysql
DROP TABLE IF EXISTS `Courses`;
CREATE TABLE `Courses`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `title`    text COMMENT 'название',
    `duration` int COMMENT 'продолжительность',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1;
```

Скрипт для добавления данных

```mysql
INSERT INTO `Courses` (`title`, `duration`)
VALUES ('Основы программирования', 1),
       ('Web-разработка', 9),
       ('Базы данных', 4),
       ('Мобильная разработка', 12),
       ('Data Science', 7),
       ('ИТ-инфраструктура', 3),
       ('Информационная безопасность', 3),
       ('DevOps', '5 месяцев'),
       ('Искусственный интеллект', 2),
       ('Киберфизические системы', 4);

```