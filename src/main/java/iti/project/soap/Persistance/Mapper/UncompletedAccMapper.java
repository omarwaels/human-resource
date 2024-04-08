package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;

@Mapper
public interface UncompletedAccMapper {

    UncompletedAccMapper INSTANCE = Mappers.getMapper(UncompletedAccMapper.class);

    
    @Mapping(source = "uncompletedAccDTO.email", target = "email")
    Employer UncompletedAccToEmployer(UncompletedAccDTO uncompletedAccDTO);


    // @Mapping(source = "product.id", target = "productId")
    // @Mapping(source = "product.productName", target = "productName")
    // @Mapping(source = "product.productPrice", target = "productPrice")
    // OrdersItemDTO entityBToDTOB(OrdersItem entityB);

        
    // default Map<OrderDTO, List<OrdersItemDTO>> mapEntitiesToDTOs(Map<Order, List<OrdersItem>> entities) {
    //     Map<OrderDTO, List<OrdersItemDTO>> dtos = new LinkedHashMap();
    //     for (Map.Entry<Order, List<OrdersItem>> entry : entities.entrySet()) {
    //         OrderDTO dtoA = entityAToDTOA(entry.getKey());
    //         List<OrdersItemDTO> dtoBs = entry.getValue().stream()
    //                                     .map(this::entityBToDTOB)
    //                                     .collect(Collectors.toList());
    //         dtos.put(dtoA, dtoBs);
    //     }
    //     return dtos;
    // }

}

