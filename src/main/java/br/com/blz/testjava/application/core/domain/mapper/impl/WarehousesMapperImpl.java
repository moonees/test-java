package br.com.blz.testjava.application.core.domain.mapper.impl;

import br.com.blz.testjava.adapters.inbound.request.WarehousesRequest;
import br.com.blz.testjava.application.core.domain.Warehouses;
import br.com.blz.testjava.application.core.domain.dto.WarehousesDTO;
import br.com.blz.testjava.application.core.domain.mapper.WarehousesMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WarehousesMapperImpl implements WarehousesMapper {
    @Override
    public Warehouses warehousesRequestToWarehouse(WarehousesRequest request) {
        return new Warehouses.WarehousesBuilder()
            .setLocality(request.getLocality())
            .setQuantity(request.getQuantity())
            .setType(request.getType())
            .build();
    }

    @Override
    public WarehousesDTO warehousesToWarehousesDTO(Warehouses request) {
        return new WarehousesDTO.WarehousesDTOBuilder()
            .setLocality(request.getLocality())
            .setQuantity(request.getQuantity())
            .setType(request.getType())
            .build();
    }

    @Override
    public List<WarehousesDTO> warehousesToWarehousesDTO(List<Warehouses> warehouses) {
        return warehouses.stream()
            .map(this::warehousesToWarehousesDTO)
            .collect(Collectors.toList());
    }

    @Override
    public List<Warehouses> warehousesRequestToWarehouse(List<WarehousesRequest> warehousesRequestList) {
        return warehousesRequestList.stream()
            .map(this::warehousesRequestToWarehouse)
            .collect(Collectors.toList());
    }


}
