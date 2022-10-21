package Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUser {
    private String message;
    private int id;
    private String pic;
    private Role role;
}
