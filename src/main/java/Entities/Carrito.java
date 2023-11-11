package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrito")
    private Long idCarrito;

    @Column(name = "idcliente") //usuario
    private Long idCliente;
    //hardcarrito onetomany
    @OneToMany(mappedBy="carrito", cascade = CascadeType.PERSIST)
    private List<DetallePedido> detalle = new ArrayList<DetallePedido>();

    @Column(name = "idproducto") //producto
    private Long idProducto;

    @Column(name="fecha", length = 45)
    private String fecha;

    @Column(name = "cantidad", length = 45)
    private String cantidad;

    @Column(name = "precio", length = 45)
    private String precio;

    @Column(name = "subtotal", length = 45)
    private String subtotal;
}
