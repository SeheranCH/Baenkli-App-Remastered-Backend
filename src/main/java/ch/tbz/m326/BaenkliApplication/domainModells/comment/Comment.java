package ch.tbz.m326.BaenkliApplication.domainModells.comment;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment extends ExtendedEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bench_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bench bench;

    @Column(name = "comment_text")
    private String commentText;

    public Comment () {}

    public Comment(String id) {
        super(id);
    }

    public Comment(User user, Bench bench, String commentText) {
        this.user = user;
        this.bench = bench;
        this.commentText = commentText;
    }

    public Comment(String id, User user, Bench bench, String commentText) {
        super(id);
        this.user = user;
        this.bench = bench;
        this.commentText = commentText;
    }

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
