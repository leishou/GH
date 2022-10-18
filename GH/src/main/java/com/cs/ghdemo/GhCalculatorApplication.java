package com.cs.ghdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.cs.ghdemo.mapper")
public class GhCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhCalculatorApplication.class, args);
	}

}
