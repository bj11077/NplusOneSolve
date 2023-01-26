package nn.nplusone.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nn.nplusone.company.Company;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private Long userId;

    private String userName;

    private String companyName;

    public UserDto(User entity){
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.companyName = entity.getCompany().getCompanyName();
    }


}
