package ch.tbz.m326.BaenkliApplication.domainModells.comment.mapper;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTOMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.comment.Comment;
import ch.tbz.m326.BaenkliApplication.domainModells.comment.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper extends ExtendedDTOMapper<Comment, CommentDTO> {
}
