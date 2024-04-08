package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface RegisterManagerMapper {

    RegisterManagerMapper INSTANCE = Mappers.getMapper(RegisterManagerMapper.class);

    
    @Mapping(source = "managerRegisterDTO.firstName", target = "firstName")
    @Mapping(source = "managerRegisterDTO.lastName", target = "lastName")
    @Mapping(source = "managerRegisterDTO.email", target = "email")
    @Mapping(source = "managerRegisterDTO.address", target = "address")
    @Mapping(source = "managerRegisterDTO.phoneNum", target = "phoneNum")
    @Mapping(source = "managerRegisterDTO.password", target = "password")
    
    Employer registerManagerToEmployer(ManagerRegisterDTO managerRegisterDTO);


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

