<%@page import="com.dbcon.Queries"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Swarming 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20131201

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Graphical Password Suffleling</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="table.css" rel="stylesheet">
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="logo">
	<h1><a href="#" class="icon icon-group"><span>Graphical Password Suffleling</span></a></h1>
</div>
<div id="header">
	<div id="menu" class="container">
		<ul>
			<li><a href="UHomePage.jsp" accesskey="1" title="">Homepage</a></li>
			<li  class="current_page_item"><a href="aDViewProfile.jsp" accesskey="1" title="">View Profile</a></li>
			<li><a href="login.jsp" accesskey="2" title="">Logout</a></li>
			
		</ul>
	</div>
</div>
<div id="page-wrapper">
<div id="page" class="container">
	<div id="content">
		<div class="title">
                    <CENTER><H2>VIEW ALL USERS PROFILE</H2></CENTER>  
		<table>
                        <tr><th>NAME</th><th>EMAIL</th><th>MOBILE</th><th>ADDRESS</th></tr>
                    <%
                    
String query="select * from ureg";
                    
 ResultSet r=Queries.getExecuteQuery(query);
 while(r.next()){
  %>
  <tR><td><%=r.getString("name")%></Td>
   <td><%=r.getString("email")%></Td>
    <td><%=r.getString("mobile")%></Td>
     <td><%=r.getString("address")%></Td></tr>
 <% 
 }
                    
                    
                    %>
                    </TR>
                    </table>	
		
		</div>
		</div>
	<div id="sidebar"><a href="#" class="image image-full"><img src="images/9976.png" alt="" /></a></div>
        
</div>
</div>
<div id="featured-wrapper">
	<div id="featured" class="container">
		
</div>
</div>
</body>
</html>
