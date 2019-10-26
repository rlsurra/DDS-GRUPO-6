package ar.edu.utn.frba.dds.model.categoria;


import javax.persistence.*;

@Entity
@Table
public abstract class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
