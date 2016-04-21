<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>仿百度网盘文件上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		//打开浏览器的文件上传
		function openBrows(){
				document.getElementById("fileUp").click();
				setTimeout("getStatus()",2000);
		}
		function getStatus(){
				$.ajax({
					type:"post",
					url:"status.jsp",
					success:function(data){
						eval(data);
					}
				});
		}
		//文件上传
		function doUpload(){
				document.forms[0].submit(); 
		
		}
	</script>
  </head>
  
  <body>
    		<div class="box">
    			<h1>百度网盘多文件带进度条上传</h1>
    			<form method="post" target = "subframe"action="upload" enctype="multipart/form-data">
    				<a href="javascript:void(0)"  onclick="openBrows()">点击上传</a>
    				<input type="file" id="fileUp" name = "file" onchange="doUpload()"  style="display:none"  multiple/>
    			</form>
    			<div id="progressDiv"  style="width:200px; height:20px;border:1px solid red">
    					<div  style="background:red;height:20px; width:20%">
    					</div>
    			</div>
    		</div> 
    		<iframe width="0" name="subframe"></iframe>
  </body>
</html>
