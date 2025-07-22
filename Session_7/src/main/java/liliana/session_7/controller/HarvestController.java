package liliana.session_7.controller;

import liliana.session_7.entity.Harvest;
import liliana.session_7.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/harvests")
public class HarvestController {
    @Autowired
    private HarvestService harvestService;

    @GetMapping
    public ResponseEntity<List<Harvest>> getAllHarvests() {
        return ResponseEntity.ok(harvestService.getAllHarvests());
    }

    @PostMapping
    public ResponseEntity<Harvest> createHarvest(@RequestBody Harvest harvest) {
        return new ResponseEntity<>(harvestService.addHarvest(harvest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Harvest> getHarvestById(@PathVariable Long id) {
        return ResponseEntity.ok(harvestService.getHarvestById(id));
    }
}
