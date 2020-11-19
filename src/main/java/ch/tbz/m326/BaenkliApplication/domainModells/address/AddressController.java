package ch.tbz.m326.BaenkliApplication.domainModells.address;

import ch.tbz.m326.BaenkliApplication.domainModells.address.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;
    private AddressMapper addressMapper;

    @Autowired
    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable String id) {
        Address address = addressService.findById(id);
        return new ResponseEntity<>(addressMapper.toDTO(address), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody
    ResponseEntity<List<AddressDTO>> findAll() {
        List<Address> addresses = addressService.findAll();
        return new ResponseEntity<>(addressMapper.toDTOs(addresses), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) {
        addressDTO = addressMapper.toDTO(addressService.save(addressMapper.fromDTO(addressDTO)));
        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateById(@PathVariable String id, @RequestBody AddressDTO addressDTO) {
        Address address = addressService.updateById(id, addressMapper.fromDTO(addressDTO));
        return new ResponseEntity<>(addressMapper.toDTO(address), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
