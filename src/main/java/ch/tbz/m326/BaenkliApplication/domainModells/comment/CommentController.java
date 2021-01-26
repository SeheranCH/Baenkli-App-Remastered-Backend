package ch.tbz.m326.BaenkliApplication.domainModells.comment;

import ch.tbz.m326.BaenkliApplication.domainModells.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;
    private CommentMapper commentMapper;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable String id) {
        Comment comment = commentService.findById(id);
        return new ResponseEntity<>(commentMapper.toDTO(comment), HttpStatus.OK);
    }

    @GetMapping({"/bench/{id}"})
    public @ResponseBody
    ResponseEntity<List<CommentDTO>> findAllByBenchId(@PathVariable String id) {
        List<Comment> comments = commentService.commentsWithBenchId(id);
        return new ResponseEntity<>(commentMapper.toDTOs(comments), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody
    ResponseEntity<List<CommentDTO>> findAll() {
        List<Comment> comments = commentService.findAll();
        return new ResponseEntity<>(commentMapper.toDTOs(comments), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO) {
        commentDTO = commentMapper.toDTO(commentService.save(commentMapper.fromDTO(commentDTO)));
        return new ResponseEntity<>(commentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateById(@PathVariable String id, @RequestBody CommentDTO commentDTO) {
        Comment comment = commentService.updateById(id, commentMapper.fromDTO(commentDTO));
        return new ResponseEntity<>(commentMapper.toDTO(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
