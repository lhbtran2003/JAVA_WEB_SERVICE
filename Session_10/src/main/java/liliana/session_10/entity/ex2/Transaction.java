package liliana.session_10.entity.ex2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import liliana.session_10.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Transaction {
    @Id
    private String id;

    @ManyToOne
    private Account receiver;

    @ManyToOne
    private Account sender;

    private Double money;
    private String status;
    private LocalDateTime createdAt;
}
