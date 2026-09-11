package bmi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * Servlet implementation class BMIServlet
 */
@WebServlet("/BMIServlet")
public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=request.getParameter("name");
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		height = height / 100;
		double bmi =weight/(height*height);
		String Category;
		if (bmi<18.5) {
			Category="underweight";
		}
		else if(bmi<25) {
			Category="Normal";
		}
		else if(bmi<30) {
			Category="Overweight";
		}
		else {
			Category="obese";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bmi";
			String username="root";
			String pwd="Fathima_1603";
			Connection conn=DriverManager.getConnection(url,username,pwd);
			String query ="INSERT INTO bmi_table values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setDouble(2, height);
			ps.setDouble(3, weight);
			ps.setDouble(4, bmi);
			ps.setString(5, Category);
			
			int rows=ps.executeUpdate();
			PrintWriter pw=response.getWriter();
			if(rows == 1) {
				pw.print("Data Stored Succesfully");
			}
			
			PrintWriter pw1=response.getWriter();
			
			pw1.print("Name:" + name + "<br>");
			pw1.printf("BMI Value:" + bmi + "<br>");
			pw1.print("Category" + Category + "<br>" );
			
			ps.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
