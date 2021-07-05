package pl.sidor.movierentaldemo.entity.base;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@MappedSuperclass
public abstract class BaseEntity<PK extends Number> implements Serializable {

    private static final long serialVersionUID = -6753213374605045274L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PK id;
}
