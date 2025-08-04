package liliana.session_10.entity.ex2;

import jakarta.persistence.*;
import liliana.session_10.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter@Getter
@Entity
public class Notification {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String content;
    private String status;
    private LocalDateTime createdAt;

}
