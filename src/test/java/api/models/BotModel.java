package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BotModel {
    Integer id, cid, profile, movie, tv, voice;
    @JsonProperty("chat_id")
    Integer chatId;
    @JsonProperty("nikname")
    String nickName;
}
