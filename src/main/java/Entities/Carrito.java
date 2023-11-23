package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrito")
    private int idCarrito;

    @Column(name = "idcliente")
    private int idCliente;

    @Column(name = "idproducto")
    private int idProducto;

    @Column(name="fecha", length = 45)
    private String fecha;

    @Column(name = "cantidad", length = 45)
    private String cantidad;

    @Column(name = "precio", length = 45)
    private String precio;

    @Column(name = "subtotal", length = 45)
    private String subtotal;
    @OneToMany(mappedBy="carrito", cascade = CascadeType.PERSIST)
    private List<Producto> detalle = new ArrayList<Producto>();
}
