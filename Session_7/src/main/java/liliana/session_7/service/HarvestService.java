package liliana.session_7.service;

import liliana.session_7.entity.Harvest;
import liliana.session_7.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestService {
    @Autowired
    private HarvestRepository harvestRepository;

    public List<Harvest> getAllHarvests() {
        return harvestRepository.findAll();
    }
    public Harvest getHarvestById(Long id) {
        return harvestRepository.findById(id).orElse(null);
    }
    public Harvest addHarvest(Harvest harvest) {
        return harvestRepository.save(harvest);
    }
}
