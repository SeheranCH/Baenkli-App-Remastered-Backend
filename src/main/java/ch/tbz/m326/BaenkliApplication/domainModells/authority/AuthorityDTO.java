package ch.tbz.m326.BaenkliApplication.domainModells.authority;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;

import javax.validation.constraints.NotNull;

public class AuthorityDTO extends ExtendedDTO {

	private String id;

	@NotNull
	private String name;

	public AuthorityDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public AuthorityDTO setName(String name) {
		this.name = name;
		return this;
	}
}
