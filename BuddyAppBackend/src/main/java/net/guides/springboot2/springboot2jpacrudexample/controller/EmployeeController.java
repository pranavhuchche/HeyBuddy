package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return new ArrayList<>();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			{
		Employee employee = new Employee();
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return null;
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) {
		Employee employee = new Employee();
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = null;
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			{
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
