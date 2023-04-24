package api.models;

import lombok.Data;

@Data
public class IptvModel {
    Integer id, cid, status;
    String url, name, profiles;
}
