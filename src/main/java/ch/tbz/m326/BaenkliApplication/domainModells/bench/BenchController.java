package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.domainModells.bench.mapper.BenchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benches")
public class BenchController {

    private BenchService benchService;
    private BenchMapper benchMapper;

    @Autowired
    public BenchController(BenchService benchService, BenchMapper benchMapper) {
        this.benchService = benchService;
        this.benchMapper = benchMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenchDTO> findById(@PathVariable String id) {
        Bench bench = benchService.findById(id);
        return new ResponseEntity<>(benchMapper.toDTO(bench), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findAll() {
        List<Bench> benches = benchService.findAll();
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }

    @GetMapping({"/users/{userId}", "/users/{userId}/"})
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findAllByUserId(@PathVariable String userId) {
        List<Bench> benches = benchService.findByUserId(userId);
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }


    @PostMapping({"", "/"})
    public ResponseEntity<BenchDTO> create(@RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.save(benchMapper.fromDTO(benchDTO)));
        return new ResponseEntity<>(benchDTO, HttpStatus.CREATED);
    }

    @PutMapping({"/{benchId}/rating/{ratingId}", "/{benchId}/rating/{ratingId}/"})
    public ResponseEntity<BenchDTO> addRatingToBench(@PathVariable String benchId, @PathVariable String ratingId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addRatingToBench(benchId, ratingId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PutMapping({"/{benchId}/quiet/{quietId}", "/{benchId}/quiet/{quietId}/"})
    public ResponseEntity<BenchDTO> addQuietToBench(@PathVariable String benchId, @PathVariable String quietId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addQuietToBench(benchId, quietId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PutMapping({"/{benchId}/user/{userId}", "/{benchId}/user/{userId}/"})
    public ResponseEntity<BenchDTO> addUserToBench(@PathVariable String benchId, @PathVariable String userId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addUserToBench(benchId, userId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PutMapping({"/{benchId}/address/{addressId}", "/{benchId}/address/{addressId}/"})
    public ResponseEntity<BenchDTO> addAddressToBench(@PathVariable String benchId, @PathVariable String addressId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addAddressToBench(benchId, addressId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenchDTO> updateById(@PathVariable String id, @RequestBody BenchDTO benchDTO) {
        Bench bench = benchService.updateById(id, benchMapper.fromDTO(benchDTO));
        return new ResponseEntity<>(benchMapper.toDTO(bench), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        benchService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Get benches by address
     */
    /**
     *
     * NOT WORKING !!! NEED TO BE FIXED
     */
    @GetMapping("/address/{id}")
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findByAddressId(@PathVariable String id) {
        List<Bench> benches = benchService.findByAddressId(id);
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }

    /**
     * Get benches by longitude and latitude
     */
    /**
     *
     * NOT WORKING !!! NEED TO BE FIXED
     */
    @GetMapping("/{longitude}/{latitude}")
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findByLongitudeLatitude (@PathVariable Double longitude, @PathVariable Double latitude) {
        List<Bench> benches = benchService.findByLongitudeLatitude(longitude, latitude);
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }

}
