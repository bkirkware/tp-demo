package com.example.tpdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CfEnvController {

    private static final Logger log = LoggerFactory.getLogger(CfEnvController.class);

    private final CfEnvService cfEnvService;

    public CfEnvController(CfEnvService cfEnvService) {
        this.cfEnvService = cfEnvService;
    }

    @GetMapping("/cfenv")
    public ResponseEntity<CfEnvInfo> getCfEnvInfo() {
        log.info("Received request on /cfenv endpoint");
        CfEnvInfo info = cfEnvService.getCfEnvInfo();
        if (info == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(info);
    }
}
