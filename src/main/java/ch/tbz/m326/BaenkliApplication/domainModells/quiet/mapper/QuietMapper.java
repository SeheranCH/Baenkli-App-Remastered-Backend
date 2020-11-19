package ch.tbz.m326.BaenkliApplication.domainModells.quiet.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;

import ch.tbz.m326.BaenkliApplication.domainModells.quiet.Quiet;
import ch.tbz.m326.BaenkliApplication.domainModells.quiet.QuietDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuietMapper extends ExtendedDTOMapper<Quiet, QuietDTO> {
}
