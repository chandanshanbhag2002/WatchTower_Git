<%-- 
    Document   : index
    Created on : May 17, 2017, 10:29:42 PM
    Author     : chandan.shanbhag
--%>

<%@page import="java.util.List"%>
<%@page import="watchtower.gitUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>

<head>
  
         <script src="http://code.jquery.com/jquery-1.11.3.min.js"/>
         <script src="bootstrap.js" type="text/javascript"></script>
         <script src="res/export.js" type="text/javascript"></script>
<link href="res/bootstrap.css" rel="stylesheet" type="text/css"/>

<link href="res/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="res/signin.css" rel="stylesheet" type="text/css"/>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  
    
            <div class="container">
                <center>
                    <img src="res/msi_logo.png" alt=""/>
                
                <br/><br/>
                    <h3 class="form-signin-heading" >GIT to JIRA Bug Tracker</h3>
                    
                </center>
                <form action="getDetail.jsp" method="GET" class="form-signin">
                  <h4>Select The Branch:</h4>
                    <select id="branchname" name="branchname" class="form-control">
                      
                        <%gitUtil g=new gitUtil();
                        int i;    
                        List<String> branches=g.getBranches();
                            for( i=0;i<branches.size();i++){
                                
                            
                        %>
                        
                        <option value="<%=branches.get(i)%>"><%=branches.get(i)%></option>
                         
                        <%}%>
                    </select><h5>Available branches:<%=branches.size()%></h5>
                    <br/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" style="align-content: flex-end" />
                </form>
            </div>
                    <div class="img1" >
<img src="res/Git-Logo-1788C.png" alt="" height="230" width="450"/>
                    </div>
                      <div class="img2">
                          <img src="res/jira.png" alt=""/>
                    </div>
</body>
</html>
