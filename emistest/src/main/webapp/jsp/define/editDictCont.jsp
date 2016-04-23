<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑字典项</title>
<jsp:include page="${request.getContextPath}/includes/include.jsp"></jsp:include>
<script type="text/javascript">
	var dictID = "${dictCont.dictionaryid}";
	var contid = "${dictCont.contentid}";
	function editCont(){
		var url = "${pageContext.request.contextPath}/dictContent/editCont";
		$.ajax({
			type:"get",
			url:url,
			async:false,
			data:$("#editCont").serialize(),
			success: function(data){
				var editSucc = data.editSucc;
				var errorInfo = data.errorInfo;
				if(editSucc){
					alert(errorInfo);
				} else {
					console.log("修改失败，e = " + errorInfo);
					alert("修改失败");
				}
			}
		});
		window.opener.doAfterClose();	
		window.close();
	}
</script>
</head>

<body>
	<form id="editCont">
    <input type="hidden" name="contentid" value="${dictCont.contentid}"/>
	<table>
    	<tr>
        	<td>名称</td>
            <td><input type="text" name="itemname" value="${dictCont.itemname}"/></td>
        </tr>
        <tr>
        	<td>值</td>
            <td><input type="text" name="itemvalue" value="${dictCont.itemvalue}"/></td>
        </tr>
        <tr>
        	<td>排序号</td>
            <td><input type="text" name="sortinfo" value="${dictCont.sortinfo}"/></td>
        </tr>
        <tr>
        	<td>说明</td>
            <td><input type="text" name="description" value="${dictCont.description}"/></td>
        </tr>
        <tr>
        	<td>状态</td>
            <td>
                <c:choose>
                	<c:when test = "${dictCont.status == '1'}">
                    	生效<input type="radio" name="status" value="1" checked="checked"/>
            			失效<input type="radio" name="status" value="0"/>
                    </c:when>
                    <c:otherwise>
                        生效<input type="radio" name="status" value="1"/>
                        失效<input type="radio" name="status" value="0" checked="checked"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td colspan="2">
            	<input type="button" value="提交" onclick="editCont()"/>
                <input type="button" value="取消" onclick="window.close()" style="margin-left:10px"/>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>