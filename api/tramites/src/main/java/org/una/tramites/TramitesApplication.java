/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author thony
 */

@EnableSwagger2
@SpringBootApplication
public class TramitesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TramitesApplication.class, args);
	}
}
