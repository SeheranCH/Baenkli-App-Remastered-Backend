package ch.tbz.m326.BaenkliApplication.domainModells.rating.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.rating.Rating;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.RatingDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-19T14:02:25+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public Rating fromDTO(RatingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rating rating = new Rating();

        rating.setId( dto.getId() );
        rating.setRating( dto.getRating() );

        return rating;
    }

    @Override
    public List<Rating> fromDTOs(List<RatingDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Rating> list = new ArrayList<Rating>( dtos.size() );
        for ( RatingDTO ratingDTO : dtos ) {
            list.add( fromDTO( ratingDTO ) );
        }

        return list;
    }

    @Override
    public Set<Rating> fromDTOs(Set<RatingDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Rating> set = new HashSet<Rating>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( RatingDTO ratingDTO : dtos ) {
            set.add( fromDTO( ratingDTO ) );
        }

        return set;
    }

    @Override
    public RatingDTO toDTO(Rating dm) {
        if ( dm == null ) {
            return null;
        }

        RatingDTO ratingDTO = new RatingDTO();

        ratingDTO.setId( dm.getId() );
        ratingDTO.setRating( dm.getRating() );

        return ratingDTO;
    }

    @Override
    public List<RatingDTO> toDTOs(List<Rating> dms) {
        if ( dms == null ) {
            return null;
        }

        List<RatingDTO> list = new ArrayList<RatingDTO>( dms.size() );
        for ( Rating rating : dms ) {
            list.add( toDTO( rating ) );
        }

        return list;
    }

    @Override
    public Set<RatingDTO> toDTOs(Set<Rating> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<RatingDTO> set = new HashSet<RatingDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( Rating rating : dms ) {
            set.add( toDTO( rating ) );
        }

        return set;
    }
}
