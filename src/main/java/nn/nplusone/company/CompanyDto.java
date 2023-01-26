package nn.nplusone.company;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import nn.nplusone.user.User;
import nn.nplusone.user.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDto {

    private Long companyId;

    private String companyName;

    private List<UserDto> users = new ArrayList<>();

    public CompanyDto(Company entity){
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
        this.users = entity.getUsers().stream().map(UserDto::new).collect(Collectors.toList());
    }


}
