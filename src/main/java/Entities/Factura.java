package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "factura")
public class Factura {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idFactura")
   private int idFactura;

   @Column(name = "informacionFacturacion", length = 45)
   private String detalleFactura;

   @Column(name = "idpedido")
   private int idPedido;

   @Column(name = "detalleProductos")
   private String detalleProductos;

  // private Date fechaFactura;
}
