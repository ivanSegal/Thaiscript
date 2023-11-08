package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "historialPedidos")
public class HistorialPedidos {

    @Id
    @Column(name = "idpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column(name = "idCliente")
    private int idCliente;
    @Column(name = "fechaPedido")
    private String fechaPedido;

    @Column(name = "estadoPedido")
    private String estadoPedido;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "subtotal")
    private String subtotal;

}
