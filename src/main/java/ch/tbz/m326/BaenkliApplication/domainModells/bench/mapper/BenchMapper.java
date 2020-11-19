package ch.tbz.m326.BaenkliApplication.domainModells.bench.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.BenchDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BenchMapper extends ExtendedDTOMapper<Bench, BenchDTO> {

}
