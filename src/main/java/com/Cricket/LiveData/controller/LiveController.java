package com.Cricket.LiveData.controller;

import com.Cricket.LiveData.response.LiveResponse;
import com.Cricket.LiveData.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiveController {

    @Autowired
    LiveService liveService;

    @GetMapping("cricketData")
    public LiveResponse liveResponse (){
    LiveResponse response = liveService.getResponse();
    return  response;

    }
}
