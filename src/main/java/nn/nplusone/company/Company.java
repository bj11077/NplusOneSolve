package nn.nplusone.company;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nn.nplusone.user.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "tb_company")
public class Company {

    @Id
    private Long companyId;

    private String companyName;


    @OneToMany(mappedBy = "company")
    private List<User> users = new ArrayList<>();

}
