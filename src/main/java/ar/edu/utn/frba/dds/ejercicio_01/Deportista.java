package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.Persistente;
import ar.edu.utn.frba.dds.converters.MotivacionConverter;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "deportista")
public class Deportista extends Persistente {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ElementCollection
    @CollectionTable(name = "contacto_persona", joinColumns = @JoinColumn(name = "deportista_id", referencedColumnName = "id"))
    @Column(name = "contacto")
    private List<String> contactos;

    @Convert(converter = MotivacionConverter.class)
    private Motivacion motivacionPrincipal;

    @Column(name = "peso_inicial_en_kilos")
    private Double pesoInicialEnKilos;

    public void agregarContacto(String contacto) {
        contactos.add(contacto);
    }

    public Deportista(){
        this.contactos = new ArrayList<>();
    }

}
