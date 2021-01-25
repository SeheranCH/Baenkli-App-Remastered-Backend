package ch.tbz.m326.BaenkliApplication.domainModells.user.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDTOWithoutPassword;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-25T02:49:50+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperDTOWithoutPasswordImpl implements UserMapperDTOWithoutPassword {

    @Override
    public User fromDTO(UserDTOWithoutPassword dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUsername( dto.getUsername() );
        user.setEmail( dto.getEmail() );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        List<Bench> list = dto.getFavoriteBenches();
        if ( list != null ) {
            user.setFavoriteBenches( new ArrayList<Bench>( list ) );
        }

        return user;
    }

    @Override
    public List<User> fromDTOs(List<UserDTOWithoutPassword> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTOWithoutPassword userDTOWithoutPassword : dtos ) {
            list.add( fromDTO( userDTOWithoutPassword ) );
        }

        return list;
    }

    @Override
    public Set<User> fromDTOs(Set<UserDTOWithoutPassword> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<User> set = new HashSet<User>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( UserDTOWithoutPassword userDTOWithoutPassword : dtos ) {
            set.add( fromDTO( userDTOWithoutPassword ) );
        }

        return set;
    }

    @Override
    public UserDTOWithoutPassword toDTO(User dm) {
        if ( dm == null ) {
            return null;
        }

        UserDTOWithoutPassword userDTOWithoutPassword = new UserDTOWithoutPassword();

        userDTOWithoutPassword.setId( dm.getId() );
        userDTOWithoutPassword.setUsername( dm.getUsername() );
        userDTOWithoutPassword.setEmail( dm.getEmail() );
        userDTOWithoutPassword.setFirstName( dm.getFirstName() );
        userDTOWithoutPassword.setLastName( dm.getLastName() );
        List<Bench> list = dm.getFavoriteBenches();
        if ( list != null ) {
            userDTOWithoutPassword.setFavoriteBenches( new ArrayList<Bench>( list ) );
        }

        return userDTOWithoutPassword;
    }

    @Override
    public List<UserDTOWithoutPassword> toDTOs(List<User> dms) {
        if ( dms == null ) {
            return null;
        }

        List<UserDTOWithoutPassword> list = new ArrayList<UserDTOWithoutPassword>( dms.size() );
        for ( User user : dms ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public Set<UserDTOWithoutPassword> toDTOs(Set<User> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<UserDTOWithoutPassword> set = new HashSet<UserDTOWithoutPassword>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( User user : dms ) {
            set.add( toDTO( user ) );
        }

        return set;
    }
}
