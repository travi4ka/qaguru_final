package api.responces;

import api.models.UserModel;
import lombok.Data;

@Data
public class LoginResponse {
    Boolean secuses;
    UserModel user;
}
