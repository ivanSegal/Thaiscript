package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int idProducto;

    @Column(name = "idcliente")
    private int idCliente;

    @Column(name = "idcarrito")
    private int idCarrito;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "precio")
    private String precio;

    @Column(name = "subtotal")
    private String subtotal;

}
