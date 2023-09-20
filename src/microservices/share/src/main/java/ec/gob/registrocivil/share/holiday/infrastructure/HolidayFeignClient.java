package ec.gob.registrocivil.share.holiday.infrastructure;


import ec.gob.registrocivil.share.holiday.domain.HolidayType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.UUID;


@FeignClient("schedule")
public interface HolidayFeignClient {
    @GetMapping(value = "/api/holiday", produces =  MediaType.APPLICATION_JSON_VALUE)
    String getAllHolidays(@RequestParam(value="type") HolidayType type, @RequestParam(value="pageNo")  Integer pageNo,
                           @RequestParam(value="pageSize") Integer pageSize);

    @GetMapping(value ="/api/holiday/local", produces =  MediaType.APPLICATION_JSON_VALUE)
    String getAllHolidaysByAgency(@RequestParam(value="agency") UUID agency, @RequestParam(value="pageNo")  Integer pageNo,
                           @RequestParam(value="pageSize") Integer pageSize);

    @GetMapping(value ="/api/holiday/daterange", produces =  MediaType.APPLICATION_JSON_VALUE)
    String getAllHolidaysByDateRange(@RequestParam(value="from") LocalDate from, @RequestParam(value="to") LocalDate to,
                          @RequestParam(value="pageNo")  Integer pageNo, @RequestParam(value="pageSize") Integer pageSize);

}
