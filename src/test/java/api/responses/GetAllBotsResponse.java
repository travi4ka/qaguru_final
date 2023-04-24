package api.responses;

import api.models.BotModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GetAllBotsResponse {
    @JsonProperty("secuses")
    Boolean success;
    ArrayList<BotModel> bots;
}
