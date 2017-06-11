package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by wuyufei on 6/7/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {
    private final String username;
    private String address;

    public UserInfo() {this.username = ""; }
    public UserInfo(String username) {this.username = username; }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
