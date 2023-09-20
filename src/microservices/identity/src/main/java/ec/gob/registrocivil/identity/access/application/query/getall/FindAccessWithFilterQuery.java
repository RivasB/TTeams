package ec.gob.registrocivil.identity.access.application.query.getall;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindAccessWithFilterQuery implements IQuery {

    private Pageable pageable;

    private String description;
    private String code;
    private String resource;

    public FindAccessWithFilterQuery(Pageable pageable, String description, String code, String resource) {
        this.pageable = pageable;
        this.description = description;
        this.code = code;
        this.resource = resource;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public String getResource() {
        return resource;
    }

}
