<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加字典分类</title>
<jsp:include page="${request.getContextPath}/includes/include.jsp"></jsp:include>
<script type="text/javascript">
	
	$(document).ready(function(e) {
        showDictionarys();
		
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
	
	function showDictionarys(){
		var url = "${pageContext.request.contextPath}/dictionary/showDict";
		
		$.ajax({
			type:"get",
			url:url,
			success:succFunc
		});
		
		function succFunc(data){
			$.each(data, function(i,n){
				var id = n.dictionaryid;
				var tr = "<tr>";
				tr += "<td><input type = 'checkbox' class = 'checkboxinlist' value='"+ id +"'></td>";
				tr += "<td>" + n.dictionaryname + "</td>";
				tr += "<td>" + n.dictionarycode + "</td>";
				tr += "<td>" + n.note + "</td>";
				tr += "<td><a href = '${pageContext.request.contextPath}/dictContent/contentList/" + id + "'>代码管理</a></td>";
				tr += "</tr>"
				$("#dictList").append(tr);
			});
		}
	}
	
	function addDict(){
	 	var url = "${pageContext.request.contextPath}/jsp/define/addDict.jsp";
		var cWidth = window.screen.availWidth;
		var cHeight = window.screen.availHeight;
		var dWidth=660;
		var dHeight=270;
		var dLeft=(cWidth-dWidth)/2;
		var dTop=(cHeight-dHeight)/2;
		window.open(url,"","height=370,width=700,top="+dTop+",left="+dLeft+",status=no,toolbar=no,menubar=no,location=no,scrollbars=yes");
	}
	 
	function doAfterClose(){
		var uri = "${pageContext.request.contextPath}/jsp/define/dictionaryList.jsp";
		window.location.href = uri;
	}
	
	function deleteDict(){
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
		var url = "${pageContext.request.contextPath}/dictionary/deleteDict/" + dictItem;
		
		$.ajax({
			type:"get",
			url:url,
			success: function(data){
				
			}
				
		});
		location.reload();
	}
</script>
</head>

<body>
    <a href="javascript:addDict()" id="addDict">添加字典</a>
    <a href="javascript:deleteDict()" id="delDict" style="margin-left:10px">删除字典</a>
	<table id="dictList">
    	<thead>
        	<tr>
            	<th>全选<input type="checkbox" id="checkAll" name="CHECKALL"/></th>
                <th>名称</th>
                <th>编码</th>
                <th>描述</th>
                <th>操作</th>
            </tr>
        </thead>
    </table>
</body>
</html>