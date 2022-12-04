package arp.training.cloudkitchen;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CloudkitchenApplication {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CloudkitchenApplication.class);

	public static void main(String[] args) {
		log.info("Starting CloudkitchenApplication .... ");
		SpringApplication.run(CloudkitchenApplication.class, args);
	}

}
