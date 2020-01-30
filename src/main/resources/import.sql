/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at,foto) VALUES('Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-01','');
INSERT INTO clientes (nombre, apellido, email, create_at,foto) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02','');
INSERT INTO clientes (nombre, apellido, email, create_at,foto) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03','');
INSERT INTO clientes (nombre, apellido, email, create_at,foto) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04','');
INSERT INTO clientes (nombre, apellido, email, create_at,foto) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05','');


insert into productos( nombre,precio,create_at) values ('Panasonic Patalla Lcd',25990,now());
insert into productos( nombre,precio,create_at) values ('Sony camaradigital',50000,now());
insert into productos( nombre,precio,create_at) values ('Mac book Pro st',70000,now());
insert into productos( nombre,precio,create_at) values ('Ps4 ',30000,now());

/*insertando facturas */
insert into facturas(descripcion, observacion, cliente_id, create_at) values ('equipos de ofi',null,1,now());
insert into facturas_item(cantidad, factura_id, producto_id) values(1,1,1);
insert into facturas_item(cantidad, factura_id, producto_id) values(2,1,4);

insert into facturas(descripcion, observacion, cliente_id, create_at) values ('equipos de ofina ',null,1,now());
insert into facturas_item(cantidad, factura_id, producto_id) values(3,2,3);


