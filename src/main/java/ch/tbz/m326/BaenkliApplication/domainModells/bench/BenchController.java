package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.security.util.JwtUtil;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.mapper.BenchMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/benches")
public class BenchController {

    private BenchService benchService;
    private BenchMapper benchMapper;
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public BenchController(BenchService benchService, BenchMapper benchMapper, UserService userService) {
        this.benchService = benchService;
        this.benchMapper = benchMapper;
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('B_SEE_ALL')")
    @GetMapping("/{id}")
    public ResponseEntity<BenchDTO> findById(@PathVariable String id) {
        Bench bench = benchService.findById(id);
        return new ResponseEntity<>(benchMapper.toDTO(bench), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('B_SEE_ALL')")
    @GetMapping({"", "/"})
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findAll() {
        List<Bench> benches = benchService.findAll();
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('B_CREATE')")
    @PostMapping({"", "/"})
    public ResponseEntity<BenchDTO> create(@RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.save(benchMapper.fromDTO(benchDTO)));
        return new ResponseEntity<>(benchDTO, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('B_UPDATE_GLOBAL')")
    @PutMapping({"/{benchId}/rating/{ratingId}", "/{benchId}/rating/{ratingId}/"})
    public ResponseEntity<BenchDTO> addRatingToBench(@PathVariable String benchId, @PathVariable String ratingId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addRatingToBench(benchId, ratingId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USERS_UPDATE_GLOBAL')")
    @PutMapping({"/{benchId}/quiet/{quietId}", "/{benchId}/quiet/{quietId}/"})
    public ResponseEntity<BenchDTO> addQuietToBench(@PathVariable String benchId, @PathVariable String quietId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addQuietToBench(benchId, quietId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('B_UPDATE_GLOBAL')")
    @PutMapping({"/{benchId}/user/{userId}", "/{benchId}/user/{userId}/"})
    public ResponseEntity<BenchDTO> addUserToBench(@PathVariable String benchId, @PathVariable String userId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addUserToBench(benchId, userId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('B_UPDATE_GLOBAL')")
    @PutMapping({"/{benchId}/address/{addressId}", "/{benchId}/address/{addressId}/"})
    public ResponseEntity<BenchDTO> addAddressToBench(@PathVariable String benchId, @PathVariable String addressId, @RequestBody BenchDTO benchDTO) {
        benchDTO = benchMapper.toDTO(benchService.addAddressToBench(benchId, addressId));
        return new ResponseEntity<>(benchDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('B_UPDATE_GLOBAL')")
    @PutMapping("/{id}")
    public ResponseEntity<BenchDTO> updateById(@PathVariable String id, @RequestBody BenchDTO benchDTO) {
        Bench bench = benchService.updateById(id, benchMapper.fromDTO(benchDTO));
        return new ResponseEntity<>(benchMapper.toDTO(bench), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('B_DELETE_OWN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnById(@PathVariable String id,  @RequestHeader(name = "Authorization") @NotNull String token) {
            if(benchService.findById(id).getUser().getId().equals(userService.findByUsername(jwtUtil.extractUsername(token)))) {
                benchService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
    }

    @PreAuthorize("hasAuthority('B_DELETE_GLOBAL')")
    @DeleteMapping("admin/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        benchService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Get benches by address
     */
    @PreAuthorize("hasAuthority('B_SEE_ALL')")
    @GetMapping("/address/{id}")
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findByAddressId(@PathVariable String id) {
        List<Bench> benches = benchService.findByAddressId(id);
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }

    /**
     * Get benches by longitude and latitude
     */
    @PreAuthorize("hasAuthority('B_SEE_ALL')")
    @GetMapping("/{longitude}/{latitude}")
    public @ResponseBody
    ResponseEntity<List<BenchDTO>> findByLongitudeLatitude (@PathVariable Double longitude, @PathVariable Double latitude) {
        List<Bench> benches = benchService.findByLongitudeLatitude(longitude, latitude);
        return new ResponseEntity<>(benchMapper.toDTOs(benches), HttpStatus.OK);
    }

}
