package api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserModel {
    Integer id, backup, premium, profile;
    @JsonProperty("n_movie")
    Integer nMovie;
    @JsonProperty("n_tv")
    Integer nTv;
    @JsonProperty("n_voice")
    Integer nVoice;
    @JsonProperty("telegram_chat")
    Integer telegramChat;
    @JsonProperty("telegram_id")
    Integer telegramId;
    String token, email;
}
