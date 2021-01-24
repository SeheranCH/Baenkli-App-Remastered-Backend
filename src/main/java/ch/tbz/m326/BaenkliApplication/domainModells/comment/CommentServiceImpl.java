package ch.tbz.m326.BaenkliApplication.domainModells.comment;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ExtendedServiceImpl<Comment> implements CommentService {

    public CommentServiceImpl(@Qualifier("commentRepository") ExtendedJpaRepository<Comment> repository) {
        super(repository);
    }

    @Override
    public List<Comment> commentsWithBenchId(String benchId) {
        return ((CommentRepository) repository).findAllByBenchId(benchId);
    }
}
