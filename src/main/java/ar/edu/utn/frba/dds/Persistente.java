package ar.edu.utn.frba.dds;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persistente {

    @Id
    @GeneratedValue
    private Long id;
}
