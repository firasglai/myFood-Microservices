package com.firas.order.service;

import com.firas.order.repository.DeliveryInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryInfoService {

    private final DeliveryInfoRepository deliveryInfoRepository;

}
