create database app;
use app;

CREATE TABLE `personalinfo` (
  `firstname` varchar(60) NOT NULL default '',
  `middlename` varchar(20) NOT NULL default '',
  `lastname` varchar(60) NOT NULL default '',
) ;

insert into personalinfo(`firstname`,`middlename`,`lastname`) values ('Lionel','Messi','Alacantara',);
insert into personalinfo(`firstname`,`middlename`,`lastname`) values ('Ram','Sam','jbkjsdfkjhjk',);