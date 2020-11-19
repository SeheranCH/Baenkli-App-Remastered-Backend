package ch.tbz.m326.BaenkliApplication.domainModells.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface RoleMapper {
}
