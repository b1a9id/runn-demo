package com.b1a9idps.runndemo.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.runndemo.application.service.ShopService;
import com.b1a9idps.runndemo.presentation.reponse.ShopListResponse;
import com.b1a9idps.runndemo.presentation.reponse.ShopResponse;
import com.b1a9idps.runndemo.presentation.request.ShopListRequest;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public ShopListResponse list(@ModelAttribute ShopListRequest request) {
        return shopService.list(request);
    }

    @GetMapping("{id}")
    public ShopResponse findById(@PathVariable Integer id) {
        return shopService.findById(id);
    }
}
