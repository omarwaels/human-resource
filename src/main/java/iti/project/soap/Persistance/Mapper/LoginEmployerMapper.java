package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface LoginEmployerMapper {

    LoginEmployerMapper INSTANCE = Mappers.getMapper(LoginEmployerMapper.class);

    @Mapping(source = "employer.employerId", target = "employerId")
    @Mapping(source = "employer.firstName", target = "firstName")
    @Mapping(source = "employer.lastName", target = "lastName")
    @Mapping(source = "employer.email", target = "email")
    @Mapping(source = "employer.address", target = "address")
    @Mapping(source = "employer.phoneNum", target = "phoneNum")
    @Mapping(source = "employer.humanResourceId.firstName", target = "managerName")
    @Mapping(source = "employer.employerProject.projectName", target = "projectName")
    @Mapping(source = "employer.employerProject.projectId", target = "projectId")
    EmployerLoginDTO employerToLoginDTO(Employer employer);


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

