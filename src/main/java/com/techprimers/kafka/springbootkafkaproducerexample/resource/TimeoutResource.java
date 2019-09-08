package com.techprimers.kafka.springbootkafkaproducerexample.resource;

import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("timeout")
public class TimeoutResource {


    @PostMapping("/{seconds}")
    public String timeout(@PathVariable("seconds") final String seconds) {

        try {
            int millissleep = Integer.parseInt(seconds) * 1000;
            Thread.sleep(millissleep);
            return String.format("I slept %s seconds", seconds);
        } catch ( InterruptedException e) {
            e.printStackTrace();
        } catch ( NumberFormatException e ) {
            return "Timeout specified was not a number";
        }
        return "Something went wrong";
    }
}
