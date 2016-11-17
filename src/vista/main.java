package vista;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import modelo.Categorias;
import modelo.Clientes;
import modelo.Factura;
import modelo.Persona;
import modelo.Productos;

public class main {

	// Variable que se encargará de salir del programa cuando el usuario lo
	// indique
	static boolean salir = false;
	// Objeto cliente
	static Clientes clientes;
	// Objeto Categorias
	static Categorias categorias;
	// Objeto productos
	static Productos productos;
	// Objeto facturas
	static Factura facturas;

	// Lista que contiene los clientes
	static ArrayList<Clientes> clientesLista = new ArrayList<>();
	// Lista que contiene las categorias
	static ArrayList<Categorias> categoriasLista = new ArrayList<>();
	// Lista que contiene los productos
	static ArrayList<Productos> productosLista = new ArrayList<>();
	// Lista que contiene las facturas
	static ArrayList<Factura> facturasLista = new ArrayList<>();
	// Se crea un objeto scanner para leer los datos que se ingresan.
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// Carga en las listas categorías y productos por defecto, con el fin de
		// hacer más real el aplicativo. Si desean que no existan datos al
		// iniciar el programa, comentar la siguiente línea(cargarDatosPorDefecto())
		cargarDatosPorDefecto();
		// Se hace un do While, que mostrará el menú principal siempre que se
		// termine de realizar algún proceso en un área específica, la única
		// forma de salirse es que el usuario seleccione salir.
		do {
			menuPrincipal();
		} while (salir == false);

	}

	/**
	 * Muestra el menú principal. El usuario selecciona un número dependiendo de
	 * lo que necesite.
	 * */
	public static void menuPrincipal() {
		// Entero que tiene las opciones del menú disponibles.
		String opcionesMenu = "";
		// Se muestra el menú principal al usuario.
		System.out.println("\nBienvenido al sistema de facturación.\n "
				+ "Por favor ingrese el número para ingresar a un área \n"
				+ "1. Área comercial \n" + "2. Área de despacho \n"
				+ "3. Área de facturación \n" + "4. Salir \n");
		// Se guarda la opción ingresada por el usuario.
		opcionesMenu = in.nextLine();
		// Uso de un swtich para las diferentes opciones que seleccione el
		// usuario. Se llaman métodos estáticos dependiendo de lo que el
		// usuario seleccione.
		switch (opcionesMenu) {

		case ("1"):
			// Llama al área comercial y permite ver su menú.
			menuAreaComercial();
			break;

		case ("2"):
			// Llama al área de despacho y permite ver su menú.
			menuAreaDespacho();
			break;

		case ("3"):
			// Llama al área de facturación y permite ver su menú.
			menuAreaFacturacion();
			break;
		case ("4"):
			// Sale del aplicativo.
			System.out.println("Usted ha salido de la aplicación");
			System.exit(0);
			break;
		default:
			limpiarConsola();
			System.out
					.println("Usted ha ingresado una opción no válida, por favor ingrese una opción de las que aparece en el menú.\n");
		}

	}

	/**
	 * Muestra el menú del área comercial, permite crear y listar los clientes
	 * existentes.
	 * */
	public static void menuAreaComercial() {
		// Entero que tiene las opciones del menú de área comercial.
		String opcionesMenu = "";
		// Se muestra el menú principal al usuario.
		System.out.println("Ingrese una opción para el área comercial.\n"
				+ "1. Ingresar cliente nuevo \n"
				+ "2. Mostrar todos los clientes \n" + "3. Menú principal \n"
				+ "4. Salir \n");
		// Se guarda la opción ingresada por el usuario.
		opcionesMenu = in.nextLine();
		// Uso de un switch para las diferentes opciones que seleccione el
		// usuario. Se llaman métodos estáticos dependiendo de lo que el
		// usuario seleccione.
		switch (opcionesMenu) {

		case ("1"):
			// Se llama el método para crear el cliente
			crearCliente();
			break;

		case ("2"):
			// Se listan todos los clientes.
			listarClientes();
			break;

		case ("3"):
			// Se vuelve al menú principal.
			menuPrincipal();
			break;
		case ("4"):
			// Sale de la aplicación
			System.out.println("Usted ha salido de la aplicación");
			salir = true;
			System.exit(0);
			break;
		default:
			System.out
					.println("Usted ha ingresado una opción no válida, por favor ingrese una opción de las que aparece en el menú.\n");
			menuAreaComercial();
		}
	}

	/**
	 * Muestra el menú de despacho, es decir, para crear productos, categorías o
	 * listar tanto productos como categorías existentes.
	 * */
	public static void menuAreaDespacho() {
		// Entero que tiene las opciones del menú de área de despacho.
		String opcionesMenu = "";
		// Se muestra el menú principal al usuario.
		System.out.println("Ingrese una opción para el área de despacho.\n"
				+ "1. Crear categoría nueva \n"
				+ "2. Crear un producto nuevo \n" + "3. Listar categorías \n"
				+ "4. Listar productos \n" + "5. Menú principal \n"
				+ "6. Salir \n");
		// Se guarda la opción ingresada por el usuario.
		opcionesMenu = in.nextLine();
		// Uso de un switch para las diferentes opciones que seleccione el
		// usuario. Se llaman métodos estáticos dependiendo de lo que el
		// usuario seleccione.
		switch (opcionesMenu) {

		case ("1"):
			// Se llama el método para crear una categoría nueva.
			crearCategoria();
			break;

		case ("2"):
			// Se llama el método para crear un producto nuevo.
			crearProducto("Menu");
			break;
		case ("3"):
			// Lista de todas las categorías existentes.
			listarCategorias("Menu");
			break;
		case ("4"):
			// Lista de todos los productos.
			listarProductos("Menu");
			break;
		case ("5"):
			// Se vuelve al menú principal.
			menuPrincipal();
			break;
		case ("6"):
			// Sale de la aplicación
			System.out.println("Usted ha salido de la aplicación");
			salir = true;
			System.exit(0);
			break;
		default:
			System.out
					.println("Usted ha ingresado una opción no válida, por favor ingrese una opción de las que aparece en el menú.\n");
			menuAreaDespacho();
		}
	}

	/**
	 * Muestra el menú para facturar, es decir, para crear facturas o para ver
	 * las facturas existentes.
	 * */
	public static void menuAreaFacturacion() {
		// Entero que tiene las opciones del menú de área de facturación.
		String opcionesMenu = "";
		// Se muestra el menú al usuario.
		System.out.println("Ingrese una opción para el área de facturación.\n"
				+ "1. Vender un producto \n" + "2. Listar ventas \n"
				+ "3. Menú principal\n" + "4. Salir");
		// Se guarda la opción ingresada por el usuario.
		opcionesMenu = in.nextLine();
		// Uso de un switch para las diferentes opciones que seleccione el
		// usuario. Se llaman métodos estáticos dependiendo de lo que el
		// usuario seleccione.
		switch (opcionesMenu) {

		case ("1"):
			// Se llama el método para crear una factura nueva.
			crearFactura();
			break;

		case ("2"):
			// Se llama el método para listar las facturas.
			listarFacturas();
			break;
		case ("3"):
			// Vuelve al menú principal
			menuPrincipal();
			break;
		case ("4"):
			// Sale de la aplicación
			System.out.println("Usted ha salido de la aplicación");
			salir = true;
			System.exit(0);
			break;
		default:
			System.out
					.println("Usted ha ingresado una opción no válida, por favor ingrese una opción de las que aparece en el menú.\n");
			menuAreaFacturacion();
		}
	}

	/**
	 * Permite crear un nuevo cliente, se piden los datos del cliente y se
	 * agregan a la instancia cliente, después se ingresan a la lista de
	 * clientes.
	 * */
	public static void crearCliente() {
		// Atributos del cliente.
		String nombreCliente;
		String apellidoCliente;
		int cedulaCliente;
		int telefonoCliente;
		System.out
				.println("Por favor ingrese los siguientes datos del cliente:\n");
		// Se utiliza el nextLine para recibir toda una línea y el in para
		// cargar los datos que ingrese el usuario por medio de la consola
		// in.nextLine() Se validan por medio de expresiones regulares;
		System.out.println("Nombres: \n");
		nombreCliente = validarCadena(in.nextLine());
		System.out.println("Apellidos: \n");
		apellidoCliente = validarCadena(in.nextLine());
		System.out.println("Cédula: \n");
		cedulaCliente = validarEntero(in.nextLine());
		System.out.println("Teléfono: \n");
		telefonoCliente = validarEntero(in.nextLine());
		// Se crea un nuevo cliente
		clientes = new Clientes(nombreCliente, apellidoCliente, cedulaCliente,
				telefonoCliente);
		// Se agrega el cliente a la lista de clientes
		clientesLista.add(clientes);
		System.out
				.println("El cliente ha sido creado correctamente. \nDesea crear un nuevo cliente? (SI/NO) ");
		String nuevoCliente = validarCadena(in.nextLine());
		if (nuevoCliente.equals("SI")) {
			crearCliente();
		} else {
			menuAreaComercial();
		}
	}

	/**
	 * Permite crear una categoría, se piden los datos de la categoría y se
	 * agregan a la instancia categorías, después se ingresan a la lista de
	 * clientes.
	 * */
	public static void crearCategoria() {
		// Atributos para la categoría
		int idCategoria;
		String nombreCategoria;
		System.out
				.println("Por favor ingrese los siguientes datos para la categoría nueva:\n");
		System.out.println("número de Referencia: \n");
		// Se utiliza el nextLine para recibir toda una línea y el in para
		// cargar los datos que ingrese el usuario por medio de la consola
		idCategoria = validarEntero(in.nextLine());
		System.out.println("Nombre de la categoría: \n");
		nombreCategoria = validarCadena(in.nextLine());
		// Se crea una nueva categoría
		categorias = new Categorias(idCategoria, nombreCategoria);
		// Se agrega la categoría a la lista de categorías
		categoriasLista.add(categorias);
		System.out.println("La categoría ha sido creada correctamente. \n");
		menuAreaDespacho();
	}

	/**
	 * Permite crear un nuevo producto, se piden los datos del producto y se
	 * agregan a la instancia del producto, después se ingresan a la lista de
	 * productos.
	 * */
	public static void crearProducto(String estado) {
		// Atributos del cliente.
		int referenciaProducto;
		int referenciaCategoria;
		int indiceCategoria;
		String nombreProducto;
		double precio;
		String talla;
		String color;
		int cantidadDisponible;
		// Se listan todas las categorías existentes, para que el cliente pueda
		// seleccionar a qué categoría pertenecerá el producto
		listarCategorias("Otro");
		System.out
				.println("Ingrese el número de referencia de la categoría a la cual pertenece el producto:\n");
		referenciaCategoria = validarEntero(in.nextLine());
		indiceCategoria = buscarCategoriaPorReferencia(referenciaCategoria);
		if (indiceCategoria != -1) {
			System.out
					.println("Por favor ingrese los siguientes datos sobre el producto:\n");
			System.out.println("Referencia Producto: \n");
			// Se utiliza el nextLine para recibir toda una línea y el in para
			// cargar los datos que ingrese el usuario por medio de la consola
			referenciaProducto = validarEntero(in.nextLine());
			System.out.println("Nombre: \n");
			nombreProducto = validarCadena(in.nextLine());
			System.out.println("Precio: \n");
			precio = validarDouble(in.nextLine());
			System.out.println("Talla: \n");
			talla = validarCadena(in.nextLine());
			System.out.println("Color: \n");
			color = validarCadena(in.nextLine());
			System.out.println("Cantidad disponible: \n");
			cantidadDisponible = validarEntero(in.nextLine());
			// Se crea un nuevo producto
			productos = new Productos(referenciaCategoria, categoriasLista.get(
					indiceCategoria).getNombreCategoria(), referenciaProducto,
					nombreProducto, precio, talla, color, cantidadDisponible);

			// Se agrega el producto a la lista de productos
			productosLista.add(productos);
			System.out.println("El producto ha sido creado correctamente. \n");
			if (estado == "Menu") {
				menuAreaDespacho();
			}

		} else {
			System.out
					.println("La referencia de categoría que ha ingresado no existe, por favor repita el procedimiento.");
			// Se llama nuevamente el método para crear el producto
			crearProducto(estado);
		}
	}

	/**
	 * Permite crear un nuevo producto, se piden los datos del producto y se
	 * agregan a la instancia del producto, después se ingresan a la lista de
	 * productos.
	 * */
	public static void crearFactura() {
		// Atributos de la factura, categoría y del producto
		int referenciaProducto;
		int referenciaCategoria;
		int numeroFactura;
		int cantidad;
		int indiceCategoria;
		int indiceProducto;
		double total;
		// Se muestra al usuario las categorías que existen.
		listarCategorias("Otro");
		System.out
				.println("Ingrese el número de referencia de la categoría que desea:\n");
		// Guarda el número de referencia de categoría ingresado por el usuario.
		referenciaCategoria = validarEntero(in.nextLine());
		// Se guarda la posición donde se encuentra la categoría seleccionada
		indiceCategoria = buscarCategoriaPorReferencia(referenciaCategoria);
		// Si existe el número de categoría ingresado por el sistema el indice
		// será distinto de -1
		if (indiceCategoria != -1) {
			// Se muestran todos los productos según la categoría seleccionada.
			if (listarProductosPorCategoria(referenciaCategoria) > 0) {
				System.out
						.println("Ingrese el número de referencia del producto que desea:\n");
				// Guarda el número de referencia del producto seleccionado por
				// el usuario.
				referenciaProducto = validarEntero(in.nextLine());
				// Se guarda la posición donde se encuentra el producto
				// seleccionado.
				indiceProducto = buscarProductosPorReferencia(
						referenciaProducto, referenciaCategoria);
				// Si existe el número de producto ingresado por el sistema el
				// índice será distinto de -1
				if (indiceProducto != -1) {
					// Se llama al método de validar factura, el cual valida si
					// hay inventario para un producto y agrega la factura como
					// tal
					validarFactura(referenciaCategoria, indiceCategoria);
				} else {
					System.out
							.println("Ha ingresado una referencia no existente para el producto. por favor cree el producto\n");
					// Se llama nuevamente el método para crear el producto
					crearProducto("Factura");
					// Se llama al método de validar factura, el cual valida si
					// hay inventario para un producto y agrega la factura como
					// tal
					validarFactura(referenciaCategoria, indiceCategoria);
				}
			} else {
				System.out.println("No hay productos para la categoría "
						+ categoriasLista.get(indiceCategoria)
								.getNombreCategoria()
						+ " a continuación creará el producto");
				// Se llama nuevamente el método para crear el producto
				crearProducto("Factura");
				// Se llama al método de validar factura, el cual valida si
				// hay inventario para un producto y agrega la factura como
				// tal
				validarFactura(referenciaCategoria, indiceCategoria);

			}
		} else {
			System.out
					.println("El número de categoría ingresado no existe reinicie el proceso ");
			menuAreaFacturacion();
		}
	}

	/**
	 * El método recibe como parámetros la referencia de la categoría y el
	 * índice donde está esa categoría que se va a utilizar, este método crea la
	 * factura si las condiciones como la cantidad disponible es valida
	 * */
	public static void validarFactura(int referenciaCategoria,
			int indiceCategoria) {
		int indiceProducto = productosLista.size() - 1;
		System.out.println("Número de factura: \n");
		// Se guarda el número de factura
		int numeroFactura = validarEntero(in.nextLine());
		// Se ingresa la cantidad deseada del producto.
		System.out.println("Cantidad deseada: \n");
		int cantidad = validarEntero(in.nextLine());
		// Se valida que la cantidad ingresada sea menor a la
		// cantidad existente.
		if (cantidad <= productosLista.get(indiceProducto)
				.getCantidadDisponible()) {
			// Se guarda el total del pedido.
			double total = cantidad
					* productosLista.get(indiceProducto).getPrecio();
			// Se crea un objeto factura con todos los datos
			// obtenidos.
			facturas = new Factura(referenciaCategoria, categoriasLista.get(
					indiceCategoria).getNombreCategoria(), productosLista.get(
					indiceProducto).getReferencia(), productosLista.get(
					indiceProducto).getNombreProducto(), productosLista.get(
					indiceProducto).getPrecio(), productosLista.get(
					indiceProducto).getTalla(), productosLista.get(
					indiceProducto).getColor(), productosLista.get(
					indiceProducto).getCantidadDisponible(), numeroFactura,
					cantidad, total);
			// Se agrega el objeto factura nuevo a la lista de
			// facturas.
			facturasLista.add(facturas);
			// Se resta la cantidad disponible del producto
			// facturado
			productosLista.get(indiceProducto).setCantidadDisponible(
					productosLista.get(indiceProducto).getCantidadDisponible()
							- cantidad);
			System.out.println("La factura ha sido creada correctamente. \n");
			menuAreaFacturacion();
		} else {
			System.out
					.println("No se puede Realizar la Factura porque no existe Inventario del Articulo\n");
			menuAreaFacturacion();
		}
	}

	/**
	 * Devuelve una lista completa de los clientes existentes en la aplicación,
	 * para eso se hace un recorrido a la lista que tiene todos los clientes y
	 * se van mostrando en pantalla.
	 * */
	public static void listarClientes() {
		// Se valida que existan clientes, de lo contrario sale un mensaje
		// diciendo que no hay clientes
		if (clientesLista.size() > 0) {
			// Se recorren todos los clientes y se muestran
			System.out.println("Número de clientes: " + clientesLista.size());
			// Se recorre la lista de clientes y se imprime cada cliente.
			for (int i = 0; i < clientesLista.size(); i++) {
				System.out.println("\nNombre:"
						+ clientesLista.get(i).getNombre() + "\nApellido: "
						+ clientesLista.get(i).getApellido() + "\nCédula: "
						+ clientesLista.get(i).getCedula() + "\nTeléfono: "
						+ clientesLista.get(i).getTelefono() + "\n\n");
			}
			menuAreaComercial();
		} else {
			System.out.println("No existen clientes. \n");
			menuAreaComercial();
		}
	}

	/**
	 * Devuelve una lista completa de las categorías existentes en la
	 * aplicación, para eso se hace un recorrido a la lista que tiene todas las
	 * categorías y las va mostrando en pantalla.
	 * */
	public static void listarCategorias(String estado) {
		// Se valida que existan clientes, de lo contrario sale un mensaje
		// diciendo que no hay clientes
		if (categoriasLista.size() > 0) {
			// Se recorren todos los clientes y se muestran
			System.out.println("Número de categorías: "
					+ categoriasLista.size() + "\n");
			// Se recorre la lista de clientes y se imprime cada cliente.
			for (int i = 0; i < categoriasLista.size(); i++) {
				System.out.println("Referencia: "
						+ categoriasLista.get(i).getIdCategoria()
						+ "\tNombre: "
						+ categoriasLista.get(i).getNombreCategoria());
			}
			if (estado == "Menu") {
				menuAreaDespacho();
			}
		} else {
			System.out.println("No existen categorías. \n");
			if (estado == "Menu") {
				menuAreaDespacho();
			}
		}
	}

	/**
	 * Devuelve una lista completa de los productos existentes en la aplicación,
	 * para eso se hace un recorrido a la lista que tiene todos los productos y
	 * los va mostrando en pantalla.
	 * */
	public static void listarProductos(String estado) {
		// Se valida que existan productos, de lo contrario sale un mensaje
		// diciendo que no hay productos
		if (productosLista.size() > 0) {
			// Se recorren todos los clientes y se muestran
			System.out.println("Número de productos: " + productosLista.size()
					+ "\n");
			// Se recorre la lista de productos y se imprime cada producto.
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println("Categoría: "
						+ productosLista.get(i).getNombreCategoria()
						+ "\tNombre producto: "
						+ productosLista.get(i).getNombreProducto()
						+ "\tPrecio: " + productosLista.get(i).getPrecio()
						+ "\tTalla: " + productosLista.get(i).getTalla()
						+ "\tColor: " + productosLista.get(i).getColor()
						+ "\tCantidad disponible: "
						+ productosLista.get(i).getCantidadDisponible());
			}
			if (estado == "Menu") {
				menuAreaDespacho();
			}
		} else {
			System.out.println("No existen productos. \n");
			if (estado == "Menu") {
				menuAreaDespacho();
			}
		}
	}

	/**
	 * Devuelve una lista completa de las facturas existentes en la aplicación,
	 * para eso se hace un recorrido a la lista que tiene todos las facturas y
	 * los va mostrando en pantalla.
	 * */
	public static void listarFacturas() {
		// Se valida que existan facturas, de lo contrario sale un mensaje
		// diciendo que no hay facturas
		if (facturasLista.size() > 0) {
			// Se recorren todas las facturas y se muestran
			System.out.println("Número de facturas: " + facturasLista.size()
					+ "\n");
			// Se recorre la lista de facturas y se imprime cada factura.
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println("Número de factura"
						+ facturasLista.get(i).getNumeroFactura()
						+ "\tCategoría: "
						+ facturasLista.get(i).getNombreCategoria()
						+ "\tProducto: "
						+ facturasLista.get(i).getNombreProducto()
						+ "\tCantidad: " + facturasLista.get(i).getCantidad()
						+ "\tValor Unidad: " + facturasLista.get(i).getPrecio()
						+ "\tValor total: "
						+ facturasLista.get(i).getPrecioTotal());

			}
			menuAreaFacturacion();
		} else {
			System.out.println("No existen facturas. \n");
			menuAreaFacturacion();
		}
	}

	/**
	 * Devuelve una lista completa de los clientes existentes en la aplicación,
	 * para eso se hace un recorrido a la lista que tiene todos los clientes y
	 * se van mostrando en pantalla.
	 * */
	public static void cargarDatosPorDefecto() {
		categorias = new Categorias(1, "Blusas");
		categoriasLista.add(categorias);
		categorias = new Categorias(2, "Camisas");
		categoriasLista.add(categorias);
		categorias = new Categorias(3, "Camisetas");
		categoriasLista.add(categorias);
		categorias = new Categorias(4, "Pantalón");
		categoriasLista.add(categorias);
		categorias = new Categorias(5, "Zapatos");
		categoriasLista.add(categorias);
		productos = new Productos(2, "Camisas", 11, "Camisa One piece", 35000,
				"M", "Azul Oscura", 20);
		productosLista.add(productos);
		productos = new Productos(5, "Zapatos", 11, "Zapatos brahma", 180000,
				"40", "Grises", 20);
		productosLista.add(productos);
		productos = new Productos(4, "Pantalón", 11, "Diesel 2016", 120000,
				"32", "Azul claro", 10);
		productosLista.add(productos);
		productos = new Productos(1, "Blusas", 11, "Con estampados", 32000,
				"28", "Blanca", 3);
		productosLista.add(productos);
	}

	/**
	 * Devuelve el índice de una categoría que se esté buscando a partir de su
	 * referencia, esto se hace con el fin de tener el objeto completo que se
	 * encuentra almacenado en la lista de Categorías
	 * */
	public static int buscarCategoriaPorReferencia(int referencia) {
		for (int i = 0; i < categoriasLista.size(); i++) {
			if (categoriasLista.get(i).getIdCategoria() == referencia) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Devuelve el índice de un producto que se esté buscando a partir de su
	 * referencia, esto se hace con el fin de tener el objeto completo que se
	 * encuentra almacenado en la lista de productos
	 * */
	public static int buscarProductosPorReferencia(int referenciaProducto,
			int referenciaCategoria) {
		for (int i = 0; i < productosLista.size(); i++) {
			if (productosLista.get(i).getReferencia() == referenciaProducto
					&& productosLista.get(i).getIdCategoria() == referenciaCategoria) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Muestra en pantallalos productos correspondientes a una categoría
	 * específica.
	 * */
	public static int listarProductosPorCategoria(int referencia) {
		// El contador se utiliza para validar que exista mínimo un producto por
		// la categoría seleccionada.
		int contador = 0;
		for (int i = 0; i < productosLista.size(); i++) {
			// Si la referencia de categoría en la lsita es igual a la
			// referencia que se está buscando, la imprime en pantalla
			if (productosLista.get(i).getIdCategoria() == referencia) {
				System.out.println("Referencia producto: "
						+ productosLista.get(i).getReferencia()
						+ "\tNombre producto: "
						+ productosLista.get(i).getNombreProducto()
						+ "\tPrecio: " + productosLista.get(i).getPrecio()
						+ "\tTalla: " + productosLista.get(i).getTalla()
						+ "\tColor: " + productosLista.get(i).getColor()
						+ "\tCantidad disponible: "
						+ productosLista.get(i).getCantidadDisponible());
				contador++;

			}
		}
		return contador;
	}

	public static void limpiarConsola() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}

	}

	public static String validarCadena(String cadena) {
		boolean esCadena = false;
		do {
			if (cadena.matches("([a-z]|[A-Z]|\\s)+")) {
				esCadena = true;
				return cadena;
			} else {
				System.out
						.println("Solamente puede tener caractéres de A-z a-z por favor ingrese nuevamente el campo");
				cadena = in.nextLine();
			}
		} while (esCadena == false);
		return "";
	}

	public static int validarEntero(String cadena) {
		boolean esCadena = false;
		do {
			if (cadena.matches("[0-9.]*")) {
				esCadena = true;
				return Integer.parseInt(cadena);
			} else {
				System.out
						.println("Solamente puede tener números por favor ingrese nuevamente el campo");
				cadena = in.nextLine();
			}
		} while (esCadena == false);
		return 0;
	}

	public static double validarDouble(String cadena) {
		boolean esCadena = false;
		do {
			if (cadena.matches("[0-9.]*")) {
				esCadena = true;
				return Double.parseDouble(cadena);
			} else {
				System.out
						.println("Solamente puede tener números por favor ingrese nuevamente el campo");
				cadena = in.nextLine();
			}
		} while (esCadena == false);
		return 0;
	}

}
