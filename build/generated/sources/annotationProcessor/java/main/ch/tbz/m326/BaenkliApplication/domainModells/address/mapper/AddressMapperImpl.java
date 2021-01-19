package ch.tbz.m326.BaenkliApplication.domainModells.address.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.address.Address;
import ch.tbz.m326.BaenkliApplication.domainModells.address.AddressDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-18T16:16:54+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address fromDTO(AddressDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( dto.getId() );
        address.setStreet( dto.getStreet() );
        address.setZip( dto.getZip() );
        address.setPlace( dto.getPlace() );

        return address;
    }

    @Override
    public List<Address> fromDTOs(List<AddressDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( dtos.size() );
        for ( AddressDTO addressDTO : dtos ) {
            list.add( fromDTO( addressDTO ) );
        }

        return list;
    }

    @Override
    public Set<Address> fromDTOs(Set<AddressDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Address> set = new HashSet<Address>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( AddressDTO addressDTO : dtos ) {
            set.add( fromDTO( addressDTO ) );
        }

        return set;
    }

    @Override
    public AddressDTO toDTO(Address dm) {
        if ( dm == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( dm.getId() );
        addressDTO.setStreet( dm.getStreet() );
        addressDTO.setZip( dm.getZip() );
        addressDTO.setPlace( dm.getPlace() );

        return addressDTO;
    }

    @Override
    public List<AddressDTO> toDTOs(List<Address> dms) {
        if ( dms == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( dms.size() );
        for ( Address address : dms ) {
            list.add( toDTO( address ) );
        }

        return list;
    }

    @Override
    public Set<AddressDTO> toDTOs(Set<Address> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<AddressDTO> set = new HashSet<AddressDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( Address address : dms ) {
            set.add( toDTO( address ) );
        }

        return set;
    }
}
