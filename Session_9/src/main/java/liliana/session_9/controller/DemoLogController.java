package liliana.session_9.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/log")
@Slf4j
public class DemoLogController {

    @GetMapping("/trace")
    public void trace() {
        log.trace("Đã ghi log trace");
    }

    @GetMapping("/debug")
    public void debug() {
        log.debug("Đã ghi log debug");
    }

    @GetMapping("/info")
    public void info() {
        log.info("Đã ghi log info");
    }

    @GetMapping("/warning")
    public void warn() {
        log.warn("Đã ghi log warning");
    }

    @GetMapping("/error")
    public void error() {
        log.error("Đã ghi log error");
    }
}
