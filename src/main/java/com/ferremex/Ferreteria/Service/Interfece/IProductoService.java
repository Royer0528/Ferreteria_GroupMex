package com.ferremex.Ferreteria.Service.Interfece;

import com.ferremex.Ferreteria.Model.Producto;

import java.util.List;

public interface IProductoService {
    //CRUD
    List<Producto> traerProducto();
    //Read
    Producto buscarProducto(Long codProd);
    //Created
    Producto crearProducto(Producto prod );
    //Update
    Producto editarProducto(Long codProd,Producto prod);
    //Delete
    boolean eliminarProducto(Long codProd);

}
