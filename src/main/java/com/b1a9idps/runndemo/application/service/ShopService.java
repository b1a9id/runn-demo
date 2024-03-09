package com.b1a9idps.runndemo.application.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.b1a9idps.runndemo.presentation.reponse.ShopListResponse;
import com.b1a9idps.runndemo.presentation.reponse.ShopResponse;
import com.b1a9idps.runndemo.presentation.request.ShopCreateRequest;
import com.b1a9idps.runndemo.presentation.request.ShopListRequest;

@Service
public class ShopService {

    private static final LocalDate FOUNDED_ON = LocalDate.of(2024, 1, 1);

    private static final IntFunction<ShopResponse> SHOP_RESPONSE_FUNCTION =
            v -> new ShopResponse(v, "name"+ v, FOUNDED_ON);

    private static final Map<Integer, ShopResponse> SHOPS = IntStream.rangeClosed(0, 100)
            .mapToObj(SHOP_RESPONSE_FUNCTION)
            .collect(Collectors.toMap(ShopResponse::id, Function.identity()));

    public ShopListResponse list(ShopListRequest request) {
        int count = request.count() != null ? request.count() : 5;

        var shops = SHOPS.values().stream()
                .limit(count)
                .toList();
        return new ShopListResponse(shops);
    }

    public ShopResponse findById(int id) {
        return SHOPS.get(id);
    }

    public ShopResponse create(ShopCreateRequest request) {
        var id = SHOPS.size() + 1;
        return SHOPS.put(id, new ShopResponse(id, request.name(), request.foundedOn()));
    }

    public void delete(Integer id) {
        SHOPS.remove(id);
    }
}
