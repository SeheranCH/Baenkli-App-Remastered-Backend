package ch.tbz.m326.BaenkliApplication.domainModells.role.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.role.Role;
import ch.tbz.m326.BaenkliApplication.domainModells.role.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface RoleMapperExtended extends ExtendedDTOMapper<Role, RoleDTO> {
	
}
