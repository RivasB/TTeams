package ec.gob.registrocivil.share.holiday.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ec.gob.registrocivil.share.holiday.domain.Holiday;
import ec.gob.registrocivil.share.holiday.domain.HolidayType;
import ec.gob.registrocivil.share.holiday.domain.service.IHolidayServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class HolidayServiceClient implements IHolidayServiceClient {

    private final HolidayFeignClient client;

    private static final Logger logger = LoggerFactory.getLogger(HolidayServiceClient.class);

    public HolidayServiceClient(HolidayFeignClient client) {
        this.client = client;
    }

    @Override
    public List<Holiday> getAllHolidays(HolidayType type, Integer pageNo, Integer pageSize) {
        try{
            String response = client.getAllHolidays(type, pageNo, pageSize);
            return getResult(response);
        }catch (Exception e){
            logger.error("Error obtaining holiday information: ", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Holiday> getAllHolidaysByAgency(UUID agency, Integer pageNo, Integer pageSize) {
        try{
            String response = client.getAllHolidaysByAgency(agency, pageNo, pageSize);
            return getResult(response);
        }catch (Exception e){
            logger.error("Error obtaining holiday information: ", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Holiday> getAllHolidaysByDateRange(LocalDate from, LocalDate to, Integer pageNo, Integer pageSize) {
        try{
            String response = client.getAllHolidaysByDateRange(from, to, pageNo, pageSize);
            return getResult(response);
        }catch (Exception e){
            logger.error("Error obtaining holiday information: ", e);
            return Collections.emptyList();
        }
    }

    private List<Holiday> getResult(String response ) throws JsonProcessingException {
        List<Holiday> result = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode eventMessage = (ObjectNode) mapper.readTree(response);
        if(eventMessage.has("data") && eventMessage.get("data").isArray()){
            for (JsonNode d : eventMessage.get("data")) {

                MonthDay date = MonthDay.parse(d.get("date").asText());
                HolidayType t = HolidayType.valueOf(d.get("type").asText());
                UUID agency = null;
                if(d.hasNonNull("agency")){
                    agency = UUID.fromString(d.get("agency").get("id").asText());
                }
                result.add(new Holiday(t, date, agency));
            }
        }
        return result;
    }
}
