USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;


CREATE TABLE `users` (

`username` varchar(50) NOT NULL,
`password` char(68) NOT NULL,
`enabled` tinyint NOT NULL,
PRIMARY KEY (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `users

VALUES

('john','{bcrypt}$2a$10$qeS@HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQ19YeuspUdgF.q',1),
('mary', '{bcrypt}$2a$10$qeS@HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQ19YeuspUdgF.q',1),
 ('susan', '{bcrypt}$2a$10$qeS@HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQ19YeuspUdgF.q',1);

 CREATE TABLE `authorities` (

 `username` varchar(50) NOT NULL,

 `authority` varchar(50) NOT NULL,

 UNIQUE KEY `authorities_idx_1` (`username`, `authority`),

 CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)

 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 I

 INSERT INTO `authorities` VALUES

 ('john', 'ROLE_EMPLOYEE'),

 ('mary', 'ROLE_EMPLOYEE'),

 ('mary', 'ROLE_MANAGER'),

 ('susan', 'ROLE_EMPLOYEE'),

 ('susan', 'ROLE_MANAGER'),

 ('susan', 'ROLE_ADMIN');