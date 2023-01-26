package nn.nplusone.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserWithoutFkDto {

    private Long userId;

    private String userName;


    public UserWithoutFkDto(User entity){
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
    }


}
