package api.responses;

import api.models.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetUserResponse {
    @JsonProperty("secuses")
    Boolean success;
    UserModel user;
}
