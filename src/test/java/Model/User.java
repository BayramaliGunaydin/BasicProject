package Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
 private int id;
 private String username;
 private String pic;
 private Role role;
}
