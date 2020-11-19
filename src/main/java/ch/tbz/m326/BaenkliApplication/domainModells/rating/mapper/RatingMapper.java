package ch.tbz.m326.BaenkliApplication.domainModells.rating.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.Rating;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.RatingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RatingMapper extends ExtendedDTOMapper<Rating, RatingDTO> {

}
