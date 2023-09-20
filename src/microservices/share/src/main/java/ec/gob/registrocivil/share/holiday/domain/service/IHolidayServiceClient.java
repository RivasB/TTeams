package ec.gob.registrocivil.share.holiday.domain.service;


import ec.gob.registrocivil.share.holiday.domain.Holiday;
import ec.gob.registrocivil.share.holiday.domain.HolidayType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IHolidayServiceClient {
    List<Holiday> getAllHolidays(HolidayType type, Integer pageNo, Integer pageSize);

    List<Holiday> getAllHolidaysByAgency(UUID agency, Integer pageNo, Integer pageSize);

    List<Holiday> getAllHolidaysByDateRange(LocalDate from, LocalDate to, Integer pageNo, Integer pageSize);
}
