package Controller;

import Model.ClienteModel;
import Model.InventarioModel;
import Model.ListaGenerica;
import View.SistemaView;

public class SistemaController {
    private final ListaGenerica<InventarioModel> listaInventario;
    private final ListaGenerica<ClienteModel> listaClientes;
    private final SistemaView view;

    public SistemaController(SistemaView view) {
        this.view = view;
        this.listaInventario = new ListaGenerica<>();
        this.listaClientes = new ListaGenerica<>();
    }

    /**
     * Inicia el sistema y muestra el menú principal, manejando las opciones seleccionadas por el usuario.
     */
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            view.menuPrincipal();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> productos();
                case 2 -> clientes();
                case 5 -> {
                    view.mensaje("Guardando y saliendo...");
                    view.menuDespedida();
                    salir = true;
                }
                default -> view.error("Opción inválida");
            }
        }
    }

    /**
     * Muestra el menú de gestión de productos y maneja las opciones seleccionadas por el usuario.
     */
    public void productos(){
        boolean volver = false;

        while (!volver) {
            view.menuProductos();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1:{
                    agregarProducto();
                    break;
                }
                case 2:{
                    modificarProducto();
                    break;
                }
                case 3 :{
                    eliminarProducto();
                    break;
                }
                case 4: {
                    listarProductos();
                    break;
                }
                case 5: {
                    menuBuscar();
                    break;
                }
                case 6: {
                    volver = true;
                    break;
                }
                default:{
                    view.error("Opcion no valida");
                }
            }
        }
    }

    /**
     * Muestra el menú de gestión de clientes y maneja las opciones seleccionadas por el usuario.
     */
    public void clientes(){
        boolean volver = false;
        while (!volver) {
            view.menuClientes();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1:{
                    agregarCliente();
                    break;
                }
                case 2:{
                    modificarCliente();
                    break;
                }
                case 3:{
                    eliminarCliente();
                    break;
                }
                case 4: {
                    listarClientes();
                    break;
                }
                case 5: {
                    menuBuscarClientes();
                    break;
                }
                case 6: {
                    volver = true;
                    break;
                }
                default:{
                    view.error("Opcion no valida");
                }
            }
        }
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes.
     */
    public void agregarCliente(){
        int id = view.pedirId();
        String nombre = view.pedirNombre();
        String email = view.pedirEmail();
        String telefono = view.pedirTelefono();
        double saldo = view.pedirSaldo();
        ClienteModel nuevoCliente = new ClienteModel(id, nombre, email, telefono, saldo);
        listaClientes.agregar(nuevoCliente);
    }

    /**
     * Agrega un nuevo producto al inventario si no se ha alcanzado el límite máximo de 100 productos.
     */
    public void agregarProducto(){
        if(listaInventario.size() >= 100){
            view.error("No se pueden agregar mas productos, inventario lleno");
            return;
        }
        String codigo = view.pedirCodigo();
        String nombre = view.pedirNombreProducto();
        double precio = view.pedirPrecio();
        int cantidad = view.pedirCantidad();
        String categoria = view.pedirCategoria();
        String fechaVencimiento = view.pedirFechaVencimiento();
        InventarioModel nuevoProducto = new InventarioModel(codigo, nombre, precio,cantidad, categoria, fechaVencimiento);
        listaInventario.agregar(nuevoProducto);
    }
    /**
     * Elimina un cliente de la lista de clientes después de confirmar la acción con el usuario.
     */
    public void eliminarCliente() {
        view.mensaje("----------- Eliminar Cliente -----------");

        view.mensaje("Ingrese el numero del cliente a eliminar (1 - " + listaClientes.size() + "): ");
        int index = view.leerOpcion();

        if(index < 1 || index > listaClientes.size()){
            view.error("Numero invalido");
            return;
        }
        view.mensaje("Cliente encontrado: " + listaClientes.get(index - 1).getNombre());

        String confirmacion = view.confirmacion();

        if(confirmacion.equalsIgnoreCase("S")){
            listaClientes.eliminar(index - 1);
            view.mensaje("Cliente eliminado");
        }else{
            view.mensaje("Operacion cancelada");
        }
    }
    /**
     * Elimina un producto del inventario basado en su código.
     */
    public void eliminarProducto(){
        String codigo = view.pedirCodigo();
        for(int i = 0; i < listaInventario.size(); i++){
            if(listaInventario.get(i).getCodigo().equalsIgnoreCase(codigo)){
                listaInventario.get(i).totalProductos -= listaInventario.get(i).getCantidad();
                listaInventario.eliminar(i);
                view.mensaje("Producto eliminado");
                return;
            }else{
                view.error("Inventario no encontrado");
            }
        }
    }

    /**
     * Modifica los datos de un cliente existente en la lista de clientes.
     */
    public void modificarCliente(){
        view.mensaje("----------- Modificar Cliente -----------");

        view.mensaje("Ingrese el numero del cliente a modificar (1 - " + listaClientes.size() + "): ");
        int index = view.leerOpcion();

        if(index < 1 || index > listaClientes.size()){
            view.error("Numero invalido");
            return;
        }

        view.mensaje("Cliente encontrado: " + listaClientes.get(index - 1).getNombre());
        view.mensaje("Ingrese los nuevos datos:");

        int id = view.pedirId();
        String nombre = view.pedirNombre();
        String email = view.pedirEmail();
        String telefono = view.pedirTelefono();
        double saldo = view.pedirSaldo();
        ClienteModel clienteMod = new ClienteModel(id, nombre, email, telefono, saldo);
        listaClientes.actualizar(index - 1, clienteMod);
        view.mensaje("Cliente modificado");
    }

    /**
     * Modifica los datos de un producto existente en el inventario basado en su código.
     */
    public void modificarProducto(){
        view.mensaje("----------- Modificar Producto -----------");

        String codigo = view.pedirCodigo();
        for(int i = 0; i < listaInventario.size(); i++){
            if(listaInventario.get(i).getCodigo().equals(codigo)){
                view.mensaje("Producto encontrado: " + listaInventario.get(i).getNombre());
                view.mensaje("Ingrese los nuevos datos:");

                String nombre = view.pedirNombreProducto();
                double precio = view.pedirPrecio();
                int cantidad = view.pedirCantidad();
                String categoria = view.pedirCategoria();
                String fechaVencimiento = view.pedirFechaVencimiento();
                InventarioModel productoMod = new InventarioModel(codigo, nombre, precio,cantidad, categoria, fechaVencimiento);
                listaInventario.actualizar(i, productoMod);
                view.mensaje("Producto modificado: " + productoMod.getNombre());
            }else{
                view.error("Producto no encontrado");
            }
        }
    }

    /**
     * Lista todos los clientes registrados en el sistema.
     */
    public void listarClientes(){
        view.mensaje("----------- Lista de Clientes -----------");
        for(int i = 0; i < listaClientes.size(); i++){
            ClienteModel cliente = listaClientes.get(i);
            view.mensaje((i + 1) + ". ID: " + cliente.getId() + ", " +
                    "Nombre: " + cliente.getNombre() + ", " +
                    "Email: " + cliente.getEmail() + ", " +
                    "Telefono: " + cliente.getTelefono() + ", " +
                    "Saldo: " + cliente.getSaldo());
        }
    }

    /**
     * Lista todos los productos en el inventario.
     */
    public void listarProductos(){
        view.mensaje("----------- Lista de Productos -----------");
        for(int i = 0; i < listaInventario.size(); i++){
            InventarioModel producto = listaInventario.get(i);
            view.mensaje((i + 1) + ". Codigo: " + producto.getCodigo() +
                    ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() +
                    ", Cantidad: " + producto.getCantidad() + ", Categoria: " + producto.getCategoria() +
                    ", Fecha de Vencimiento: " + producto.getFechaVencimiento());
        }
    }

    /**
     * Busca un cliente por su ID y muestra sus detalles si se encuentra.
     */
    public void buscarClienteById(){
        int id = view.pedirId();
        for(int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getId() == id){
                mostrarDetallesCliente(listaClientes.get(i).getId());
                return;
            }
        }
        view.error("Cliente no encontrado");
    }

    /**
     * Busca un cliente por su nombre y muestra sus detalles si se encuentra.
     */
    public void buscarClienteByNombre(){
        String nombre = view.pedirNombre();
        for(int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getNombre().equalsIgnoreCase(nombre)){
                mostrarDetallesCliente(listaClientes.get(i).getId());
                return;
            }
        }
        view.error("Cliente no encontrado");
    }

    /**
     * Muestra los detalles de un cliente dado su ID.
     * @param id El ID del cliente cuyos detalles se desean mostrar.
     */
    public void mostrarDetallesCliente(int id){
        for(int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getId() == id){
                ClienteModel cliente = listaClientes.get(i);
                view.mensaje("\n---------- Detalles del Cliente ----------");
                view.mensaje("ID: " + cliente.getId());
                view.mensaje("Nombre: " + cliente.getNombre());
                view.mensaje("Email: " + cliente.getEmail());
                view.mensaje("Telefono: " + cliente.getTelefono());
                view.mensaje("Saldo: " + cliente.getSaldo());
                return;
            }
        }
    }

    /**
     * Busca un producto por su código y muestra sus detalles si se encuentra.
     */
    public void buscarProductoByCodigo(){
        String codigo = view.pedirCodigo();
        for(int i = 0; i < listaInventario.size(); i++){
            if(listaInventario.get(i).getCodigo().equals(codigo)){
                mostrarDetallesProducto(listaInventario.get(i).getCodigo());
                return;
            }
        }
        view.error("Producto no encontrado");
    }

    /**
     * Busca un producto por su nombre y muestra sus detalles si se encuentra.
     */
    public void buscarProductoByNombre(){
        String nombre = view.pedirNombreProducto();
        for(int i = 0; i < listaInventario.size(); i++){
            if(listaInventario.get(i).getNombre().equals(nombre)){
               mostrarDetallesProducto(listaInventario.get(i).getCodigo());
                return;
            }
        }
        view.error("Producto no encontrado");
    }

    /**
     * Muestra los detalles de un producto dado su código.
     * @param codigo El código del producto cuyos detalles se desean mostrar.
     */
    public void mostrarDetallesProducto(String codigo){
        for(int i = 0; i < listaInventario.size(); i++){
            if(listaInventario.get(i).getCodigo().equals(codigo)){
                InventarioModel producto = listaInventario.get(i);
                view.mensaje("\n---------- Detalles del Producto ----------");
                view.mensaje("Codigo: " + producto.getCodigo());
                view.mensaje("Nombre: " + producto.getNombre());
                view.mensaje("Precio: " + producto.getPrecio());
                view.mensaje("Cantidad: " + producto.getCantidad());
                view.mensaje("Categoria: " + producto.getCategoria());
                view.mensaje("Fecha de Vencimiento: " + producto.getFechaVencimiento());
                return;
            }
        }
    }

    /**
     * Muestra el menú de búsqueda de productos y maneja las opciones seleccionadas por el usuario.
     */
    public void menuBuscar(){
        boolean salir = false;
        while (!salir) {
            view.menuBuscarProd();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> {
                    buscarProductoByNombre();
                    salir = true;
                }
                case 2 -> {
                    buscarProductoByCodigo();
                    salir = true;
                }
                case 3 -> salir = true;
                default -> view.error("Opcion no valida");
            }
        }
    }

    /**
     * Muestra el menú de búsqueda de clientes y maneja las opciones seleccionadas por el usuario.
     */
    public void menuBuscarClientes(){
        boolean salir = false;
        while (!salir) {
            view.menuBuscarCliente();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> {
                    buscarClienteByNombre();
                    salir = true;
                }
                case 2 -> {
                    buscarClienteById();
                    salir = true;
                }
                case 3 -> salir = true;
                default -> view.error("Opcion no valida");
            }
       }
    }

}
