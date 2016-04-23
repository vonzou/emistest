<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加字典分类</title>
<jsp:include page="${request.getContextPath}/includes/include.jsp"></jsp:include>
<script type="text/javascript">
	function addDict(){
		var url = "${pageContext.request.contextPath}/dictionary/addDict";
		
		$.ajax({
			type:"post",
			url:url,
			async:false,
			data:$("#addDict").serialize(),
			success: function(data){
				var addSucc = data.addSucc;
				var errorMsg = data.errorMsg;
				if(addSucc){
					alert(errorMsg);
				} else {
					alert(errorMsg);	
				}
			},
			error:function(e){
				alert("post data : " + $("#addDict").serialize());
				//alert("添加字典异常：" + e);
				alert(JSON.stringify(jsonobj)); 
				var jStr = "{ ";
				for(var titem in e){
					jStr += "'"+titem+"':'"+jsonObj[titem]+"',";
				}
				jStr += " }";
				alert(jStr);
			}	
		});	
		
		window.opener.doAfterClose();
		window.close();
	}
</script>
</head>

<body>

	<form id="addDict">
    	<table>
        	<tr>
            	<td>名称</td>
                <td><input type="text" name="dictionaryname"></td>
            </tr>
            <tr>
            	<td>编码</td>
                <td><input type="text" name="dictionarycode"></td>
            </tr>
            <tr>
            	<td>描述</td>
                <td><textarea name="note"></textarea></td>
            </tr>
            <tr>
            	<td>生效</td>
                <td><input type="radio" name="enabledelete" value="1"></td>
                <td>失效</td>
                <td><input type="radio" name="enabledelete" value="0"></td>
            </tr>
            <tr>
                <td colspan="2">
                	<input type="button" onclick="addDict()" value="提交">
                    <input type="reset" value="取消" style="margin-left:10px" onclick="window.close();">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>