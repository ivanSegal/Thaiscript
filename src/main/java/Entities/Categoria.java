package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="categoria")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categoria {
    @Id
    @Column(name = "idcategoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategoria;

    @Column(name = "nombre")
    private String nombre;

}
