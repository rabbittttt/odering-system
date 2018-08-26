<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
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
			 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
     		<tbody id="TableData">
					<c:choose>
						<c:when test="${not empty requestScope.listFood}">
							
							<c:forEach var="food" items="${requestScope.listFood}">
								<tr>
									<td>${food.id }</td>
									<td>${food.foodName }</td>
									<td>${foodType.typeName }</td>
									<td>${food.price }</td>
									<td>${food.mprice }</td>
									<td>
										<a href="${pageContext.request.contextPath }/food?id=${food.id}&method=viewUpdate" class="FunctionButton">更新</a> 
										<a href="${pageContext.request.contextPath }/food?id=${food.id}&method=delete" class="FunctionButton">删除</a>
									</td>
								</tr>
							</c:forEach>
						
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6">没有你要找的数据，请先保存记录再查看！</td>
							</tr>
						</c:otherwise>
					</c:choose>
				
			</tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton">
		<a href="${pageContext.request.contextPath }/sys/food/food_save.jsp">添加</a>
		   </div> 
    </div> 
</div>
</body>
</html>
