<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link href="/easyui/themes/metro-green/easyui.css" rel="stylesheet">
<link href="/easyui/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>


<style type="text/css">
	.footer{
		width:100%;
		text-align:center;
		line-hight:35px;
	}
	.top-bg{
		
		height:80px;
	}
</style>

<script>
$(function(){

			 $('#dg').datagrid({
				selectOnCheck:true,
				columns:[[    
					{field:'id',title:'序号',width:60},    
					{field:'students_id',title:'学号',width:100%$},    
					{field:'name',title:'姓名',width:100%$},
					{field:'email',title:'邮箱',width:100%$},
					{field:'sex',title:'性别',width:100%$},
					{field:'school',title:'学院',width:100%$},
					{field:'grade',title:'年级',width:100%$},    
					{field:'major',title:'专业',width:100%$},
					{field:'time',title:'创建时间',width:100%$},
					{field:'state',title:'状态',width:100%$}
				]]    
			 });
			var pager = $('#dg').datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				showPageList:true,
				pageSize:10,
				url:'query',
				pageList: [10, 15, 50],
				beforePageText: '第',//页数文本框前显示的汉字
				afterPageText: '页    共 {pages} 页',
				displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
            	
				buttons:[{
					iconCls:'icon-search',
					text:'搜索',
					handler:function(){
						
					}
				},{
					iconCls:'icon-add',
					text:'添加',
					handler:function(){
						$('#dlg').dialog('open').dialog('center').dialog('setTitle','添加学生');
						$('#fm').form('clear');
						url = 'save_user.php';

					}
				},{
					iconCls:'icon-edit',
					text:'编辑',
					handler:function(){
							var row = $('#dg').datagrid('getSelected');
							if (row){
								$('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑学生');
								$('#fm').form('load',row);
								url = 'updateStudents?'+$("#fm").serialize();
							}
					}
				}],
				onBeforeRefresh:function(){
					alert('before refresh');
					return true;
				}
			});
			var icon2text = ["首页","上一页","下一页","尾页"];
        $(".pagination").find("td:eq(2),td:eq(3),td:eq(9),td:eq(10)").each(function(i){
            $(this).find(".l-btn-text").html(icon2text[i]);
        });
});

function saveUser(){
	var url="${basePath}addStudents?"+$("#fm").serialize();
	$('#fm').form('submit',{
        url: url,
        onSubmit: function(){
             return $(this).form('validate');
           },
        success: function(result){
        	var result = eval('('+result+')');
            if (result.errorMsg){
                  $.messager.show({
                  		title: 'Error',
                   		msg: result.errorMsg
                    });
            } 
            else {
                 $('#dlg').dialog('close');        // close the dialog
                 $('#dg').datagrid('reload');    // reload the user data
             }
           }
       });
}

function dialogClose(obj){
	$(obj).window('close');
	return false;
}
</script>
<script>

	
	
