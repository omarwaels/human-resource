package iti.project.soap;

import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Services.ServiceImpl.EmployerServicesImpl;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class AppTest {

    private EmployerServicesImpl employerServices;

    @BeforeEach
    public void setup() {
        employerServices = new EmployerServicesImpl();
    }

    @Test
    public void addingEmployer() throws Exception {
        // Arrange
     
        ManagerRegisterDTO managerRegisterDTO = createTestManagerRegisterDTO();

        // Act
        try{
            employerServices.registerManager(managerRegisterDTO);
            Employer result = EmployerDAOImp.getByEmail(managerRegisterDTO.getEmail());
            System.out.println("Start");
            assertThat(result).isNotNull();
        assertThat(result.getEmail()).isEqualTo(managerRegisterDTO.getEmail());
        assertThat(result.getPassword()).isEqualTo(managerRegisterDTO.getPassword());
        assertThat(result.getAddress()).isEqualTo(managerRegisterDTO.getAddress());
        assertThat(result.getFirstName()).isEqualTo(managerRegisterDTO.getFirstName());
        assertThat(result.getLastName()).isEqualTo(managerRegisterDTO.getLastName());
        assertThat(result.getPhoneNum()).isEqualTo(managerRegisterDTO.getPhoneNum());
        assertThat(result.getEmployerProject().getAddress()).isEqualTo(managerRegisterDTO.getProjectAddress());
        assertThat(result.getEmployerProject().getProjectName()).isEqualTo(managerRegisterDTO.getProjectName());
        }catch (Exception e){
e.printStackTrace();
        }
        
        // Assert
        
    }

    private ManagerRegisterDTO createTestManagerRegisterDTO() {
        ManagerRegisterDTO managerRegisterDTO = new ManagerRegisterDTO();
        managerRegisterDTO.setAddress("test");
        managerRegisterDTO.setEmail("test");
        managerRegisterDTO.setFirstName("test");
        managerRegisterDTO.setLastName("test");
        managerRegisterDTO.setPassword("test");
        managerRegisterDTO.setPhoneNum("test");
        managerRegisterDTO.setProjectAddress("test");
        managerRegisterDTO.setProjectName("test");
        return managerRegisterDTO;
    }
}
