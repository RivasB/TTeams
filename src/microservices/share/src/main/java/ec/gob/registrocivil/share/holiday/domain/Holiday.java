package ec.gob.registrocivil.share.holiday.domain;

import java.time.MonthDay;
import java.util.UUID;

public class Holiday {
    private HolidayType type;
    private MonthDay date;
    private UUID agency;

    public Holiday(HolidayType type, MonthDay date, UUID agency) {
        this.type = type;
        this.date = date;
        this.agency = agency;
    }

    public HolidayType getType() {
        return type;
    }

    public MonthDay getDate() {
        return date;
    }

    public UUID getAgency() {
        return agency;
    }
}
