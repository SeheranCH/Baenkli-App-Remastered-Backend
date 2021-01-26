package ch.tbz.m326.BaenkliApplication.domainModells.comment;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedService;

import java.util.List;

public interface CommentService extends ExtendedService<Comment> {

    List<Comment> commentsWithBenchId (String benchId);
}
