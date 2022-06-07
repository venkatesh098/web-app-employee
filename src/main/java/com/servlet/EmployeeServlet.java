package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import com.mave.employeepro.service.EmployeeServiceImpl;
import com.maven.employeepro.DAO.EmployeeDAOServiceImpl;
import com.maven.employeepro.employeeDTO.EmployeeDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public EmployeeServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//it will return string we need to convert integer
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String name =  request.getParameter("name");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		
		//response.getWriter().print("Employee details"+"\n"+"Employee Id : "+empId+"\n"+"Employee Name :"+name+"\n"+"Employee Salary :"+salary);
		EmployeeDTO emp = new EmployeeDTO(empId,name,salary);
		EmployeeServiceImpl empDAOImpl = new EmployeeServiceImpl();
		
		

	   Optional<EmployeeDTO> addEmploye = empDAOImpl.addEmployee(emp);
	   List<EmployeeDTO> employees = empDAOImpl.getEmployees();
	   PrintWriter out = response.getWriter();
	   
	   if(addEmploye.isPresent()) {
		  // response.getWriter().print("Employee details"+empId+name+salary);
		   
			   
			   out.print("<html>");
			   out.print("<body bgColor=''>");
			   out.print("<h1 style='color:green'>Hurray! Employee added successfully</h1>");
			   out.print("<table border='1'>");
			   out.print("<tr>");
			   out.print("<th>Employee Id</th>");
			   out.print("<th>Employee Name</th>");
			   out.print("<th>Employee Salary</th>");
			   out.print("</tr>");
			   for(EmployeeDTO empobj : employees ) {
				   out.print("<tr>");
				   out.print("<td>"+empobj.getEmpId()+"</td>");
				   out.print("<td>"+empobj.getName()+"</td>");
				   out.print("<td>"+empobj.getSalary()+"</td>");
				   out.print("</tr>");
			   }
			   out.print("</table>");
			   out.print("</body>");
			   out.print("</html>");
			   
			 //  out.print("Employee ID  :"+empobj.getEmpId());
			  // out.print("Employee Name :"+empobj.getName());
			   //out.print("Employee Salary :"+empobj.getSalary());
			   
		   
		   
	   }
		
	}

}
