package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dia_de_entrenamiento")
public class DiaDeEntrenamiento extends Persistente {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dia_de_entrenamiento_ejercicio",
            joinColumns = @JoinColumn(name = "dia_de_entrenamiento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ejercicio_id", referencedColumnName = "id")
    )
    private List<Ejercicio> ejercicios;

    @Column(name = "numero")
    private Integer numero; // representa el orden en la duracion de la rutina.

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rutina_siguiente_id", referencedColumnName = "id")
    private DiaDeEntrenamiento siguienteDia;

    public DiaDeEntrenamiento() {
        this.ejercicios = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        this.ejercicios.add(ejercicio);
    }
}
