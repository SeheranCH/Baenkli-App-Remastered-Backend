package ch.tbz.m326.BaenkliApplication.domainModells.comment;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;

public class CommentDTO extends ExtendedDTO {

    private User user;

    private Bench bench;

    private String commentText;

    public CommentDTO(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bench getBench() {
        return bench;
    }

    public void setBench(Bench bench) {
        this.bench = bench;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
