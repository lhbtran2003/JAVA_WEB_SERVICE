package liliana.session_7.controller;

import liliana.session_7.entity.Seed;
import liliana.session_7.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seeds")
public class SeedController {
    @Autowired
    private SeedService seedService;

    @GetMapping
    public ResponseEntity<List<Seed>> getAllSeeds() {
        return ResponseEntity.ok(seedService.getAllSeeds());
    }

    @PostMapping
    public ResponseEntity<Seed> createSeed(@RequestBody Seed seed) {
        return new ResponseEntity<>(seedService.addSeed(seed), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed, @PathVariable long id) {
        return new ResponseEntity<>(seedService.updateSeed(id, seed), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeed(@PathVariable long id) {
        seedService.deleteSeed(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
