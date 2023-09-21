package cloud.tteams.identity.telephone_operator.domain;

public class TelephoneOperator {

    private TelephoneOperatorId id;

    private TelephoneOperatorName name;

    public TelephoneOperator(TelephoneOperatorId id, TelephoneOperatorName name) {
        this.id = id;
        this.name = name;
    }

    public TelephoneOperatorId getId() {
        return id;
    }

    public TelephoneOperatorName getName() {
        return name;
    }
}
