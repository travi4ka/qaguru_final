package api.responces;

import api.models.UserModel;
import lombok.Data;

@Data
public class GetUserResponse {
    Boolean secuses;
    UserModel user;
}
