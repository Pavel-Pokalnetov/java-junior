
DROP TABLE IF EXISTS `Courses`;
CREATE TABLE `Courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` text COMMENT 'название',
  `duration` varchar(100) DEFAULT NULL COMMENT 'продолжительность',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO `Courses` (`title`, `duration`)
VALUES
('Основы программирования', '3 месяца'),
('Web-разработка', '6 месяцев'),
('Базы данных', '4 месяца'),
('Мобильная разработка', '5 месяцев'),
('Data Science', '3 месяца'),
('ИТ-инфраструктура', '6 месяцев'),
('Информационная безопасность', '4 месяца'),
('DevOps', '5 месяцев'),
('Искусственный интеллект', '3 месяца'),
('Киберфизические системы', '6 месяцев');
