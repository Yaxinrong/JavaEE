// Automatically Generated By godot
import javax.servlet.*;
public class indexjspServlet implements Servlet {
  public void service(ServletRequest req, ServletResponse res) {
res.getWriter().print("<!DOCTYPE html>\n");
res.getWriter().print("<html>\n");
res.getWriter().print("<head>\n");
res.getWriter().print("<meta charset=\"UTF-8\">\n");
res.getWriter().print("<title>Insert title here</title>\n");
res.getWriter().print("</head>\n");
res.getWriter().print("<body>\n");
res.getWriter().print(" <form method=\"POST\" name=\"frmLogin\" action=\"Login\">\n");
res.getWriter().print("   <h1 align=\"center\">JSP</h1>\n");
res.getWriter().print("   <div align=\"center\">\n");
res.getWriter().print("   <table border=1 >\n");
res.getWriter().print("     <tr>\n");
res.getWriter().print("      <td>account</td>\n");
res.getWriter().print("      <td>\n");
res.getWriter().print("       <input type=\"text\" name=\"username\" value=\"\" size=\"20\" maxlength=\"11\" \" />\n");
res.getWriter().print("      </td>\n");
res.getWriter().print("     </tr>\n");
res.getWriter().print("     <tr>\n");
res.getWriter().print("      <td>password</td>\n");
res.getWriter().print("      <td>\n");
res.getWriter().print("       <input type=\"password\" name=\"paw\" value=\"\" size=\"20\" maxlength=\"20\" />\n");
res.getWriter().print("      </td>\n");
res.getWriter().print("     </tr>\n");
res.getWriter().print("     <tr>\n");
res.getWriter().print("      <td>\n");
res.getWriter().print("       <input type=\"submit\" name=\"Submit\" value=\"submit\" />\n");
res.getWriter().print("      </td>\n");
res.getWriter().print("      <td>\n");
res.getWriter().print("       <input type=\"reset\" name=\"Reset\" value=\"reset\" />\n");
res.getWriter().print("      </td>\n");
res.getWriter().print("     </tr>\n");
res.getWriter().print("    </table>\n");
res.getWriter().print("   </div>\n");
res.getWriter().print("  </form>\n");
res.getWriter().print("\n");
res.getWriter().print("</body>\n");
res.getWriter().print("</html>\n");
res.getWriter().print("");
}
  public void destroy() {}
  public void ServletConfig getServletConfig() {return null;}
  public String getServletInfo() {return null;}
  public void init(ServletConfig conf) throws ServletException {}
}
