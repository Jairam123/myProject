/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-27 14:14:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("  <title>Login Form</title>\n");
      out.write("  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"Css/style.css\">\n");
      out.write("  </head>\n");
      out.write("<body>\n");
      out.write("<h1 style=\"color:blue;\"><strong>WELCOME TO CUSTOMER COMPLAINT SERVICE</strong></h1>\n");
      out.write("<div class=\"form\">\n");
      out.write("      <ul class=\"tab-group\">\n");
      out.write("        <li><a href=\"signUp.action\">Sign Up</a></li>\n");
      out.write("        <li class=\"tab active\"><a href=\"#login\">Log In</a></li>\n");
      out.write("      </ul>\n");
      out.write("        <div id=\"login\">   \n");
      out.write("          \n");
      out.write("          <form action=\"logIn\" id=\"logInForm\"method=\"post\">\n");
      out.write("            <div class=\"field-wrap\">\n");
      out.write("            <label>\n");
      out.write("             Email<span class=\"req\">*</span>\n");
      out.write("            </label>\n");
      out.write("            <input type=\"email\"required autocomplete=\"off\" id=\"email\" name=\"email\"/> \n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          <div class=\"field-wrap\">\n");
      out.write("            <label>\n");
      out.write("              Password<span class=\"req\">*</span>\n");
      out.write("            </label>\n");
      out.write("            <input type=\"password\"required autocomplete=\"off\" id=\"password\" name=\"password\"/>\n");
      out.write("          </div>\n");
      out.write("          <p class=\"forgot\"><a href=\"forgot.action\">Forgot Password?</a></p><br>\n");
      out.write("          <p class=\"change\"><a href=\"changePassword.jsp\">Change Password?</a></p>\n");
      out.write("          <button class=\"button button-block\" id=\"logIn\">Log In</button>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("</div> <!-- /form -->\n");
      out.write("<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n");
      out.write("<script src=\"Js/index.js\"></script>\n");
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
