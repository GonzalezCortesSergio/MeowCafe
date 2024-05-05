insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (1, 'Freyja', '19:48', false, '/img/WhatsApp Image 2024-05-02 at 19.16.19.jpeg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (2, 'Elva', '7:11', false, 'https://t2.ea.ltmcdn.com/es/posts/7/4/3/como_ayudar_a_un_gatito_a_defecar_20347_orig.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (3, 'Ebba', '19:45', false, 'https://t2.ea.ltmcdn.com/es/posts/7/4/3/como_ayudar_a_un_gatito_a_defecar_20347_orig.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (4, 'Lucien', '0:45', false, 'https://www.tiendanimal.es/articulos/wp-content/uploads/2010/06/la-forma-de-ser-de-tu-gatito-cachorro-1200x900.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (5, 'Beth', '2:42', false, 'https://clinicaveterinariaalbeitar.es/wp-content/uploads/2019/01/gatito1.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (6, 'Vick', '7:44', true, 'https://www.zooplus.es/magazine/wp-content/uploads/2018/04/fotolia_169457098.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (7, 'Timothee', '10:12', true, 'https://cdn.unotv.com/images/2023/11/gato-173700-1024x576.jpeg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (8, 'Clotilda', '6:32', false, 'https://comunidad.retorn.com/wp-content/uploads/2023/03/gatito.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (9, 'Kerwin', '4:36', true, 'https://www.veteralia.com/wp-content/uploads/2017/03/Intro.jpg');
insert into gato (id, nombre, horas_disponibles, ocupado, imagen) values (10, 'Caryl', '6:10', false, 'https://cadena100-cdnmed.cadena100.es/resources/jpg/7/4/1588871366747.jpg');



insert into usuario (id, nombre, apellidos, email, nombre_usuario, contrasena, tipo, es_premium) values (1, 'admin', 'admin', 'admin@gmail.com', 'admin', '1234', 'ADMIN', true); 
insert into usuario (id, nombre, apellidos, email, nombre_usuario, contrasena, tipo, es_premium) values (2, 'Sergio', 'González Cortés', 'gonzalez.coser24@triana.salesianos.edu', 'Sergio González', '1234', 'CLIENTE', true);

alter sequence usuario_seq start with 3 increment by 50;