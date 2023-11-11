package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pedido")
public class Pedido {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idpedido" )
  private Long  id_pedido;

@Column(name = "estadopedido")
private  String estadoPedido;

@Column(name = "cantidad")
private String cantidad;

@Column(name = "subtotal")
private String subtotal;
/*
@Column(name = "idproducto")
private int id_producto;


@Column(name = "idcliente")
private int  id_cliente;
*/
@Column(name = "fechapedido")
private Date fechapedido;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name= "fk_cliente")
private Cliente cliente;

@OneToMany(cascade = CascadeType.ALL) // orphanRemoval=true
@JoinTable(
		name="pedido_producto",
		joinColumns= @JoinColumn(name= "pedido_id"),
		inverseJoinColumns = @JoinColumn(name= "producto_id"))
private List<Producto> productos = new ArrayList<Producto>();

@OneToMany(cascade = CascadeType.ALL)
@JoinTable(
name="pedido_comprobante",
		joinColumns= @JoinColumn(name= "pedido_id"),
		inverseJoinColumns = @JoinColumn(name= "comprobante_id"))
private List<Comprobante> comprobantes = new ArrayList<Comprobante>();

}
