package iti.project.soap.Services.ServiceImpl;




import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Mapper.LoginEmployerMapper;
import iti.project.soap.Services.Service.EmployerServices;
import iti.project.soap.Utils.EmployerStatusEnum;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "iti.project.soap.Services.Service.EmployerServices")
public class EmployerServicesImpl implements EmployerServices  {

    @Resource
    private WebServiceContext context;
    
     @Override
     public String getEmployerById (String userId ) throws Exception {
          try {
               Integer idToInteger = Integer.parseInt(userId);
               Employer emp = EmployerDAOImp.getById(idToInteger);
               if (emp == null) {
                   throw new Exception("User not found");
               }
               return emp.toString();
           } catch (NumberFormatException e) {
               throw new Exception("Invalid user ID format");
           }

     }
     @Override
     public String getEmployerStatus(String employerEmail) {
        EmployerStatusEnum status = EmployerDAOImp.getStatus(employerEmail);

        if (status == EmployerStatusEnum.EXISTING_EMPLOYER) {
            // Set the cookie in the response
            setCookie("passedFirstPhase", "true");
            // Return response
            return "EXISTING_EMPLOYER";
        } else {
            return status.toString();
        }
      }

    @Override
     public EmployerLoginDTO loginPhaseTwo(String userEmail, String userPassword) throws Exception {
          Employer employer = EmployerDAOImp.getEmployer(userEmail , userPassword );
          if(employer == null){
               throw new Exception("Invalid user email");
           }else{
               if(!employer.getPassword().equals(userPassword)){
               throw new Exception("Invalid user Password");
               }

               return LoginEmployerMapper.INSTANCE.employerToLoginDTO(employer);
           }
          
     }
     private void setCookie(String name, String value) {
        // Retrieve response context
        MessageContext messageContext = context.getMessageContext();
        HttpServletResponse response = (HttpServletResponse) messageContext.get(MessageContext.SERVLET_RESPONSE);

        // Create and add cookie to the response
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(3600); // Set cookie expiration time
        cookie.setPath("/");    // Set cookie path
        response.addCookie(cookie);
    }

    
}
