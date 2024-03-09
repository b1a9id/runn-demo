package com.b1a9idps.runndemo.presentation.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

public record ShopCreateRequest(
        @NotEmpty String name,
        LocalDate foundedOn) {
}
