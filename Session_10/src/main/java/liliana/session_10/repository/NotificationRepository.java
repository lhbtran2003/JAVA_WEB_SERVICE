package liliana.session_10.repository;

import liliana.session_10.entity.ex2.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
