package com.oopsmails.openapi.codegen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-28T14:32:46.157292-04:00[America/Toronto]")

@Controller
@RequestMapping("${openapi.tutorialCom.base-path:}")
public class TutorialsApiController implements TutorialsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TutorialsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
