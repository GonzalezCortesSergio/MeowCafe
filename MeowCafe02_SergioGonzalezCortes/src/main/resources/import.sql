insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (1, 'Freyja', '19:48', false, '/img/WhatsApp Image 2024-05-02 at 19.16.19.jpeg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (2, 'Elva', '7:11', false, 'https://t2.ea.ltmcdn.com/es/posts/7/4/3/como_ayudar_a_un_gatito_a_defecar_20347_orig.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (3, 'Ebba', '19:45', false, 'https://t2.ea.ltmcdn.com/es/posts/7/4/3/como_ayudar_a_un_gatito_a_defecar_20347_orig.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (4, 'Lucien', '0:45', false, 'https://www.tiendanimal.es/articulos/wp-content/uploads/2010/06/la-forma-de-ser-de-tu-gatito-cachorro-1200x900.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (5, 'Beth', '2:42', false, 'https://clinicaveterinariaalbeitar.es/wp-content/uploads/2019/01/gatito1.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (6, 'Vick', '7:44', false, 'https://www.zooplus.es/magazine/wp-content/uploads/2018/04/fotolia_169457098.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (7, 'Timothee', '10:12', false, 'https://cdn.unotv.com/images/2023/11/gato-173700-1024x576.jpeg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (8, 'Clotilda', '6:32', false, 'https://comunidad.retorn.com/wp-content/uploads/2023/03/gatito.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (9, 'Kerwin', '4:36', false, 'https://www.veteralia.com/wp-content/uploads/2017/03/Intro.jpg');
insert into gato (id, nombre, horas_disponibles, vacunado, imagen) values (10, 'Caryl', '6:10', false, 'https://cadena100-cdnmed.cadena100.es/resources/jpg/7/4/1588871366747.jpg');

insert into producto(id, nombre, precio, tipo_producto, imagen) values(1, 'Tarta de queso', 5.43, 'COMIDA', 'https://paprikagourmetonline.es/wp-content/uploads/2021/04/tarta-de-queso-sin-gluten-nouceland.jpg');
insert into producto(id, nombre, precio, tipo_producto, imagen) values(2, 'Carajillo', 3.4, 'BEBIDA', 'https://imag.bonviveur.com/carajillo.jpg');
insert into producto(id, nombre, precio, tipo_producto, imagen) values(3, 'Pastel de calabaza', 4.15, 'COMIDA', 'https://diabetesmarquez.com/wp-content/uploads/2020/04/DSC_0209-768x512.jpg');
insert into producto(id, nombre, precio, tipo_producto, imagen) values(4, 'Capuccino', 2.50, 'BEBIDA', 'https://lilobrunch.com/cdn/shop/products/capuccino_1200x1200.jpg?v=1645735077');
insert into producto(id, nombre, precio, tipo_producto, imagen) values(5, 'Sin producto', 0.00, 'SINPRODUCTO', 'imagen');

insert into usuario (id, nombre, apellidos, email, username, password, tipo, es_premium) values (1, 'admin', 'admin', 'admin@gmail.com', 'admin', '{noop}admin', 'ADMIN', true);
insert into usuario (id, nombre, apellidos, email, username, password, tipo, es_premium) values (2, 'user', 'user', 'user@gmail.com', 'user', '{noop}1234', 'CLIENTE', true);

ALTER SEQUENCE gato_seq RESTART WITH 60;
ALTER SEQUENCE producto_seq RESTART WITH 55;
ALTER SEQUENCE usuario_seq RESTART WITH 52;