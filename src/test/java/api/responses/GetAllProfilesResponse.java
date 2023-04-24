package api.responses;

import api.models.ProfileModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GetAllProfilesResponse {
    @JsonProperty("secuses")
    Boolean success;
    ArrayList<ProfileModel> profiles;
}
