package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wuyufei on 6/11/17.
 */
@RepositoryRestResource(path = "results")
public interface OutputRepository extends JpaRepository<Output, Long> {

    @RestResource(path = "run")
    Page<Output> findAllByHeartRateGreaterThanOrderByHeartRateDesc(@Param("heartRate") int heartRate, Pageable pageable);

    @RestResource(path = "delete")
    @Transactional
    void deleteRunningInfoByRunningId(String runningId);
}
