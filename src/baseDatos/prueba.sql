create database Prueba;

use Prueba;

create table Productos(
id int primary key auto_increment,
nombre varchar(20),
categoria varchar(20),
cantidad int,
minima int,
precioU int,
precioM int,
precioProv int);

insert into Productos(nombre,categoria,cantidad,minima,precioU,precioM,precioProv) values('cinta masking','Ferreteria',10,3,10,18,5);
select*from Productos;