package br.com.blz.testjava.application.core.domain.mapper;

import br.com.blz.testjava.adapters.inbound.request.WarehousesRequest;
import br.com.blz.testjava.application.core.domain.Warehouses;
import br.com.blz.testjava.application.core.domain.dto.WarehousesDTO;

import java.util.List;

public interface WarehousesMapper {

    public Warehouses warehousesRequestToWarehouse(WarehousesRequest request);

    public WarehousesDTO warehousesToWarehousesDTO(Warehouses request);

    public List<WarehousesDTO> warehousesToWarehousesDTO(List<Warehouses> request);

    List<Warehouses> warehousesRequestToWarehouse(List<WarehousesRequest> requestList);
}
