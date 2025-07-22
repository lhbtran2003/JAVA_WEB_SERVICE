package liliana.session_7.service;

import liliana.session_7.entity.Seed;
import liliana.session_7.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedService {
    @Autowired
    private SeedRepository seedRepository;

    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }
    public Seed getSeedById(Long id) {
        return seedRepository.findById(id).orElse(null);
    }
    public Seed addSeed(Seed seed) {
        return seedRepository.save(seed);
    }
    public Seed updateSeed(Long id, Seed seed) {
        if (!seedRepository.existsById(id)) {
            return null;
        }
        Seed oldSeed = getSeedById(id);
        oldSeed.setSeedName(seed.getSeedName());
        oldSeed.setQuantity(seed.getQuantity());
        return seedRepository.save(oldSeed);
    }
    public void deleteSeed(Long id) {
        seedRepository.deleteById(id);
    }
}