</script>
</head>
<body class="easyui-layout" style="width: 100%;height: 100%">
	//上侧
	<div region="north" border="true" split="true" style="overflow: hidden;height: 60px;">
	<c:if test="${empty sessionScope.students}">
		<c:redirect url="login.jsp" />
	</c:if>
	<c:if test="${not empty sessionScope.students}">
		<c:forEach items="${sessionScope.students}" var="item">
		<div class="top-bg" style="margin:15px 0px 10px 20px;float:left; font-size:20px;">
		<strong>选课系统</strong>
		</div>
		<div class="top-bg" style="margin:15px 50px 10px 0;float:right">
			
			    姓名:<c:out value="${item.name}" /> &nbsp;&nbsp;&nbsp;
			
			    学号:<c:out value="${item.id}" /> 
			<a onclick="return exitLogin()" href="exitLogin">退出登录</a>
			<div id="exit-wind" class="easyui-dialog" title="My Dialog" style=" display: none;overflow: hidden;width:400px;height:200px;"
			    data-options="iconCls:'icon-save',resizable:true,modal:true" closed="true"
			    toolbar="#dlg-toolbar" buttons="#dlg-buttons">
			    Dialog Content.
			    <div id="dlg-buttons">
					<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:alert('Ok')">Ok</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="return dialogClose(this)">Cancel</a>
				</div>
			</div>
		</div>
	</c:forEach>
	</c:if>
	
	</div>

	//下侧
	<div region="south" border="true" split="true" style="overflow: hidden;height: 40px">
		<div class="footer">版权所有：<a href=""></a></div>
    </div>

	//左侧
    <div region="west" split="true" title="导航菜单" style="width: 200px;">
		//导航栏
        <div id="aa" class="easyui-accordion" style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">

            <div title="学生管理" iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree">
                    <li>
                        <span><a onclick="addTab('所有学生','index.jsp')" href="#">学生管理</a></span>
                    </li>
                    <li>
                        <span><a href="#">File21</a></span>
                    </li>
                </ul>
            </div>
            <div title="教师管理" iconcls="icon-reload"  style="padding: 10px;">
                <ul class="easyui-tree">
                	<li>
                		<span><a href="#">教师管理</a></span>
                	</li>
                </ul> 
            </div>
        </div>
    </div>

	//中部
    <div id="mainPanle" region="center" style="overflow: hidden;width: 100%;height: 100%">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			 
            <div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
				
				<div id="dlg" class="easyui-dialog" style="width:400px"
						closed="true" buttons="#dlg-buttons1">
					<form id="fm" method="post" novalidate class="easyui-form" style="margin:0;padding:20px 50px">
						<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">学生信息</div>
						<div style="margin-bottom:10px">
							<input name="students_id" class="easyui-textbox" data-options="required:true" label="学号" style="width:100%">
						</div>
						<div style="margin-bottom:10px">
							<input name="name" class="easyui-textbox" data-options="required:true" label="姓名:" style="width:100%">
						</div>
						<div style="margin-bottom:10px">
							<input name="password" class="easyui-textbox" type="password" data-options="required:true" label="密码:" style="width:100%">
						</div>
						<div style="margin-bottom:10px">
							<input name="repassword" class="easyui-textbox" type="password" data-options="required:true" label="确认密码:" style="width:100%">
						</div>
						<div style="margin-bottom:10px">
							<input name="email" class="easyui-textbox" data-options="required:true,validType:'email'" label="邮箱:" style="width:100%">
						</div>
						<div style="margin-bottom:10px">
							<input name="school" class="easyui-textbox" data-options="required:true"  label="学院:" style="width:100%">
						</div>
						<div style="margin-bottom:10px">
							<input name="sex" class="easyui-textbox" data-options="required:true" label="性别:" style="width:100%">
						</div>
					</form>
				</div>
				<div id="dlg-buttons1">
					<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
				</div>

				<div  id="dg" title="学生信息" class="easyui-datagrid"
						url="query" striped="true"  loadMsg="正在加载"
						iconCls="icon-save" pagination="true"
						singleSelect="true"  style="width:1000px;margin: 20px;padding: 20px;width:100%;height:100%;">
					
					<table>
						<thead>
							<tr>
								<th field="id" >序号</th>
								<th field="students_id" align="right">学号</th>
								<th field="name"  align="left">姓名</th>
								<th field="email"  align="left">邮箱</th>
								<th field="school" align="left">学院</th>
								<th field="sex"  align="center">性别</th>
								<th field="tel"  align="right">电话</th>
								<th field="grade"  align="left">年级</th>
								<th field="major"  align="left">专业</th>
								<th field="time"  align="left">创建时间</th>
								<th field="state"  align="center">状态</th>
							</tr>
						</thead>
					</table>
					
					
            	</div>
            </div>

        </div>
    </div>

<script>
	function addTab(title, url){
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		$('#tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
}
</script>	
</body>
</html>