package Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idCliente")
    private int idCliente;

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

}
