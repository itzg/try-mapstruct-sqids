package me.itzg.trymapstructsqids;

import org.springframework.boot.SpringApplication;

public class TestTryMapstructSqidsApplication {

    public static void main(String[] args) {
        SpringApplication.from(TryMapstructSqidsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
