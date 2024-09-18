package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ejercicio")
public class Ejercicio extends Persistente {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "detalle", columnDefinition = "TEXT")
    private String detalle;
}
