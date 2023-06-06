package by.remprofi.controller.rest;

import by.remprofi.domain.hiber.HiberPark;
import by.remprofi.repository.hiber.HiberParkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/hibernate/park")
@RequiredArgsConstructor
public class ParkController {

    private final HiberParkRepository locationRepository;

    @GetMapping
    public ResponseEntity<Object> getAllLocations() {
        List<HiberPark> locations = locationRepository.findAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
