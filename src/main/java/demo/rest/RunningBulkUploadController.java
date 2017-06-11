package demo.rest;

import demo.domain.Output;
import demo.domain.RunningInfo;
import demo.domain.RunningInfoRepository;
import demo.service.InformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wuyufei on 6/8/17.
 */
@RestController
public class RunningBulkUploadController {

    private InformationAnalysisService informationAnalysisService;

    @Autowired
    public RunningBulkUploadController(InformationAnalysisService informationAnalysisService) {
        this.informationAnalysisService = informationAnalysisService;
    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInfo> runningInfos) {
        this.informationAnalysisService.saveRunningInfos(runningInfos);
    }

    @RequestMapping(value = "/orderedResult", method = RequestMethod.GET)
    public Page<Output> findByHealthWarningLevel(@RequestParam(name = "page") int page,
                                                 @RequestParam(name = "size") int size
                                                ){
        return informationAnalysisService.findAllByHeartRateGreaterThanOrderByHeartRateDesc(0, new PageRequest(page, 2));
    }

    @RequestMapping(value = "/delete/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){
        informationAnalysisService.deleteRunningInfoByRunningId(runningId);
    }


}
