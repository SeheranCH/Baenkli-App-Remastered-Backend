package ch.tbz.m326.BaenkliApplication.domainModells.address.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.address.Address;
import ch.tbz.m326.BaenkliApplication.domainModells.address.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper extends ExtendedDTOMapper<Address, AddressDTO> {
}
