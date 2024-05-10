package in.bushansirgur.springboot.crudapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import in.bushansirgur.springboot.crudapi.dao.EmployeeDAO;
import in.bushansirgur.springboot.crudapi.model.Employee;
import in.bushansirgur.springboot.crudapi.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDAO employeeDAO; // Mock the DAO for isolation

    @Test
    public void testGetEmployees_ReturnsEmptyList() {
        // Mock DAO behavior to return an empty list
        List<Employee> emptyList = Collections.emptyList();
        Mockito.when(employeeDAO.get()).thenReturn(emptyList);

        // Call the service method
        List<Employee> employees = employeeService.get();

        // Assert that an empty list is returned
        assertThat(employees).isEmpty();
    }

    @Test
    public void testGetEmployees_ReturnsListOfEmployees() {
        // Mock DAO behavior to return a list of employees
        List<Employee> expectedEmployees = createSampleEmployees();
        Mockito.when(employeeDAO.get()).thenReturn(expectedEmployees);

        // Call the service method
        List<Employee> employees = employeeService.get();

        // Assert that the returned list is not null or empty
        //assertThat(employees).isNotNull();
        assertThat(employees).isNotEmpty();

        // Assert that the returned list matches the expected employees (optional)
        // You can use more specific assertions to verify employee details if needed
        // assertThat(employees).isEqualTo(expectedEmployees);
    }

    @Test(expected = Exception.class) // Expect an exception if DAO throws one
    public void testGetEmployees_ThrowsException() throws Exception {
        // Mock DAO behavior to throw an exception
        Mockito.when(employeeDAO.get()).thenThrow(new Exception("Simulated exception"));

        // Call the service method (expect an exception)
        employeeService.get();
    }

    private List<Employee> createSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John Doe", "john.doe@example.com"));
        employees.add(new Employee(2L, "Jane Smith", "jane.smith@example.com"));
        return employees;
    }
}
