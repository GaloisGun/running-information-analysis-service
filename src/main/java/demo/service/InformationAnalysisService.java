package demo.service;


import demo.domain.Output;
import demo.domain.RunningInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by wuyufei on 6/8/17.
 */

public interface InformationAnalysisService {

    List<RunningInfo> saveRunningInfos(List<RunningInfo> runningInfos);

    void deleteRunningInfoByRunningId(String runningId);

    Page<Output> findAllByHeartRateGreaterThanOrderByHeartRateDesc(int heartRate, Pageable pageable);


}
