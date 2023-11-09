package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    
    @ManyToMany(mappedBy = "categorias")
    private List <Producto> productos = new ArrayList<Producto>();

}
