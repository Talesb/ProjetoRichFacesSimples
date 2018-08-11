
password e3c1c4fc1462957
mysql -u b40bf710b6bfaf -p e3c1c4fc1462957 -h us-cdbr-iron-east-01.cleardb.net:3306 heroku_ee25e7a07040288

use heroku_ee25e7a07040288;

drop table SYS_USUARIO;
create table SYS_USUARIO(
	ID int primary key auto_increment,
	NOMLOGINUSUARIO varchar(20) not null,
	EMAIL varchar(50) unique not null,
	senha varchar(255) not null
);



