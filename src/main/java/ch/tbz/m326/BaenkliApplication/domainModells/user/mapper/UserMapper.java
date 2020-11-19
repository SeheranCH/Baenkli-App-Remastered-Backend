package ch.tbz.m326.BaenkliApplication.domainModells.user.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ExtendedDTOMapper<User, UserDTO> {

}