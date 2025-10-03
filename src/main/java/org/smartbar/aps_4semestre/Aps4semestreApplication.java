package org.smartbar.aps_4semestre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Aps4semestreApplication {

    public static void main(String[] args) {
        SpringApplication.run(Aps4semestreApplication.class, args);
    }

}
