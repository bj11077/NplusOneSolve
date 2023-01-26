package nn.nplusone.company;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nn.nplusone.user.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompanyWithoutFkDto {

    private Long companyId;

    private String companyName;


    public CompanyWithoutFkDto(Company entity){
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
    }


}
