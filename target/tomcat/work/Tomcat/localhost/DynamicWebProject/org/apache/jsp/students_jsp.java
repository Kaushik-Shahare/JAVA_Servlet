/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-10-22 16:40:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.example.models.Student;

public final class students_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Student List</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"text-align: center;\">\n");
      out.write("<h2>Student List</h2>\n");
      out.write("\n");
      out.write("<form method=\"post\" action=\"students\">\n");
      out.write("    <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("    Name: <input type=\"text\" name=\"name\" required>\n");
      out.write("    Email: <input type=\"email\" name=\"email\" required>\n");
      out.write("    <input type=\"submit\" value=\"Add Student\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<table border=\"1\" style=\"text-align: center;\">\n");
      out.write("    <tr>\n");
      out.write("        <th>ID</th>\n");
      out.write("        <th>Name</th>\n");
      out.write("        <th>Email</th>\n");
      out.write("        <th>Actions</th>\n");
      out.write("    </tr>\n");
      out.write("    ");

        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student student : students) {
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print( student.getId() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( student.getName() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( student.getEmail() );
      out.write("</td>\n");
      out.write("        <td>\n");
      out.write("            <form method=\"post\" action=\"students\" style=\"display:inline;\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"update\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( student.getId() );
      out.write("\">\n");
      out.write("                <input type=\"text\" name=\"name\" value=\"");
      out.print( student.getName() );
      out.write("\" required>\n");
      out.write("                <input type=\"email\" name=\"email\" value=\"");
      out.print( student.getEmail() );
      out.write("\" required>\n");
      out.write("                <input type=\"submit\" value=\"Update\">\n");
      out.write("            </form>\n");
      out.write("            <form method=\"get\" action=\"students\" style=\"display:inline;\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( student.getId() );
      out.write("\">\n");
      out.write("                <input type=\"submit\" value=\"Delete\">\n");
      out.write("            </form>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");

            }
        }
    
      out.write("\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
