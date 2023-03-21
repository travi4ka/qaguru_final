package api.models;

import lombok.Data;

@Data
public class UserModel {
    Integer id, backup, n_movie, n_tv, n_voice, premium, profile, telegram_chat, telegram_id;
    String token, email;
}
