<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>字典项列表</title>
<jsp:include page="${request.getContextPath}/includes/include.jsp"></jsp:include>
<script type="text/javascript">
	var dictId = "${dictId}";
	$(document).ready(function(e) {
        $("#checkAll").click(function(){
			if($(this).is(":checked")){
				$(".checkboxinlist").each(function(i,n) {
                    n.checked = true;
                });	
			}else {
				$(".checkboxinlist").each(function(i,n) {
                    n.checked=false;
                });	
			}	
		});
    });
	
	function modifyCont(contid){
	 	var url = "${pageContext.request.contextPath}/dictContent/content/" + contid;
		var cWidth = window.screen.availWidth;
		var cHeight = window.screen.availHeight;
		var dWidth=660;
		var dHeight=270;
		var dLeft=(cWidth-dWidth)/2;
		var dTop=(cHeight-dHeight)/2;
		window.open(url,"","height=370,width=700,top="+dTop+",left="+dLeft+",status=no,toolbar=no,menubar=no,location=no,scrollbars=yes");
	}
	 
	function doAfterClose(){
		var uri = "${pageContext.request.contextPath}/dictContent/contentList/" + dictId;
		window.location.href = uri;
	}
	
	function addAfterClose(){
		var uri = "${pageContext.request.contextPath}/dictContent/contentList/" + dictId;
		window.location.href = uri;
	}
	
	function addCont(){
		var url = "${pageContext.request.contextPath}/jsp/define/addDictCont.jsp?dictId=" + dictId;
		var cWidth = window.screen.availWidth;
		var cHeight = window.screen.availHeight;
		var dWidth=660;
		var dHeight=270;
		var dLeft=(cWidth-dWidth)/2;
		var dTop=(cHeight-dHeight)/2;
		window.open(url,"","height=370,width=700,top="+dTop+",left="+dLeft+",status=no,toolbar=no,menubar=no,location=no,scrollbars=yes");
	}
	
	function delCont(){
		var ids = [];
		var values = $("input[class='checkboxinlist']:checked").each(function() {
        	if($(this).val() != ""){
				var itemcode = $(this).val();
				ids.push(itemcode);
			}
        });
		if(values.length < 1){
			alert("未选中任何记录");
			return false;
		}
		console.log("values : " + values);
		$("#delDict").attr("disabled",true); //防止重复提交
		var dictItem = ids.join(',');
		var url = "${pageContext.request.contextPath}/dictContent/delCont/" + dictItem;
		
		$.ajax({
			type:"get",
			url:url,
			async:false,
			success: function(data){
				
			}
		});
		location.reload();
	}
</script>
</head>

<body>
	<a href="javascript:addCont()">添加</a>
    <a href="javascript:delCont()" style="margin-left:10px">删除</a>
	<table>
    	<tr>
        	<th>全选<input type="checkbox" id="checkAll"/></th>
            <th>名称</th>
            <th>状态</th>
            <th>排序号</th>
            <th>操作</th>
        </tr>
        <c:forEach items = "${contList}" var="cont">
        	<tr>
            	<td><input type="checkbox" class="checkboxinlist" value="${cont.contentid}"/></td>
                <td>${cont.itemname}</td>
                <td>
                	<c:if test = "${cont.status == 1}">
                    	<span>生效</span>
                    </c:if>
                    <c:if test = "${cont.status == 0}">
                    	<span style="color:red">失效</span>
                    </c:if>
                </td>
                <td>${cont.sortinfo}</td>
                <td><!--${pageContext.request.contextPath}/dictContent/${cont.contentid}-->
                	<a href="javascript:modifyCont('${cont.contentid}')">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>