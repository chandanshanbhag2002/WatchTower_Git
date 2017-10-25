package watchtower;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package testpackage;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author chandan.shanbhag
// */
//@WebServlet(name = "getJira", urlPatterns = {"/getJira"})
//public class getJira extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            
//                List<String> svnJiraList = new ArrayList();
//                String svnurl = request.getParameter("svnurl");
//                Long startrev = Long.parseLong(request.getParameter("startrev"));
//                Long endrev = Long.parseLong(request.getParameter("endrev"));
//
//                svnJiraList = parsesvn.getJiraList(svnurl, startrev, endrev);
//                int len = svnJiraList.size();
//        
//
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head><script src=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script><script src=\"res/export.js\" type=\"text/javascript\"></script>");
//                out.println( "<link href='res/bootstrap-theme.css' rel='stylesheet' type='text/css'/>"
//                        + "<link href=\"res/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>");
//                out.println("<link href='res/signin.css' rel='stylesheet' type='text/css'/>"
//                        + "<script src=\"res/bootstrap.js\" type=\"text/javascript\"></script>"); 
//                out.println("<title>BUGS IDENTIFIED</title>");
//                out.println("</head><center>");
//                out.println("<h2>Bugs Identified</h2>");
//                out.println("</center><body>");
//                
//                out.println("<input type='button' text='Export' id='btnExport' value='Export' style=\"float: right\">");
//                
//                out.println("<table id='tblExport' class='table table-striped'> ");
//                out.println("<thead class='thead-inverse'><tr><th>#</th><th>Issue Type</th><th>Issue Key</th><th>Project Name</th><th>Priority</th><th>Severity</th><th>Resolution</th><th>Status</th><th>Summary</th></tr></thead>");
//                            
//                
//                int i=0;
//                for (Iterator it = getJiraDetail.getdetails(svnJiraList).iterator(); it.hasNext();) {
//                                        bugList b = (bugList) it.next();
//                                        i++;
//              out.println("<tbody><tr><td>"+i+"</td><td>"+b.Issue_Type+"</td><td>"+"<a href='https://metricstreampm.atlassian.net/browse/" +b.Issue_key + "'>" +b.Issue_key + "</a>"+"</td><td>"+b.Project_name+"</td><td>"+b.Priority+"</td><td>"+b.Severity+"</td><td>"+b.Resolution+"</td><td>"+b.Status+"</td><td>"+b.Summary+"</td></tr>");
//                }
//                out.println(" </tbody></table></body>");
//                out.println("</html>");
//        }catch(Exception e){System.out.println("Exception Caught:"+e.toString());}
//}
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//    String getresult() {
//        parsesvn p = new parsesvn();
//        return "" + 0;
//    }
//
//}

 