package us.kulba.directory.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.kulba.directory.model.Ping;

@RequestMapping("ping")
@Controller
public class PingController {
    final Logger logger = LoggerFactory.getLogger(PingController.class);

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Ping ping() {

        logger.debug("Hit PingController.ping()");

        Ping p = new Ping();
        p.setApplication("Directory");
        p.setVersion("1.0");

        return p;

    }
}
