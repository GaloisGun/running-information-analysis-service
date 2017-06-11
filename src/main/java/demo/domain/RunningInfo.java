package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wuyufei on 6/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
@Embeddable
public class RunningInfo {

    public enum HealthWarningLevel {
        LOW, NORMAL, HIGH
    }


    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "userAddress")),
            @AttributeOverride(name = "username", column = @Column(name = "userName"))
    })
    private final UserInfo userInfo;

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private HealthWarningLevel healthWarningLevel = HealthWarningLevel.LOW;
    private Date timestamp = new Date();

    public RunningInfo() {this.userInfo = null; }

    @JsonCreator
    public RunningInfo(@JsonProperty("username") String username) {
        this.userInfo = new UserInfo(username);
    }

    public RunningInfo (UserInfo userInfo) { this.userInfo = userInfo; }

    public String getUsername() {return this.userInfo == null ? null : this.userInfo.getUsername(); }


}
