package demo.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wuyufei on 6/11/17.
 */
@Data
@Entity
@Embeddable
public class Output {
    private String runningId;
    private double totalRunningTime;
    private int heartRate = 0;

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "userAddress")),
            @AttributeOverride(name = "username", column = @Column(name = "userName"))
    })
    private final UserInfo userInfo;

    private RunningInfo.HealthWarningLevel healthWarningLevel = RunningInfo.HealthWarningLevel.LOW;

    public Output() { this.userInfo = null; }
    public Output(UserInfo userInfo){
        this.userInfo = userInfo;
    }
}
