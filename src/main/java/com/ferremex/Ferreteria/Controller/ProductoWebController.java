package com.ferremex.Ferreteria.Controller;

import com.ferremex.Ferreteria.Model.Producto;
import org.springframework.ui.Model;
import com.ferremex.Ferreteria.Service.Interfece.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {
    private final IProductoService prodServ;

    public ProductoWebController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }

    //Lista de productos
    @GetMapping
    public String traerProductos (Model model) {
        model.addAttribute(
                "productos",
                prodServ.traerProducto()
        );

        return "products/lista";
    }

    //Get para traer la pagina del formulario
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("producto",new Producto());
        model.addAttribute("titulo","Registrar Producto");

        return "productos/formulario";
    }

    //Post para guardar el formulario
    @PostMapping("/crear")
    public String crearProducto(@ModelAttribute Producto producto,Model model){
        Producto resultado;

    }
}
