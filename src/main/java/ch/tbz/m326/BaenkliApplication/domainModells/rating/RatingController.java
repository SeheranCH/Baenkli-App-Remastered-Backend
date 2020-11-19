package ch.tbz.m326.BaenkliApplication.domainModells.rating;

import ch.tbz.m326.BaenkliApplication.domainModells.rating.mapper.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private RatingService ratingService;
    private RatingMapper ratingMapper;

    @Autowired
    public RatingController(RatingService ratingService, RatingMapper ratingMapper) {
        this.ratingService = ratingService;
        this.ratingMapper = ratingMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDTO> findById(@PathVariable String id) {
        Rating rating = ratingService.findById(id);
        return new ResponseEntity<>(ratingMapper.toDTO(rating), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody
    ResponseEntity<List<RatingDTO>> findAll() {
        List<Rating> ratings = ratingService.findAll();
        return new ResponseEntity<>(ratingMapper.toDTOs(ratings), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<RatingDTO> create(@RequestBody RatingDTO ratingDTO) {
        ratingDTO = ratingMapper.toDTO(ratingService.save(ratingMapper.fromDTO(ratingDTO)));
        return new ResponseEntity<>(ratingDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingDTO> updateById(@PathVariable String id, @RequestBody RatingDTO ratingDTO) {
        Rating rating = ratingService.updateById(id, ratingMapper.fromDTO(ratingDTO));
        return new ResponseEntity<>(ratingMapper.toDTO(rating), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        ratingService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
