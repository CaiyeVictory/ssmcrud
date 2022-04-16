package service;

import dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Employee;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmps() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
