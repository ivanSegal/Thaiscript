package com.example.spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @Column(name = "idcomprobante")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComprobante;

    // @Column(name = "idpedido")
    // private Long idPedido;

    @Column(name = "detalleproductos")
    private String detalleProductos;
    @Column(name = "informaciondefacturacion")
    private String informacionFacturacion;
    
    

}
