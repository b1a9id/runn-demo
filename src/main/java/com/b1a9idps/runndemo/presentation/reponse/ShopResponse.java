package com.b1a9idps.runndemo.presentation.reponse;

import java.time.LocalDate;

public record ShopResponse(
        Integer id,
        String name,
        LocalDate foundedOn) {
}
