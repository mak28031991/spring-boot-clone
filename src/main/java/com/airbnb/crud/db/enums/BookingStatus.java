package com.airbnb.crud.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum BookingStatus {
    confirmed, cancelled, waiting;

}
