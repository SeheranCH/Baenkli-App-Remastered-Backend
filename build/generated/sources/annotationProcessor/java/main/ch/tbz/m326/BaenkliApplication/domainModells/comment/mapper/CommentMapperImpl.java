package ch.tbz.m326.BaenkliApplication.domainModells.comment.mapper;

import ch.tbz.m326.BaenkliApplication.domainModells.comment.Comment;
import ch.tbz.m326.BaenkliApplication.domainModells.comment.CommentDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-24T23:49:37+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment fromDTO(CommentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( dto.getId() );
        comment.setUser( dto.getUser() );
        comment.setBench( dto.getBench() );
        comment.setCommentText( dto.getCommentText() );

        return comment;
    }

    @Override
    public List<Comment> fromDTOs(List<CommentDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( dtos.size() );
        for ( CommentDTO commentDTO : dtos ) {
            list.add( fromDTO( commentDTO ) );
        }

        return list;
    }

    @Override
    public Set<Comment> fromDTOs(Set<CommentDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Comment> set = new HashSet<Comment>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( CommentDTO commentDTO : dtos ) {
            set.add( fromDTO( commentDTO ) );
        }

        return set;
    }

    @Override
    public CommentDTO toDTO(Comment dm) {
        if ( dm == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId( dm.getId() );
        commentDTO.setUser( dm.getUser() );
        commentDTO.setBench( dm.getBench() );
        commentDTO.setCommentText( dm.getCommentText() );

        return commentDTO;
    }

    @Override
    public List<CommentDTO> toDTOs(List<Comment> dms) {
        if ( dms == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( dms.size() );
        for ( Comment comment : dms ) {
            list.add( toDTO( comment ) );
        }

        return list;
    }

    @Override
    public Set<CommentDTO> toDTOs(Set<Comment> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<CommentDTO> set = new HashSet<CommentDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( Comment comment : dms ) {
            set.add( toDTO( comment ) );
        }

        return set;
    }
}
