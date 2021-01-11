package ch.tbz.m326.BaenkliApplication.domainModells.bench.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.BenchDTO;
import ch.tbz.m326.BaenkliApplication.domainModells.quiet.Quiet;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.Rating;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-11T14:21:26+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class BenchMapperImpl implements BenchMapper {

    @Override
    public Bench fromDTO(BenchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Bench bench = new Bench();

        bench.setId( dto.getId() );
        bench.setTitle( dto.getTitle() );
        bench.setDescription( dto.getDescription() );
        bench.setLatitude( dto.getLatitude() );
        bench.setLongitude( dto.getLongitude() );
        bench.setAmountBenches( dto.getAmountBenches() );
        bench.setAmountFirePlaces( dto.getAmountFirePlaces() );
        bench.setAmountTrashCans( dto.getAmountTrashCans() );
        bench.setDistanceToNextShop( dto.getDistanceToNextShop() );
        bench.setDirections( dto.getDirections() );
        bench.setHasMeadow( dto.isHasMeadow() );
        bench.setLocationOnWater( dto.isLocationOnWater() );
        bench.setAddress( dto.getAddress() );
        bench.setUser( dto.getUser() );
        Set<Rating> set = dto.getRatings();
        if ( set != null ) {
            bench.setRatings( new HashSet<Rating>( set ) );
        }
        Set<Quiet> set1 = dto.getQuiets();
        if ( set1 != null ) {
            bench.setQuiets( new HashSet<Quiet>( set1 ) );
        }

        return bench;
    }

    @Override
    public List<Bench> fromDTOs(List<BenchDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Bench> list = new ArrayList<Bench>( dtos.size() );
        for ( BenchDTO benchDTO : dtos ) {
            list.add( fromDTO( benchDTO ) );
        }

        return list;
    }

    @Override
    public Set<Bench> fromDTOs(Set<BenchDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Bench> set = new HashSet<Bench>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( BenchDTO benchDTO : dtos ) {
            set.add( fromDTO( benchDTO ) );
        }

        return set;
    }

    @Override
    public BenchDTO toDTO(Bench dm) {
        if ( dm == null ) {
            return null;
        }

        BenchDTO benchDTO = new BenchDTO();

        benchDTO.setId( dm.getId() );
        benchDTO.setTitle( dm.getTitle() );
        benchDTO.setDescription( dm.getDescription() );
        benchDTO.setLongitude( dm.getLongitude() );
        benchDTO.setLatitude( dm.getLatitude() );
        benchDTO.setAmountBenches( dm.getAmountBenches() );
        benchDTO.setAmountFirePlaces( dm.getAmountFirePlaces() );
        benchDTO.setAmountTrashCans( dm.getAmountTrashCans() );
        benchDTO.setDistanceToNextShop( dm.getDistanceToNextShop() );
        benchDTO.setDirections( dm.getDirections() );
        benchDTO.setHasMeadow( dm.isHasMeadow() );
        benchDTO.setLocationOnWater( dm.isLocationOnWater() );
        benchDTO.setAddress( dm.getAddress() );
        benchDTO.setUser( dm.getUser() );
        Set<Rating> set = dm.getRatings();
        if ( set != null ) {
            benchDTO.setRatings( new HashSet<Rating>( set ) );
        }
        Set<Quiet> set1 = dm.getQuiets();
        if ( set1 != null ) {
            benchDTO.setQuiets( new HashSet<Quiet>( set1 ) );
        }

        return benchDTO;
    }

    @Override
    public List<BenchDTO> toDTOs(List<Bench> dms) {
        if ( dms == null ) {
            return null;
        }

        List<BenchDTO> list = new ArrayList<BenchDTO>( dms.size() );
        for ( Bench bench : dms ) {
            list.add( toDTO( bench ) );
        }

        return list;
    }

    @Override
    public Set<BenchDTO> toDTOs(Set<Bench> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<BenchDTO> set = new HashSet<BenchDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( Bench bench : dms ) {
            set.add( toDTO( bench ) );
        }

        return set;
    }
}
