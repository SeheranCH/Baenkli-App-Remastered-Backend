package ch.tbz.m326.BaenkliApplication.domainModells.authority;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Generated(GenerationTime.ALWAYS)
  @Column(name = "id")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  public Authority() {
    super();
  }

  public String getId() {
    return id;
  }

  public Authority setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Authority setName(String name) {
    this.name = name;
    return this;
  }
}
