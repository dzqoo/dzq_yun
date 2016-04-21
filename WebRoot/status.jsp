<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String progress = (String)session.getAttribute("progress");
	if(null !=progress){
		out.print(progress);
		}
%>