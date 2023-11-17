package com.game.list.controllers;


import com.game.list.domain.records.BelongingDTO;
import com.game.list.services.BelongingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/belonging")
public class BelongingController {

    @Autowired
    private BelongingService belongingService;

    @PostMapping
    public void createdBelonging(@RequestBody  BelongingDTO dto){
        belongingService.createdBelonging(dto);
    }
}
