package api.responces;

import api.models.ProfileModel;
import lombok.Data;

@Data
public class ProfilesAllResponse {
    Boolean secuses;
    ProfileModel[] profiles;
}
