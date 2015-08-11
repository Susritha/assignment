package assign14;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AcctOperations
 */
@WebServlet("/AcctOperations")
public class AcctOperations extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcctOperations() {
        super();}
        // TODO Auto-generated constructor stub
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Statement st1=null;
		    Connection con=null;
		    PreparedStatement st=null;
		
	    PrintWriter pw=response.getWriter();
		pw.println("in db operations");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","TIGER");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		int no=Integer.parseInt(request.getParameter("accno"));
		int amt=Integer.parseInt(request.getParameter("amt"));
		String type=request.getParameter("type");
		
		String str="update ACCOUNT_INFO set BALANCE=BALANCE+"+amt+" WHERE ACCNO="+no;
		String str1="update ACCOUNT_INFO set BALANCE=BALANCE-"+amt+" WHERE ACCNO="+no;
	//String s="insert into BANK_USER_TRANSACTION values("+no+",'SYSDATE'"+type+","+amt+")";
		
	
		String s="insert into BANK_USER_TRANSACTION values(?,?,?,?)";
	
		if(type.equals("deposit"))
		{
			try {
				st1=con.createStatement();
				st=con.prepareStatement(s);
				st.setInt(1,no);
				st.setString(2,Today.getCurrentDate());
				st.setString(3,type);
				st.setInt(4,amt);
				st.executeQuery();
				st1.executeUpdate(str);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(type.equals("withdrawl"))
		{
			try {
				st1=con.createStatement();
				st1.executeUpdate(str1);
				st=con.prepareStatement(s);
				st.setInt(1,no);
				st.setString(2,Today.getCurrentDate());
				st.setString(3,type);
				st.setInt(4,amt);
				st.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			pw.println("Enter again");
		}
		
	
	}

	
}
