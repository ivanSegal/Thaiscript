package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "detallePedido")
public class DetallePedido {
    @Id
    @Column(name = "idcomprobante")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComprobante;
    @Column(name = "idpedido")
    private Long idPedido;
    
    //Esto agregue
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_producto")

    private Producto producto;
    @Column(name = "informaciondefacturacion")
    private String informacionFacturacion;
}
