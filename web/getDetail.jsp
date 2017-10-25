<%-- 
    Document   : getDetail
    Created on : May 3, 2017, 10:11:17 AM
    Author     : chandan.shanbhag
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="watchtower.getJiraDetail,watchtower.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>        
    <head>
             <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
            <script src='http://tablesorter.com/__jquery.tablesorter.min.js'></script>
            
              

       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bugs Identified</title>
    </head>
    <body>
      
      <center>
          <a  href="index.jsp"><img src="res/msi_logo.png" alt=""/></a>
      </center>
        <br/>
<center>
          <h1>Bugs Status</h1>
</center>
             <input type="button" text="Export To Excel" id="btnExport" value="Export To Excel" style="float: right"/>
        <table id="tblExport"  class="table table-striped"cellspacing="0" cellpadding="0" > 
            <thead style="cursor: pointer">
                <tr>
           <th>#</th>
           <th>Issue Type</th> 
           <th>Issue Key</th>
           <th>Project Name</th></span>
           <th>Priority</th>
           <th>Severity</th>
           <th>Resolution</th>
           <th>Status</th>
           <th> <span>Summary</th>
                </tr></thead><tbody>
        <%
            response.setIntHeader("Refresh",10);
            int i=0;
        boolean flag=false;
        String Issue_Type,Issue_key,Project_name,Priority,Severity,Resolution,Status,Summary;
        List<String> svnJiraList = new ArrayList();
                String branchname = request.getParameter("branchname");
                
                svnJiraList = parsesvn.getJiraList(branchname);
                int len = svnJiraList.size();
                if(len>=1){flag=true;}
                if(flag){
                for (Iterator it = getJiraDetail.getdetails(svnJiraList).iterator(); it.hasNext();) {
                                      bugList  b = (bugList) it.next();
                                        i++;
                
                Issue_key=b.getIssue_key();
                Issue_Type=b.getIssue_Type();
                Project_name=b.getProject_name();
                Priority=b.getPriority();
                Severity=b.getSeverity();
                Resolution=b.getResolution();
                Status=b.getStatus();
                Summary=b.getSummary();
                if(Status.equalsIgnoreCase("open") || Status.equalsIgnoreCase("to do") || 
                        Status.equalsIgnoreCase("reopened") || Status.equalsIgnoreCase("in progress") || 
                        Status.equalsIgnoreCase("s_assigned.")||Status.equalsIgnoreCase("assigned.")||Status.equalsIgnoreCase("s_reopened.")){
                
                %>
               
               <tr  style="background-color: tomato">
            <td><%=i%></td>
            <td><%=Issue_Type%></td>
            <td><a href="https://metricstreampm.atlassian.net/browse/<%=Issue_key%>" target="_blank"><%=Issue_key%></a></td>
            <td><%=Project_name%></td>
            <td><%=Priority%></td><td><%=Severity%></td>
            <td><%=Resolution%></td><td><%=Status%></td>
            <td><%=Summary%></td>
        </tr>
               
               
                <%}else{%>
       
        <tr >
            <td><%=i%></td>
            <td><%=Issue_Type%></td>
            <td><a href="https://metricstreampm.atlassian.net/browse/<%=Issue_key%>" target="_blank"><%=Issue_key%></a></td>
            <td><%=Project_name%></td>
            <td><%=Priority%></td><td><%=Severity%></td>
            <td><%=Resolution%></td><td><%=Status%></td>
            <td><%=Summary%></td>
        </tr>
         
      <%}}}else{%>
      <td>No Bug Id's found</td>
      <%}%>
        </tbody></table>
        

  <script>
        $(function(){
            $('#tblExport').tablesorter(); 
        });
  </script>
  
                      <div class="img1" >
<img src="res/Git-Logo-1788C.png" alt="" height="230" width="450"/>
                    </div>
                      <div class="img2">
                          <img src="res/jira.png" alt=""/>
                    </div>
        
    </body>
</html>
