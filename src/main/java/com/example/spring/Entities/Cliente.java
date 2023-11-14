package com.example.spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idCliente")
    private Long idCliente;

    @Column( name="Nombre", length = 45)
    private String nombre;

    @Column( name="Mail", length = 45)
    private String mail;

    @Column( name="Telefono", length = 45)
    private String telefono;

    @Column(name = "Contrasenia", length = 45)
    private String contrasenia;

    @Column(name = "FechadeRegistro", length = 45)
    private String fechaRegistro;

    //Relación OneToOne con HistorialPedidos
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_historialPedidos")
    private HistorialPedidos historialPedidos;

    //No sé si la relación debe ser bidireccional o si se volverá ManyToOne, así que comento -Nick
    //Relación Bidireccional OneToOne con Pedido
    //@OneToOne(mappedBy = "cliente")
    //private Pedido pedido;
}
