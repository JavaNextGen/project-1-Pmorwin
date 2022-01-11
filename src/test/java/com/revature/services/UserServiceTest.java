package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.repositories.EmployeeDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.models.User;

public class UserServiceTest {

    private static EmployeeService employeeService;
    private static EmployeeDAO employeeDAO;

    private Employee GENERIC_EMPLOYEE_1;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        employeeService = new EmployeeService();
        employeeDAO = mock(EmployeeDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        GENERIC_EMPLOYEE_1 = new Employee(1, "genericUsername", "genericPassword", 1);
    }

    @Test
    public void testGetByUsernamePassesWhenUsernameExists() throws Exception {
        when(employeeDAO.getByUsername("genericUsername")).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

        assertEquals(Optional.of(GENERIC_EMPLOYEE_1), employeeService.getByUsername(GENERIC_EMPLOYEE_1.getEmployee_username()));

        verify(employeeDAO).getByUsername(GENERIC_EMPLOYEE_1.getEmployee_username());
    }
}