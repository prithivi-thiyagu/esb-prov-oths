package com.bandhanbank.esb.prov.oths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.bandhanbank.esb.prov.oths","com.bandhanbank.esb.common.util"})
public class EsbProvOthsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EsbProvOthsApplication.class, args);
	}
}
