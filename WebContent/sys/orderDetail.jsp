<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	
	
<title>点餐管理平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
			订单菜品列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域 -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- è¡¨å¤´-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜名</td>
					<td>单价</td>
					<td>数量</td>
				</tr>
			</thead>
		
			<tbody id="TableData">
				
			 		<tr height="60">
				 		<td>烤乳猪</td>
				 		<td>68.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			 		<tr height="60">
				 		<td>烤乳猪</td>
				 		<td>68.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			 		<tr height="60">
				 		<td>白切鸡</td>
				 		<td>68.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			</tbody>
		</table>
	
		<div id="TableTail" align="center">
			 <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
	</div>
</body>
</html>
