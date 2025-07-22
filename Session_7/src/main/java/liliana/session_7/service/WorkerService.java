package liliana.session_7.service;

import liliana.session_7.entity.Worker;
import liliana.session_7.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }
    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id).orElse(null);
    }
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }
    public Worker updateWorker(Long id, Worker worker) {
        if (!workerRepository.existsById(id)) {
            return null;
        }
        return workerRepository.save(worker);
    }
    public void deleteWorker(Long id) {
         workerRepository.deleteById(id);
    }
}
