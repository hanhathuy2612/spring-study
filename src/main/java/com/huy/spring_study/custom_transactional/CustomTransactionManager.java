package com.huy.spring_study.custom_transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CustomTransactionManager {
    private final List<String> data = new ArrayList<>();
    private final List<String> backup = new ArrayList<>();

    public void begin() {
        backup.clear();
        backup.addAll(data);
        log.info("Transaction began");
    }

    // Commit by keeping the current state
    public void commit() {
        log.info("Transaction committed: {}", data);
    }

    // Rollback by restoring the backup
    public void rollback() {
        data.clear();
        data.addAll(backup);
        log.info("Transaction rolled back: {}", data);
    }

    // Simulate a database operation
    public void addData(String item) {
        data.add(item);
        log.info("Added: {}", item);
    }

    public List<String> getData() {
        return new ArrayList<>(data);
    }
}
