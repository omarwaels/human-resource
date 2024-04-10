package iti.project.soap;

import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.CreateRequestDTO;
import iti.project.soap.Persistance.DTO.DeleteRequestDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Services.EmployerServicesImpl;
import iti.project.soap.Services.EventServicesImpl;
import iti.project.soap.Services.ProjectServicesImpl;
import iti.project.soap.Services.RequestServicesImpl;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
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
    class EventServicesImplTest {

        @Test
        void testCreateEvent() {

            EventServicesImpl eventServices = new EventServicesImpl();
            CreateEventDTO createEventDTO = createTestCreateEventDTO();
    
   
            try {
                Boolean result = eventServices.createEvent(createEventDTO);
    
       
                assertThat(result).isEqualTo(true);
              
            } catch (Exception e) {
                fail("Exception occurred during test: " + e.getMessage());
            }
        }
    
        private CreateEventDTO createTestCreateEventDTO() {
            CreateEventDTO createEventDTO = new CreateEventDTO();
            createEventDTO.setEventName("Test Event");
            createEventDTO.setProjectName("Test Project");
            createEventDTO.setEmployerId(1); // Assuming a valid employer ID
            return createEventDTO;
        }
    }
    @Test
    void testRemoveProject() {
        // Arrange
        ProjectServicesImpl projectServices = new ProjectServicesImpl();
        int employerId = 1; // Assuming a valid employer ID

        // Act
        try {
            Boolean result = projectServices.removeProject(employerId);

            // Assert
            assertThat(result).isEqualTo(true);
        } catch (Exception e) {
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    void testCreateRequest() {
        // Arrange
        RequestServicesImpl requestServices = new RequestServicesImpl();
        CreateRequestDTO createRequestDTO = createTestCreateRequestDTO();

        // Act
        try {
            Boolean result = requestServices.createRequest(createRequestDTO);

            // Assert
            assertThat(result).isEqualTo(true);
        } catch (Exception e) {
            fail("Exception occurred during test: " + e.getMessage());
        }
    }
    
    @Test
    void testDeleteRequest() {
        // Arrange
        RequestServicesImpl requestServices = new RequestServicesImpl();
        DeleteRequestDTO deleteRequestDTO = createTestDeleteRequestDTO();

        // Act
        try {
            Boolean result = requestServices.deleteRequest(deleteRequestDTO);

            // Assert
            assertThat(result).isEqualTo(true);
        } catch (Exception e) {
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

    private CreateRequestDTO createTestCreateRequestDTO() {
        CreateRequestDTO createRequestDTO = new CreateRequestDTO();
        // Fill in the fields with test data
        return createRequestDTO;
    }

    private DeleteRequestDTO createTestDeleteRequestDTO() {
        DeleteRequestDTO deleteRequestDTO = new DeleteRequestDTO();
        // Fill in the fields with test data
        return deleteRequestDTO;
    }

}
