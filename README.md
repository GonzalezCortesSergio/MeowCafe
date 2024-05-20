<h1 style="font-size: 30pt;">Meow Café</h1>

<br>
<br>

# Descripción detallada del sistema

En la aplicación web MeowCafe se busca gestionar los gatos que se encuentran en la cafetería MeowCafe, tomando en cuenta sus vacunaciones y las horas en las que se encuentran disponibles al público (teniendo un horario). Además de las reservas que pueden realizar los clientes.

Existen 2 tipos de usuarios:

El administrador, el cual tendrá control de los gatos, puede:

### Incluir nuevos gatos:

El administrador podrá incluir un nuevo gato introduciendo todos los datos del gato en un formulario, enviándolo a la base de datos y viéndose reflejado en una tabla de registro donde se reflejarán los demás gatos. Esto no hará que pueda encontrarse directamente cara al público, porque después tendrá que configurar los registros de las vacunas editando los datos del gato seleccionándolo en la misma tabla de registros.

### Configurar registros de las vacunas de los gatos:

Como se ha dicho anteriormente, el administrador tendrá que editar los datos de los gatos para registrar sus vacunas; especificando la fecha de vacunación y el nombre de la vacuna, teniendo que ser anualmente, ya que cada año se deben vacunar los gatos.

### Editar los datos de los gatos:

Como se ha explicado en la funcionalidad anterior, el administrador podrá editar los datos de los gatos, además de ser los registros de las vacunas, pueden ser sus horarios de disponibilidad.

### Eliminar los datos de los gatos:

Al igual que puede incluir nuevos, puede eliminar los datos de los gatos, en caso de que fallezcan o alguien decida adoptarlos.

## El administrador además tendrá control de los demás usuarios, pudiendo:

### Ver todos los usuarios registrados:

El administrador será el único que podrá ver una tabla donde se encuentren todos los usuarios registrados, además que puede cambiar el estado de los usuarios, pudiendo hacer que sean premium o no, además de ver el número de reservas que ha realizado el usuario.

### Incluir nuevos productos:

El administrador podrá agregar un nuevo producto a la carta incluyendo todos los datos de dicho producto en un formulario. Estos datos se enviarán a una base de datos que recopile los productos y se verá reflejado en una tabla donde se encuentren todos los productos.


### Editar los productos registrados:

El administrador podrá editar los datos de los productos, esto está principalmente destinado para que se cambien los precios de los productos.


### Eliminar los productos registrados:

El administrador podrá eliminar productos para que la carta de la cafetería se mantenga actualizada, entonces si se elimina un producto de la carta de la cafetería, que se haga también en el registro del producto.


### Crear combos:

El administrador podrá crear nuevos combos con los productos que se encuentren registrados en la base de datos, teniendo que escoger como mínimo un producto que sea una bebida y uno que sea comida. El precio dependerá de los productos que se encuentren en él.


### Editar combos:

El administrador podrá editar los combos, pudiendo cambiar su nombre, añadir o eliminar productos y ponerlos en oferta o quitarlos de la oferta.

### Eliminar combos:

El administrador podrá eliminar los combos que se encuentren registrados.

## Realizar una reserva:

También podrá realizar una reserva, aunque además de tener que incluir los apartados que deben incluir los clientes, debe incluir el nombre y apellidos de la persona, además del correo electrónico del cliente que vaya a realizar una reserva. Además de realizar una reserva, se creará un nuevo usuario sin validar. La validación de dicho usuario se hará en la pestaña de validación, que se le enviará mediante un enlace de correo electrónico, donde habrá un formulario en el que deberá introducir su nombre de usuario y contraseña.

Por otra parte los clientes podrán ver el horario de los gatos y realizar reservas, tomando en las reservas el día, las horas reservadas (teniendo un máximo de 3 horas), y los gatos (teniendo un mínimo de 0 y un máximo de 4). Además, en la reserva se le incluye un “combo”, compuesto por una bebida y un platillo de comida, que se encuentre en el grupo de ofertas. Los grupos de ofertas los podrá cambiar el administrador. En el caso de que se haga una reserva con un “combo” que no se encuentre dentro del grupo de ofertas, se tendrá que pagar el precio del “combo” como adición. Cada 7 reservas tendrán un descuento del 5% en la próxima reserva. Las reservas estarán compuestas por líneas de reservas, donde se encontrarán los gatos que se vayan a reservar, las horas a reservar y el combo que se vaya a escoger siendo el precio total el que obtendrá un descuento.

Los clientes podrán ser premium, pudiendo hacer exactamente lo mismo que un cliente normal, pero en lugar de recibir un descuento del 5%, sería del 25%.


## Vacunas:

De las vacunas queremos saber su nombre y la fecha en la que se ha puesto dicha vacuna, como se ha especificado, es importante agregar por lo menos una vacuna nueva cada año. De no ser así, los gatos no podrán encontrarse cara al público 


## Combo:

Los combos estarán compuestos por productos, tienen como mínimo 1 bebida y 1 plato de comida. Como estrategia para alentar a los clientes a realizar  reservas, se ofrece de forma gratuita 1 combo que se encuentre en oferta. De todas formas los clientes pueden escoger   un combo que no se encuentre en oferta, pero se le cobrará el precio del combo.



## Imagen del diagrama de clases del análisis
<img src="diagrama/Diagrama de clases del análisis.jpg">


## Imagen del diagrama de clases del diseño
<img src="diagrama/Diagrama de clases del diseño.jpg" >
