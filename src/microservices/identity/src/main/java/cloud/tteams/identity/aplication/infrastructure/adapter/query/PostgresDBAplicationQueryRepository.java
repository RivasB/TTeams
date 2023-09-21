package cloud.tteams.identity.aplication.infrastructure.adapter.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.aplication.infrastructure.repository.hibernate.AplicationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.aplication.application.AplicationResponse;
import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.AplicationId;
import cloud.tteams.identity.aplication.domain.repository.IAplicationQueryRepository;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

@Component
@Primary
public class PostgresDBAplicationQueryRepository implements IAplicationQueryRepository {

    private final ISpringAplicationReadDataJPARepository aplicationRepository;

    public PostgresDBAplicationQueryRepository(final ISpringAplicationReadDataJPARepository aplicationRepository) {
        this.aplicationRepository = aplicationRepository;
    }

    @Override
    public Aplication findById(AplicationId id) {
        Optional<AplicationDto> aplicationEntity = aplicationRepository.findById(id.getValue());

        return aplicationEntity.get().toAggregate();
    }

    @Override
    public MessagePaginatedResponse allAplicationWithOutFilter(Pageable pageable) {
        Page<AplicationDto> aplicationDto = this.aplicationRepository.findAll(pageable);
        return this.result(aplicationDto);
    }

    /*
     * Usado por los metodos: allUsersWithOutFilter y allUsersWithFilter
     */
    private MessagePaginatedResponse result(Page<AplicationDto> aplicationDto) {
        List<AplicationResponse> aplications = new ArrayList<>();
        aplicationDto.forEach(element -> aplications.add(new AplicationResponse(element.toAggregate())));

        return new MessagePaginatedResponse("OK", aplications, aplicationDto.getTotalPages(),
                aplicationDto.getNumberOfElements(), aplicationDto.getTotalElements(), aplicationDto.getSize(),
                aplicationDto.getNumber());
    }

    @Override
    public MessagePaginatedResponse allAplicationWithFilter(Pageable pageable, String filter) {
        Page<AplicationDto> aplicationDto = this.aplicationRepository
                .getAplicationDtoByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(filter, filter, pageable);

        return this.result(aplicationDto);
    }

    @Override
    public Long countByName(String name) {
        return aplicationRepository.countByName(name);
    }

    @Override
    public Aplication findByName(String name) {
        Optional<AplicationDto> aplicationDto = aplicationRepository.findByName(name);
        return aplicationDto.get().toAggregate();
    }

    @Override
    public Long countByIdIsNotAndName(UUID id, String name) {
        return aplicationRepository.countByIdIsNotAndName(id, name);
    }
}
