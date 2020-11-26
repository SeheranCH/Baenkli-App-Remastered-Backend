package ch.tbz.m326.BaenkliApplication.domainModells.role;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;
import ch.tbz.m326.BaenkliApplication.domainModells.authority.Authority;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends ExtendedEntity {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Generated(GenerationTime.ALWAYS)
  @Column(name = "id")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinTable(
          name = "role_authority",
          joinColumns = @JoinColumn(name = "role_id"),
          inverseJoinColumns = @JoinColumn(name = "authority_id")
  )
  private Set<Authority> authorities;

  public Role() {
    super();
  }

  public String getId() {
    return id;
  }

  public Role setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Role setName(String name) {
    this.name = name;
    return this;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  public Role setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }
}
