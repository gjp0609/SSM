# 用户表
CREATE TABLE t_user (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(20),
  password VARCHAR(30),
  realname VARCHAR(30)
);
INSERT INTO t_user (name, password, realname) VALUE ('李嘉图', '123123', '路明非');
INSERT INTO t_user (name, password, realname) VALUE ('me', '123123', 'gjp');
# DELETE FROM t_user;

# 分类表
CREATE TABLE t_category (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20)
);
INSERT INTO t_category (name) VALUES
  ('默认'),
  ('朋友'),
  ('家人'),
  ('工作');

# 联系人表
CREATE TABLE t_person (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(15),
  mobile      VARCHAR(11),
  telphone    VARCHAR(13),
  email       VARCHAR(30),
  city        VARCHAR(20),
  birthday    DATE,
  category_id INT REFERENCES t_category (id)
);
INSERT INTO t_person (name, mobile, telphone, email, city, birthday, category_id) VALUES
  ('小魔女', '18569703757', '010-4856876', 'nono123@126.com', '北京', sysdate(), 1),
  ('楚子航', '17345653476', '0371-65732233', 'chuzh@163.com', '南京', sysdate(), 1),
  ('小怪兽', '17424546745', '0343-23446434', 'huily@163.com', '东京', sysdate(), 2),
  ('芬格尔', '13453423426', '0435-23543452', 'fenge@163.com', '西京', sysdate(), 3);

SELECT *
FROM t_user;

SELECT *
FROM t_category;

SELECT *
FROM t_person;

SELECT last_insert_id()
FROM dual;

SELECT
  P.id        id,
  P.name      name,
  category_id categoryId,
  C.id,
  C.name      categoryName
FROM t_person P LEFT JOIN t_category C ON P.category_id = C.id