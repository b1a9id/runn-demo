package com.b1a9idps.runndemo.application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.b1a9idps.runndemo.presentation.reponse.ShopResponse;

@Service
public class ShopService {

    private static final IntFunction<ShopResponse> SHOP_RESPONSE_FUNCTION = v -> {
        var foundedOn = LocalDate.of(2024, 1, 1);
        return new ShopResponse(v, "name"+ v, foundedOn);
    };

    public List<ShopResponse> list() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(SHOP_RESPONSE_FUNCTION)
                .toList();
    }

    public ShopResponse findById(int id) {
        return SHOP_RESPONSE_FUNCTION.apply(id);
    }
}
