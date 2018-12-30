package com.itheima.mapper;


import com.itheima.domain.Traveller;

import java.util.List;

public interface TravellerMapper {

List<Traveller> findByOrdersId(String id);
}
