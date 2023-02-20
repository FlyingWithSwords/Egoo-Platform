package com.emporiumsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.emporiumsystem.dao")
public class emporiumSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(emporiumSystemApplication.class, args);
        System.out.println("   ___ _       _             __    __ _ _   _     __                       _\n" +
                "  / __\\ |_   _(_)_ __   __ _/ / /\\ \\ (_) |_| |__ / _\\_      _____  _ __ __| |___\n" +
                " / _\\ | | | | | | '_ \\ / _` \\ \\/  \\/ / | __| '_ \\\\ \\\\ \\ /\\ / / _ \\| '__/ _` / __|\n" +
                "/ /   | | |_| | | | | | (_| |\\  /\\  /| | |_| | | |\\ \\\\ V  V / (_) | | | (_| \\__ \\\n" +
                "\\/    |_|\\__, |_|_| |_|\\__, | \\/  \\/ |_|\\__|_| |_\\__/ \\_/\\_/ \\___/|_|  \\__,_|___/\n" +
                "         |___/         |___/");
    }

}
