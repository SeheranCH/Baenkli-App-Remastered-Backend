package ch.tbz.m326.BaenkliApplication.domainModells.authority.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.authority.Authority;
import ch.tbz.m326.BaenkliApplication.domainModells.authority.AuthorityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AuthorityMapperExtended extends ExtendedDTOMapper<Authority, AuthorityDTO> {
	
}