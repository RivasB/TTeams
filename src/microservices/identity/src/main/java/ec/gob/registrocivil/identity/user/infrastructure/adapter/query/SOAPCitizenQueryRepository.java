package ec.gob.registrocivil.identity.user.infrastructure.adapter.query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import ec.gob.registrocivil.share.core.infrastructure.exceptions.ResourceNotFoundException;
import ec.gob.registrocivil.identity.user.domain.repository.ICitizenQueryRepository;
import ec.gob.registrocivil.identity.user.domain.soap.Ciudadano;
import reactor.core.publisher.Mono;

@Component
public class SOAPCitizenQueryRepository implements ICitizenQueryRepository {

    private WebClient webClient;

    private final static String FOUND_CITIZEN_CODE = "000";

    public SOAPCitizenQueryRepository() {
        this.webClient = WebClient.builder().build();
    }

    @Override
    public Ciudadano findCitizenByNui(String nui) {

        SoapResponse result = webClient.get()
                .uri("lb://middleware/nui/" + nui)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(SoapResponse.class);
                    }

                    return Mono.empty();
                }).block();

        if (result == null || !result.getCodigo().equals(FOUND_CITIZEN_CODE)) {
            throw new ResourceNotFoundException("Citizen not found with NUI: " + nui);
        }

        return result.getCiudadano();
    }

}
