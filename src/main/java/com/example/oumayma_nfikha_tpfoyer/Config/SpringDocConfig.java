package com.example.oumayma_nfikha_tpfoyer.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("TP Foyer ")
                .description("Projet TPFoyer")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("contact US")
                .email("Oumaima.Nfikha@esprit.tn");
        return contact;
    }
    @Bean
    public GroupedOpenApi UniversitesApi() {
        return GroupedOpenApi.builder()
                .group("Only Universites")
                .pathsToMatch("/api/universites*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi FoyerApi() {
        return GroupedOpenApi.builder()
                .group("Only Foyer")
                .pathsToMatch("/api/foyer*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi BlocApi() {
        return GroupedOpenApi.builder()
                .group("Only Bloc")
                .pathsToMatch("/api/blocs*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi ChambreApi() {
        return GroupedOpenApi.builder()
                .group("Only chambre")
                .pathsToMatch("/api/chambre*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi EtudiantApi() {
        return GroupedOpenApi.builder()
                .group("Only etudiant")
                .pathsToMatch("/api/etudiant*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi ReservationApi() {
        return GroupedOpenApi.builder()
                .group("Only reservations")
                .pathsToMatch("/api/reservations*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi allPublicApi() {
        return GroupedOpenApi.builder()
                .group("All")
                .pathsToMatch("/api/**")
                .pathsToExclude("")
                .build();
    }
}