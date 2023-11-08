package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pedido")
public class Pedido {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idpedido" )
  private int  id_pedido;

@Column(name = "estadopedido")
private  String estadoPedido;

@Column(name = "cantidad")
private String cantidad;

@Column(name = "subtotal")
private String subtotal;

@Column(name = "idproducto")
private int id_producto;

@Column(name = "idcliente")
private int  id_cliente;

@Column(name = "fechapedido")
private Date fechapedido;

    //  @Column(name = "idhistorial" )
    // private int  id_historial;
//  @Column(name = "")
//    private int  id_detallePedido;
}
