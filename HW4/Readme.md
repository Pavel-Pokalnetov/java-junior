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

Вавод консоли:
```terminal

===========================================================
Запись одной строки в базу {id=10, title='Микроэлектроника и ВТ', duration='9'}
{id=10, title='Микроэлектроника и ВТ', duration='9'}

===========================================================
Чтение всей таблицы из базы
{id=876, title='Основы программирования', duration='1'}
{id=877, title='Web-разработка', duration='6'}
{id=878, title='Базы данных', duration='2'}
{id=879, title='Мобильная разработка', duration='12'}
{id=880, title='Data Science', duration='5'}
{id=881, title='ИТ-инфраструктура', duration='6'}
{id=882, title='Информационная безопасность', duration='7'}
{id=883, title='DevOps', duration='5'}
{id=884, title='Искусственный интеллект', duration='2'}
{id=885, title='Киберфизические системы', duration='1'}
{id=886, title='Микроэлектроника и ВТ', duration='9'}
{id=888, title='Основы программирования', duration='1'}
{id=889, title='Web-разработка', duration='6'}
{id=890, title='Базы данных', duration='2'}
{id=891, title='Мобильная разработка', duration='12'}
{id=892, title='Data Science', duration='5'}
{id=893, title='ИТ-инфраструктура', duration='6'}
{id=894, title='Информационная безопасность', duration='7'}
{id=895, title='DevOps', duration='5'}
{id=896, title='Искусственный интеллект', duration='2'}
{id=897, title='Киберфизические системы', duration='1'}
{id=898, title='Микроэлектроника и ВТ', duration='9'}
{id=900, title='Основы программирования', duration='1'}
{id=901, title='Web-разработка', duration='6'}
{id=902, title='Базы данных', duration='2'}
{id=903, title='Мобильная разработка', duration='12'}
{id=904, title='Data Science', duration='5'}
{id=905, title='ИТ-инфраструктура', duration='6'}
{id=906, title='Информационная безопасность', duration='7'}
{id=907, title='DevOps', duration='5'}
{id=908, title='Искусственный интеллект', duration='2'}
{id=909, title='Киберфизические системы', duration='1'}
{id=910, title='Микроэлектроника и ВТ', duration='9'}

===========================================================
чтение одного элемента по id=890
{id=890, title='Базы данных', duration='2'}

===========================================================
обновление записи по id=895
до Update: {id=895, title='DevOps', duration='5'}
после Update: {id=895, title='Занимательная кибернетика для самых маленьких', duration='4'}

===========================================================
Удаление запси по полю duration = 4
удалено 1 записей
{id=876, title='Основы программирования', duration='1'}
{id=877, title='Web-разработка', duration='6'}
{id=878, title='Базы данных', duration='2'}
{id=879, title='Мобильная разработка', duration='12'}
{id=880, title='Data Science', duration='5'}
{id=881, title='ИТ-инфраструктура', duration='6'}
{id=882, title='Информационная безопасность', duration='7'}
{id=883, title='DevOps', duration='5'}
{id=884, title='Искусственный интеллект', duration='2'}
{id=885, title='Киберфизические системы', duration='1'}
{id=886, title='Микроэлектроника и ВТ', duration='9'}
{id=888, title='Основы программирования', duration='1'}
{id=889, title='Web-разработка', duration='6'}
{id=890, title='Базы данных', duration='2'}
{id=891, title='Мобильная разработка', duration='12'}
{id=892, title='Data Science', duration='5'}
{id=893, title='ИТ-инфраструктура', duration='6'}
{id=894, title='Информационная безопасность', duration='7'}
{id=896, title='Искусственный интеллект', duration='2'}
{id=897, title='Киберфизические системы', duration='1'}
{id=898, title='Микроэлектроника и ВТ', duration='9'}
{id=900, title='Основы программирования', duration='1'}
{id=901, title='Web-разработка', duration='6'}
{id=902, title='Базы данных', duration='2'}
{id=903, title='Мобильная разработка', duration='12'}
{id=904, title='Data Science', duration='5'}
{id=905, title='ИТ-инфраструктура', duration='6'}
{id=906, title='Информационная безопасность', duration='7'}
{id=907, title='DevOps', duration='5'}
{id=908, title='Искусственный интеллект', duration='2'}
{id=909, title='Киберфизические системы', duration='1'}
{id=910, title='Микроэлектроника и ВТ', duration='9'}

Process finished with exit code 0
```
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