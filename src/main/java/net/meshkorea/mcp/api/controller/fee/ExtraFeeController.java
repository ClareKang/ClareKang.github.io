package net.meshkorea.mcp.api.controller.fee;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFee;
import com.meshprime.api.client.model.ExtraFeeResponse;
import net.meshkorea.mcp.api.service.fee.ExtraFeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sungjae.hong on 2017. 4. 24..
 */
@RestController
@RequestMapping(value = "/v1/intra/fee")
public class ExtraFeeController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ExtraFeeService extraFeeService;

    @RequestMapping(value = "/extraFees", method = RequestMethod.GET)
    public ExtraFeeResponse findExtraFees(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                          @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws ApiException {
        return extraFeeService.findExtraFees(keyword, page);
    }

    @RequestMapping(value = "/extraFees/{id}", method = RequestMethod.GET)
    public ExtraFee findExtraFeeById(@PathVariable int id) throws ApiException {
        return extraFeeService.findExtraFeeById(id);
    }

    @PutMapping(value = "/{id}/clear_target")
    public void clearTargetStore(@PathVariable int id) throws ApiException{
        extraFeeService.clearTargetStore(id);
    }


}
