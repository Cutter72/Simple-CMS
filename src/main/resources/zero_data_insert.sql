USE spring_cms;
INSERT INTO `spring_cms`.`Category` (`id`, `description`, `name`)
VALUES
('1', 'polityka description', 'polityka'),
('2', 'zdrowie description', 'zdrowie'),
('3', 'nauka description', 'nauka'),
('4', 'świat description', 'świat'),
('5', 'natura description', 'natura');
INSERT INTO `spring_cms`.`Author` (`id`, `firstName`, `lastName`)
VALUES
('1', 'Paweł', 'Drelich'),
('2', 'Zygmunt', 'Hajzer'),
('3', 'Krzysztof', 'Ibisz'),
('4', 'Jim', 'Carrey'),
('5', 'Jan', 'Kowalski');
INSERT INTO `spring_cms`.`Article` (`id`, `content`, `created`, `title`, `updated`, `author_id`)
VALUES
('1', 'Artukół1', '2019-02-05 13:13:13', 'Title1', '2019-02-05 13:13:13', '1'),
('2', 'Artukół2', '2019-02-05 13:13:13', 'Title2', '2019-02-05 13:13:13', '1'),
('3', 'Artukół3', '2019-02-05 13:13:13', 'Title3', '2019-02-05 13:13:13', '2'),
('4', 'Artukół4', '2019-02-05 13:13:13', 'Title4', '2019-02-05 13:13:13', '2'),
('5', 'Artukół5', '2019-02-05 13:13:13', 'Title5', '2019-02-05 13:13:13', '3'),
('6', 'Artukół6', '2019-02-05 13:13:13', 'Title6', '2019-02-05 13:13:13', '3'),
('7', 'Artukół7', '2019-02-05 13:13:13', 'Title7', '2019-02-05 13:13:13', '4'),
('8', 'Artukół8', '2019-02-05 13:13:13', 'Title8', '2019-02-05 13:13:13', '4'),
('9', 'Artukół9', '2019-02-05 13:13:13', 'Title9', '2019-02-05 13:13:13', '5'),
('10', 'Artukół10', '2019-02-05 13:13:13', 'Title10', '2019-02-05 13:13:13', '5');
INSERT INTO `spring_cms`.`Article_Category` (`Article_id`, `categoryList_id`)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '2'),
('2', '3'),
('2', '4'),
('3', '3'),
('3', '4'),
('3', '5'),
('4', '4'),
('4', '5'),
('4', '1'),
('5', '5'),
('5', '1'),
('5', '2');
