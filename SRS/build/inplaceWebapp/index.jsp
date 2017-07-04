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
<title>guitar</title>

<link
	href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
	
<script type="text/javascript" src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"t src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
	$(function() {
		$('#table').bootstrapTable({
			url : '${basePath}queryAll',
			queryParamsType:'', 
			pagination : true,
			sidePagination : 'server',
			toolbar : '#toolbar',
			striped : true,
			showColumns : true,
			showRefresh : true,
			showToggle : true,
			showPaginationSwitch : true,
			idField : 'id',
			clickToSelect : true,
			singleSelect : true,
			pageNumber : 1,
			pageSize : 5,
			pageList : [ 5, 10, 15, 'ALL' ],
			dataField : 'rows',
			totalField : 'total',
			onCheck : function(row) {
				$('#remove').attr('disabled', false)
			},
			onLoadSuccess : function(data) {
				$('#remove').attr('disabled', 'disabled')
			},
			columns : [ {
				radio : true
			}, {
				field : 'students_id',
				title : '学号'
			}, {
				field : 'name',
				title : '姓名'
			}, {
				field : 'email',
				title : '邮箱'
			}, {
				field : 'tel',
				title : '电话'
			}, {
				field : 'grade',
				title : '年级'
			}, {
				field : 'major',
				title : '专业'
			}, {
				field : 'sex',
				title : '性别'
			}, {
				field : 'id',
				title : 'id'
			}]
			
		});
		$('#remove').click(function() {
			var rows = $('#table').bootstrapTable('getSelections');
			if (rows.length == 0) {
				alert('请选择一条记录！')
			} else {
				$.ajax({
					url : '${basePath}delete',
					data : {
						id : rows[0].id
					},
					dataType : 'json',
					method : 'POST',
					success : function(data) {
						
						if (data.success) {
							$('#table').bootstrapTable('refresh');
						} else {
							alert('删除失败！')
						}
					}
				})
			}
		})
		
		$('#submit').click(function(){
  			var url="${pageContext.request.contextPath}/add?"+$('#ff').serialize();
  			
  			$.ajax({
  				url:url,
  				data:{},
  				dataType:'json',
  				method:'POST',
  				success:function(data){
  					$("#close").click();
  					if(data.success){
  						$('#table').bootstrapTable('refresh');
  					}else{
  						alert('添加失败！')
  					}
  				},
  				error:function(){
  					alert('添加失败！请确保所有字段不为空')
  				}
  			})
  		})

	})
</script>
</head>
<body>
	<c:if test="${empty sessionScope.students}">
		<c:redirect url="login.jsp" />
	</c:if>
	<c:if test="${not empty sessionScope.students}">
		<c:forEach items="${sessionScope.students}" var="item">
		<div class="top-bg" style="margin:50px 20px 10px 0;float:right">
			
			    姓名:<c:out value="${item.name}" /> &nbsp;&nbsp;&nbsp;
			
			    学号:<c:out value="${item.students_id}" /> <br/>
			
		</div>
	</c:forEach>
	</c:if>
	<div id="toolbar">
		<button id="add" class="btn btn-success" data-toggle="modal"
			data-target="#myModal">
			<i class="glyphicon glyphicon-plus"></i> 添加
		</button>
		<button id="remove" class="btn btn-danger" disabled>
			<i class="glyphicon glyphicon-remove"></i> 删除
		</button>
	</div>
	<div class="container-fluid">
		<table id="table"></table>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加吉他</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="ff">
						<div class="form-group">
							<label for="builder" class="col-sm-2 control-label">builder</label>
							<div class="col-sm-9">
								<!-- <input name="builder" type="text" class="form-control" id="builder" placeholder="builder"> -->
								<select class="form-control" name="builder" id="builder">
									<option value="JIANGSU">江苏</option>
									<option value="SHANGHAI">上海</option>
									<option value="SHANDONG">山东</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="model" class="col-sm-2 control-label">model</label>
							<div class="col-sm-9">
								<input name="model" type="text" class="form-control" id="model"
									placeholder="model">
							</div>
						</div>
						<div class="form-group">
							<label for="type" class="col-sm-2 control-label">type</label>
							<div class="col-sm-9">
								<select class="form-control" name="type" id="type">
									<option value="ACOUSTIC">ACOUSTIC</option>
									<option value="ELECTRIC">ELECTRIC</option>
									<option value="UNSPECIFIED">UNSPECIFIED</option>
								</select>
								<!-- <input name="type" type="text" class="form-control" id="type" placeholder="type"> -->
							</div>
						</div>
						<div class="form-group">
							<label for="backWood" class="col-sm-2 control-label">backWood</label>
							<div class="col-sm-9">
								<!-- <input name="backWood" type="text" class="form-control" id="backWood" placeholder="backWood"> -->
								<select class="form-control" name="backWood" id="backWood">
									<option value="CAMPHOR">CAMPHOR</option>
									<option value="BRICH">BRICH</option>
									<option value="KOREANPINE">KOREANPINE</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="topWood" class="col-sm-2 control-label">topWood</label>
							<div class="col-sm-9">
								<!-- <input name="topWood" type="text" class="form-control" id="topWood" placeholder="topWood"> -->
								<select class="form-control" name="topWood" id="topWood">
									<option value="CAMPHOR">CAMPHOR</option>
									<option value="BRICH">BRICH</option>
									<option value="KOREANPINE">KOREANPINE</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputAmount" class="col-sm-2 control-label">price</label>
							<div class="input-group col-sm-9">
								<div class="input-group-addon">¥</div>
								<input type="number" class="form-control" min=0
									id="exampleInputAmount" placeholder="price" name="price">
								<div class="input-group-addon">.00</div>
							</div>
						</div>
						<div class="form-group">
							<label for="numStrings" class="col-sm-2 control-label">numStrings</label>
							<div class="input-group col-sm-9">
								<input type="number" class="form-control" min=0
								id="numStrings" placeholder="numStrings" name="numStrings">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="close" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="submit" type="button" class="btn btn-primary">添加</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>