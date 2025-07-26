package liliana.session_9.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Ex3 {
    public void logInfor () {
        log.info("Logging infor");
    }
    public void logTrace () {
        log.trace("Logging trace");
    }
    public void logDebug () {
        log.debug("Logging debug");
    }
    public void logError () {
        log.error("Logging error");
    }
}
