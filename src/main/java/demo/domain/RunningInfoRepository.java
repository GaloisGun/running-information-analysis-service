package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wuyufei on 6/7/17.
 */

@RepositoryRestResource(path = "runningInfo")
public interface RunningInfoRepository extends JpaRepository<RunningInfo, Long >{


    @RestResource(path = "toOutput")
    List<RunningInfo> findAllByHeartRateGreaterThanOrderByHeartRateDesc(int heartRate);

    @RestResource(path = "delete")
    @Transactional
    void deleteRunningInfoByRunningId(String runningId);




}
