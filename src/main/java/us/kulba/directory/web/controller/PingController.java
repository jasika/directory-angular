package us.kulba.directory.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.kulba.directory.model.Ping;

@RequestMapping("ping")
@Controller
public class PingController {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Ping ping() {

        Ping p = new Ping();
        p.setApplication("Directory");
        p.setVersion("1.0");

        return p;

    }
}
