Шпаргалка по докер для домашки
Запуск MySQL в докер: 
```shell
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest
```
Повторный запуск контейнера:
```shell
docker start mysql
```

Скрипт для создания таблицы:
```mysql
DROP TABLE IF EXISTS `Courses`;
CREATE TABLE `Courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` text COMMENT 'название',
  `duration` int COMMENT 'продолжительность',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;
```

Скрипт для добавления данных
```mysql
INSERT INTO `Courses` (`title`, `duration`)
VALUES
('Основы программирования', 1),
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