package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Employee;
import pojo.Msg;
import service.EmployeeService;

import java.util.List;

/**
 * @ClassName EmployeeController
 * @Description 处理与员工相关的逻辑的控制器
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /*
        展示员工信息（使用分页插件 + Json + ajax）
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Employee> emps = employeeService.getAllEmps();
        PageInfo<Employee> pageInfo = new PageInfo<>(emps, 5);
        Msg result = Msg.success().add("pageInfo", pageInfo);
        return result;
    }
}
