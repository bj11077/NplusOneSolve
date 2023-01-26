package nn.nplusone.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nn.nplusone.company.Company;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "tb_user")
public class User {

    @Id
    private Long userId;

    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

}
