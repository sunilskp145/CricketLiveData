package com.Cricket.LiveData.service;

import com.Cricket.LiveData.TableEntity;
import com.Cricket.LiveData.response.CricketSeries;
import com.Cricket.LiveData.response.LiveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.Cricket.LiveData.repository.CricketRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiveService {

    @Autowired(required = true)
    private CricketRepository cricketRepository;

    @Value("${Url}")
    private String cricketUrl;

    @Value("${apiKey}")
    private String key;

    @Value("${hostKey}")
    private String hostKey;


//    public TableEntity saveDetail(TableEntity data)
//    {
//        return repository.save(data);
//    }

    public LiveResponse getResponse(){

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", key);
        headers.set("X-RapidAPI-Host",hostKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LiveResponse> response = new RestTemplate().exchange(cricketUrl, HttpMethod.GET, entity, LiveResponse.class);
        LiveResponse responseBody = response.getBody();

        List<CricketSeries> flat =
                responseBody.getCricketResults().stream()
                        .flatMap(c -> c.getCricketSeries().stream())
                        .collect(Collectors.toList());

        List<TableEntity> tableList = new ArrayList<>();

        flat.forEach( e -> {
            TableEntity table = new TableEntity();
            table.setSeason(e.getSeason());
            table.setSeries_id(e.getSeries_id());
            table.setStatus(e.getStatus());
            table.setSeries_name(e.getSeries_name());
            table.setUpdated_at(e.getUpdated_at());
            tableList.add(table);
        });

        cricketRepository.saveAll(tableList);

        System.out.println(tableList);
        return responseBody;


    }
}
