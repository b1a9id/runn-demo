package com.b1a9idps.runndemo.presentation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.runndemo.application.service.ShopService;
import com.b1a9idps.runndemo.presentation.reponse.ShopListResponse;
import com.b1a9idps.runndemo.presentation.reponse.ShopResponse;
import com.b1a9idps.runndemo.presentation.request.ShopCreateRequest;
import com.b1a9idps.runndemo.presentation.request.ShopListRequest;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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

    @PostMapping
    @ResponseStatus(CREATED)
    public ShopResponse create(@RequestBody @Validated ShopCreateRequest request) {
        return shopService.create(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        shopService.delete(id);
    }
}
