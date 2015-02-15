<%-- 
    Document   : customer
    Created on : Apr 2, 2013, 4:59:10 PM
    Author     : Nitin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    	<div style="width: 300px;margin: 0 auto 0;">
	   		<h2>Freight Csv Load</h2>
	        <s:form action="addCustomerAction" >
	        	<input type="file"　name="name" label="Name">
	            <s:submit />
	        </s:form>
    	</div>
    </body>
</html>
