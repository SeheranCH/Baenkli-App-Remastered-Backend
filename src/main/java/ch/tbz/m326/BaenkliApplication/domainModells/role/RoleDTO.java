package ch.tbz.m326.BaenkliApplication.domainModells.role;


import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;
import ch.tbz.m326.BaenkliApplication.domainModells.authority.AuthorityDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class RoleDTO extends ExtendedDTO {

  private String id;

  @NotNull
  @Size(min = 1, max = 255)
  private String name;

  private Set<AuthorityDTO> authorities;

  public RoleDTO() {
  }

  public String getName() {
    return name;
  }

  public RoleDTO setName(String name) {
    this.name = name;
    return this;
  }

  public Set<AuthorityDTO> getAuthorities() {
    return authorities;
  }

  public RoleDTO setAuthorities(Set<AuthorityDTO> authorities) {
    this.authorities = authorities;
    return this;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
