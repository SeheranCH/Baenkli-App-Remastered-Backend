package ch.tbz.m326.BaenkliApplication.domainModells.quiet.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.quiet.Quiet;
import ch.tbz.m326.BaenkliApplication.domainModells.quiet.QuietDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-11T11:05:46+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class QuietMapperImpl implements QuietMapper {

    @Override
    public Quiet fromDTO(QuietDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Quiet quiet = new Quiet();

        quiet.setId( dto.getId() );
        quiet.setQuiet( dto.getQuiet() );

        return quiet;
    }

    @Override
    public List<Quiet> fromDTOs(List<QuietDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Quiet> list = new ArrayList<Quiet>( dtos.size() );
        for ( QuietDTO quietDTO : dtos ) {
            list.add( fromDTO( quietDTO ) );
        }

        return list;
    }

    @Override
    public Set<Quiet> fromDTOs(Set<QuietDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Quiet> set = new HashSet<Quiet>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( QuietDTO quietDTO : dtos ) {
            set.add( fromDTO( quietDTO ) );
        }

        return set;
    }

    @Override
    public QuietDTO toDTO(Quiet dm) {
        if ( dm == null ) {
            return null;
        }

        QuietDTO quietDTO = new QuietDTO();

        quietDTO.setId( dm.getId() );
        quietDTO.setQuiet( dm.getQuiet() );

        return quietDTO;
    }

    @Override
    public List<QuietDTO> toDTOs(List<Quiet> dms) {
        if ( dms == null ) {
            return null;
        }

        List<QuietDTO> list = new ArrayList<QuietDTO>( dms.size() );
        for ( Quiet quiet : dms ) {
            list.add( toDTO( quiet ) );
        }

        return list;
    }

    @Override
    public Set<QuietDTO> toDTOs(Set<Quiet> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<QuietDTO> set = new HashSet<QuietDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( Quiet quiet : dms ) {
            set.add( toDTO( quiet ) );
        }

        return set;
    }
}
