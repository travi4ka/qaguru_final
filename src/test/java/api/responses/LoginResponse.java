package api.responses;

import api.models.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {
    @JsonProperty("secuses")
    Boolean success;
    UserModel user;
}
