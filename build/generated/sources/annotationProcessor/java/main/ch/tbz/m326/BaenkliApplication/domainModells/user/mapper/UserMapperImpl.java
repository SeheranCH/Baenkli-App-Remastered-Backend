package ch.tbz.m326.BaenkliApplication.domainModells.user.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-12T01:42:00+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDTO(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUsername( dto.getUsername() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );

        return user;
    }

    @Override
    public List<User> fromDTOs(List<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTO userDTO : dtos ) {
            list.add( fromDTO( userDTO ) );
        }

        return list;
    }

    @Override
    public Set<User> fromDTOs(Set<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<User> set = new HashSet<User>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : dtos ) {
            set.add( fromDTO( userDTO ) );
        }

        return set;
    }

    @Override
    public UserDTO toDTO(User dm) {
        if ( dm == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( dm.getId() );
        userDTO.setUsername( dm.getUsername() );
        userDTO.setEmail( dm.getEmail() );
        userDTO.setPassword( dm.getPassword() );
        userDTO.setFirstName( dm.getFirstName() );
        userDTO.setLastName( dm.getLastName() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTOs(List<User> dms) {
        if ( dms == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( dms.size() );
        for ( User user : dms ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public Set<UserDTO> toDTOs(Set<User> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<UserDTO> set = new HashSet<UserDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( User user : dms ) {
            set.add( toDTO( user ) );
        }

        return set;
    }
}
