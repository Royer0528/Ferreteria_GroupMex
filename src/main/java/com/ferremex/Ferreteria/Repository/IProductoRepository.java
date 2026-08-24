package com.ferremex.Ferreteria.Repository;

import com.ferremex.Ferreteria.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
