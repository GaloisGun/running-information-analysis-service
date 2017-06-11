package demo.service.impl;

import demo.domain.Output;
import demo.domain.OutputRepository;
import demo.domain.RunningInfo;
import demo.domain.RunningInfoRepository;
import demo.service.InformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wuyufei on 6/9/17.
 */
@Service
public class InformationAnalysisServiceImpl implements InformationAnalysisService {

    private RunningInfoRepository runningInfoRepository;
    private OutputRepository outputRepository;

    @Autowired
    public InformationAnalysisServiceImpl(RunningInfoRepository runningInfoRepository, OutputRepository outputRepository) {
        this.runningInfoRepository = runningInfoRepository;
        this.outputRepository = outputRepository;
    }

    @Override
    public List<RunningInfo> saveRunningInfos(List<RunningInfo> runningInfos) {
        final int maxHeartRate = 200;
        final int minHeartRate = 60;
        Random random = new Random();
        List<Output> saveOutput = new ArrayList<Output>();

        for(RunningInfo runningInfo : runningInfos){
            Output output = new Output(runningInfo.getUserInfo());

            int randomHeartRate = random.nextInt(maxHeartRate) % (maxHeartRate - minHeartRate + 1) + minHeartRate;
            runningInfo.setHeartRate(randomHeartRate);

            if(randomHeartRate >= 60 && randomHeartRate <= 75){
                runningInfo.setHealthWarningLevel(RunningInfo.HealthWarningLevel.LOW);
            }else if(randomHeartRate >= 75 && randomHeartRate <= 120){
                runningInfo.setHealthWarningLevel(RunningInfo.HealthWarningLevel.NORMAL);
            }else if(randomHeartRate > 120){
                runningInfo.setHealthWarningLevel(RunningInfo.HealthWarningLevel.HIGH);
            }

            output.setHealthWarningLevel(runningInfo.getHealthWarningLevel());
            output.setHeartRate(runningInfo.getHeartRate());
            output.setId(runningInfo.getId());
            output.setRunningId(runningInfo.getRunningId());
            output.setTotalRunningTime(runningInfo.getTotalRunningTime());

            saveOutput.add(output);
        }

        outputRepository.save(saveOutput);

        return runningInfoRepository.save(runningInfos);
    }

    @Override
    public void deleteRunningInfoByRunningId(String runningId) {
        runningInfoRepository.deleteRunningInfoByRunningId(runningId);
        outputRepository.deleteRunningInfoByRunningId(runningId);
    }

    @Override
    public Page<Output> findAllByHeartRateGreaterThanOrderByHeartRateDesc(int heartRate, Pageable pageable) {
        return outputRepository.findAllByHeartRateGreaterThanOrderByHeartRateDesc(heartRate, pageable);
    }


}
