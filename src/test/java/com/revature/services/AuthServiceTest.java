package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.UserDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.models.User;
@SuppressWarnings("unused")
public class AuthServiceTest {
	
	private static AuthService authService;
	private static UserService userService;
	private static EmployeeService employeeService;
	private static UserDAO userDAO;
	private static EmployeeDAO employeeDAO;
	private Employee EMPLOYEE_TO_REGISTER;
	private Employee GENERIC_EMPLOYEE_1;
	private Employee GENERIC_FINANCE_MANAGER_1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		authService = new AuthService();
		employeeService = mock(EmployeeService.class);
		employeeDAO = mock(EmployeeDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {
//		EMPLOYEE_TO_REGISTER = new Employee(0, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
//		GENERIC_EMPLOYEE_1 = new Employee(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
//		GENERIC_FINANCE_MANAGER_1 = new Employee(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
		EMPLOYEE_TO_REGISTER = new Employee(0, "genericEmployee1", "genericPassword", 1);
		GENERIC_EMPLOYEE_1 = new Employee(1, "genericEmployee1", "genericPassword", 1);
		GENERIC_FINANCE_MANAGER_1 = new Employee(1, "genericManager1", "genericPassword", 2);
	}

	@Test
	public void testRegisterFailsWhenUsernameIsTaken() throws Exception {
		when(employeeService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
		
		assertThrows(UsernameNotUniqueException.class,
			() -> authService.register(EMPLOYEE_TO_REGISTER)
		);

		verify(employeeService).getByUsername(EMPLOYEE_TO_REGISTER.getEmployee_username());
		verify(employeeDAO, never());
		EmployeeDAO.submitEmployee(EMPLOYEE_TO_REGISTER);
	}

	@Test
	public void testRegisterPassesWhenUsernameIsNotTaken() throws Exception {
		when(employeeService.getByUsername(anyString())).thenReturn(Optional.empty());
		when(EmployeeDAO.submitEmployee(anyObject())).thenReturn(GENERIC_EMPLOYEE_1);
		
		assertEquals(GENERIC_EMPLOYEE_1, authService.register(EMPLOYEE_TO_REGISTER));

		verify(employeeService).getByUsername(EMPLOYEE_TO_REGISTER.getEmployee_username());
		verify(employeeDAO);
		EmployeeDAO.submitEmployee(EMPLOYEE_TO_REGISTER);
	}

	@Test
	public void testRegisterFailsWhenRegistrationIsUnsuccessful() {
		when(EmployeeDAO.submitEmployee(anyObject())).thenThrow(new RegistrationUnsuccessfulException());

		assertThrows(RegistrationUnsuccessfulException.class,
				() -> authService.register(EMPLOYEE_TO_REGISTER)
		);
	}

	@Test
	public void testRegisterFailsWhenIdIsNonZero() {
		EMPLOYEE_TO_REGISTER.setE_id(1000);

		assertThrows(NewUserHasNonZeroIdException.class,
				() -> authService.register(EMPLOYEE_TO_REGISTER)
		);
	}

	@Test
	public void testLoginPassesWhenUsernameDoesExistAndPasswordMatches() throws Exception {
		when(employeeService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

		assertEquals(GENERIC_EMPLOYEE_1, authService.login(GENERIC_EMPLOYEE_1.getEmployee_username(), GENERIC_EMPLOYEE_1.getEmployee_password()));

		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getEmployee_username());
	}
}
