package com.ferremex.Ferreteria.Controller;

import com.ferremex.Ferreteria.Model.Producto;
import com.ferremex.Ferreteria.Service.Interfece.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService prodServ;

    public ProductoController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }
    //READ
    @GetMapping
    public List<Producto> traerProductos(){
        return prodServ.traerProducto();
    }
    //READ de producto especifico
    @GetMapping("/{codProd}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long codProd){

        Producto prod = prodServ.buscarProducto(codProd);

        if (prod == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un producto con ese codProd: " + codProd);
        }

        return ResponseEntity.ok(prod);
    }

    //CREATED
    @PostMapping
    public ResponseEntity <?> crearProducto(@RequestBody Producto prod){
        Producto productoCreado = prodServ.crearProducto(prod);

        if (productoCreado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del producto no son validos");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Nuevo producto creado:  " + prod.getNombre());
    }
    //UPDATE
    @PutMapping("/{codProd}")
    public ResponseEntity <?> editarProducto(@PathVariable Long codProd,
                                             @RequestBody Producto prod){
        Producto prodEditado = prodServ.editarProducto(codProd,prod);

        if (prodEditado == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No fue posible editar el producto");
        }
        return ResponseEntity.ok(prodEditado);
    }
    //DELETE
    @DeleteMapping("/{codProd}")
    ResponseEntity<String> eliminarProducto(@PathVariable Long codProd){
        boolean eliminado = prodServ.eliminarProducto(codProd);
        if(eliminado == false){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se encontro un producto con el codigo: " + codProd);
        }
        return ResponseEntity
                .ok()
                .body("Producto eliminado correctamente: " + codProd);

    }

}
