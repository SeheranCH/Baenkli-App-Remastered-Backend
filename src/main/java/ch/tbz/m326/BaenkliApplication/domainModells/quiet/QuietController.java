package ch.tbz.m326.BaenkliApplication.domainModells.quiet;

import ch.tbz.m326.BaenkliApplication.domainModells.quiet.mapper.QuietMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiets")
public class QuietController {

    private QuietService quietService;
    private QuietMapper quietMapper;

    @Autowired
    public QuietController(QuietService quietService, QuietMapper quietMapper) {
        this.quietService = quietService;
        this.quietMapper = quietMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuietDTO> findById(@PathVariable String id) {
        Quiet quiet = quietService.findById(id);
        return new ResponseEntity<>(quietMapper.toDTO(quiet), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody
    ResponseEntity<List<QuietDTO>> findAll() {
        List<Quiet> quiets = quietService.findAll();
        return new ResponseEntity<>(quietMapper.toDTOs(quiets), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<QuietDTO> create(@RequestBody QuietDTO quietDTO) {
        quietDTO = quietMapper.toDTO(quietService.save(quietMapper.fromDTO(quietDTO)));
        return new ResponseEntity<>(quietDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuietDTO> updateById(@PathVariable String id, @RequestBody QuietDTO quietDTO) {
        Quiet quiet = quietService.updateById(id, quietMapper.fromDTO(quietDTO));
        return new ResponseEntity<>(quietMapper.toDTO(quiet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        quietService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
