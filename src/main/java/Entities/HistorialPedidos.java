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
    private Long idPedido;

    @Column(name = "idCliente")
    private Long idCliente;
    
    @Column(name = "fechaPedido")
    private String fechaPedido;

    @Column(name = "estadoPedido")
    private String estadoPedido;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "subtotal")
    private String subtotal;

    //No sé si la relación debe ser bidireccional o no, así que comento -Nick
    //Relación Bidireccional OneToOne con Cliente
    //@OneToOne(mappedBy = "historialPedidos")
    //private Cliente cliente;
}
