package ch.tbz.m326.BaenkliApplication.domainModells.user.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDTOWithoutPassword;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapperDTOWithoutPassword extends ExtendedDTOMapper<User, UserDTOWithoutPassword> {
}
