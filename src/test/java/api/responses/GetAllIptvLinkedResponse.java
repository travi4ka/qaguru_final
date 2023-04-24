package api.responses;

import api.models.IptvModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GetAllIptvLinkedResponse {
    @JsonProperty("secuses")
    Boolean success;
    ArrayList<IptvModel> iptv;
}
