package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class InfoController {

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/port")
    public int getPort() {
        return serverPort;
    }

    @GetMapping("/sum")
    public int getSum() {
        long start = System.currentTimeMillis();
        List<Integer> limit = Stream
                .iterate(1, a -> a +1)
                .limit(1_000_000)
                .collect(Collectors.toList());
        int sum = limit.stream()
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        return (int) (System.currentTimeMillis() - start);


    }

}
