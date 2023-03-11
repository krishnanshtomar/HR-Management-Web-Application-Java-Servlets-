package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class EditDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
int code=0;
try
{
try
{
code=Integer.parseInt(request.getParameter("code"));
}
catch(NumberFormatException numberFormatException)
{
sendBackView(response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
try
{
DesignationDTO designation=designationDAO.getByCode(code);
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var title=frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='';");
pw.println("if(title.length==0)");
pw.println("{");
pw.println("titleErrorSection.innerHTML='Required';");
pw.println("frm.title.focus();");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("function cancelAddition()");
pw.println("{");
pw.println("document.getElementById('cancelAdditionForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left;'><div style='margin-top:16px;margin-bottom:16px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div>    <!-- header ends here -->");
pw.println("<!-- content-section starts here -->");
pw.println("<div style='width:90hw;height:75vh;margin:5px;border:1px solid white'>");
pw.println("<!-- left panel starts here-->");
pw.println("<div style='height:72vh;margin:5px;border:1px solid black;float:left;padding:5px;font-size:20pt'>");
pw.println("<b>Designations<br> </b>");
pw.println("<a href='/styleone/employeesView'>Employees</a> <br> <br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>    <!-- left panel ends here-->");
pw.println("<!-- right panel starts here-->");
pw.println("<div style='height:72vh;margin-left:160px;margin-bottom:5px;margin-right:5px;margin-top:5px;border:1px solid black;padding:5px;'>");
pw.println("<h2>Designation (Edit Module)</h2>");
pw.println("<form method='post' action='/styleone/updateDesignation' onsubmit='return validateForm(this)'>");
pw.println("Designation");
pw.println("<input type='hidden' id='code' name='code' value='"+code+"'>");
pw.println("<input type='text' id='title' name='title' maxlength='35' size='36' value='"+designation.getTitle()+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit' style='float:left;'>Update</button>");
pw.println("<button type='button' onclick='cancelAddition()'>Cancel</button>");
pw.println("</form>");
pw.println("</div>    <!-- right panel ends here-->");
pw.println("</div>    <!-- content-section ends here -->");
pw.println("<!-- footer starts here-->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div>    <!-- footer ends here-->");
pw.println("</div>    <!-- Main container ends here -->");
pw.println("<form id='cancelAdditionForm' action='/styleone/designationsView'>");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
sendBackView(response);
return;
}
}catch(Exception exception)
{
System.out.println(exception.getMessage());    //remove after testing
}
}
private void sendBackView(HttpServletResponse response)
{
try
{
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
//lot of code goes over here from the c:\tomcat9\webapps\styleone>DesignationViewTemplate.html
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png' style='float:left;'></a><div style='margin-top:16px;margin-bottom:16px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div>    <!-- header ends here -->");
pw.println("<!-- content-section starts here -->");
pw.println("<div style='width:90hw;height:75vh;margin:5px;border:1px solid white'>");
pw.println("<!-- left panel starts here-->");
pw.println("<div style='height:72vh;margin:5px;border:1px solid black;float:left;padding:5px;font-size:20pt'>");
pw.println("<b> Designations </b><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>    <!-- left panel ends here-->");
pw.println("<!-- right panel starts here-->");
pw.println("<div style='height:72vh;margin-left:160px;overflow:scroll;margin-bottom:5px;margin-right:5px;margin-top:5px;border:1px solid black;padding:5px;'>");
pw.println("<h2>Designations</h2>");
pw.println("<table border='1' style='font-size:15pt;'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right;padding:5px;'><a href='/styleone/AddDesignation.html'>Add new designation</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:80px;text-align:center'>S.No.</th>");
pw.println("<th style='width:300px;text-align:center'>Designation</th>");
pw.println("<th style='width:200px;text-align:center'>Edit</th>");
pw.println("<th style='width:200px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int x;
int code;
int sno=0;
String title;
DesignationDTO designationDTO;
for(x=0;x<designations.size();x++)
{
sno++;
designationDTO=designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right;'>"+sno+".</td>");
pw.println("<td>"+title+"</td>");
pw.println("<td style='text-align:center;'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center;'><a href='/styleone/confirmDeleteDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>    <!-- right panel ends here-->");
pw.println("</div>    <!-- content-section ends here -->");
pw.println("<!-- footer starts here-->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div>    <!-- footer ends here-->");
pw.println("</div>    <!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());    //remove after testing and setup 500 (internal error page)
}
catch(Exception exception)
{
System.out.println(exception.getMessage());    //remove after testing and setup 500 (internal error page)
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}