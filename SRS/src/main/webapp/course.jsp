<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no"/>
<title>课程中心</title>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet" />
<link title="" href="css/style.css" rel="stylesheet" type="text/css"  />
<link title="blue" href="css/dermadefault.css" rel="stylesheet" type="text/css"/>
<link title="green" href="css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
<link title="orange" href="css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
<link href="css/templatecss.css" rel="stylesheet" title="" type="text/css" />
<script src="script/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="script/jquery.cookie.js" type="text/javascript"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css"/>
	
<script type="text/javascript" src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>


<script type="text/javascript">
 $(function() {
	    $('#table').bootstrapTable('destroy');
		$('#table').bootstrapTable({
			url : '/course/listAllCourse',//请求后台的URL（*）
			queryParamsType:'', 
			striped: true,    //是否显示行间隔色                   //是否显示行间隔色
			sidePagination : 'server', //分页方式：client客户端分页，server服务端
			toolbar : '#toolbar',
			detailView: true, //是否显示父子表
			striped : true,
			editable: true,
			showColumns : true,  //是否显示所有的列
			showRefresh : true,  //是否显示刷新按钮
			showToggle : true,
			showPaginationSwitch : true,
			idField : 'courseNo',
			clickToSelect : true, //是否启用点击选中行
			search : true,
			searchOnEnterKey: true,
// 			sortOrder :　'asc',
			singleSelect : true,
			pagination : true,  //是否显示分页（*）
			pageNumber : 1,    //初始化加载第一页，默认第一页
			pageSize : 3,       //每页的记录行数（*）
			pageList : [ 3, 6, 10, 'ALL' ],  //可供选择的每页的行数（*）
			dataField : 'rows',
			totalField : 'total',
			toolbarAlign: "left",//工具栏对齐方式
			sortable: true,  //是否启用排序
			queryParams : function(params) {
				params.sortName = this.sortName;
				params.sortOrder = this.sortOrder;
				params.pageSize = this.pageSize;
				params.pageNumber = this.pageNumber;
				params.search = $('.search input').val();
				return params
				},
			onCheck : function(row) {
				$('#remove').attr('disabled', false)
			},
			onLoadSuccess : function(data) {
				console.log(data);
				$('#remove').attr('disabled', 'disabled')
			},
			columns : [ {
				radio : true
			},  {
				field : 'courseNo',
				title : '课程编号'
			},{
				field : 'courseName',
				title : '课程名字'
			}, {
				field : 'credits',
				align:'center',
				title : '课程学分'
			}, {
				align:'center',
				title : '添加班次'
// 				formatter : function (value,row,index){
// 						return '<a id="'+row.courseNo+'"  onclick="addCourseId(\''+ row.courseNo +'\')" class="add_btn btn btn-default" " data-toggle="modal"'+
// 						'data-target="#addSection"> 添加班次</a>'
	            }],
			onExpandRow: function (index, row, $detail) {
				childTable(index, row, $detail);
			}
		});
		// 子表
		function childTable(index, row, $detail){
			 	var parentid = row.courseNo;
			    var group_com = $detail.html('<table></table>').find('table');
			    $(group_com).attr("id","childtable");
			    $('#childtable').bootstrapTable('destroy');
			    $('#childtable').bootstrapTable({
			    	url: '/section/getSectionByCourseNo',
			    	method: 'get',
			    	queryParams: { courseNo: parentid },
			    	ajaxOptions: { courseNo: parentid },
			    	sidePagination : 'server',
			    	clickToSelect: true,
			    	singleSelect : true,
			    	cache :　false,
			    	idField : 'sectionNo',
			    	uniqueId: "",
			    	dataField : "rows",
			    	onLoadSuccess : function(data) {
					},
					onCheck : function(row) {
						$('#remove1').attr('disabled', false)
					},
					onLoadSuccess : function(data) {
						console.log(data);
						$('#remove1').attr('disabled', 'disabled')
					},
			        columns: [{
						radio : true
					},{
			            field: 'representedCourse.courseNo',
			            title : '课程编号'
			        },{
			            field: 'sectionNo',
			            title : '班次编号'
			        },
			        {
			            field: 'instructor.id',
			            title : '教师编号'
			        },
			        {
			            field: 'dayOfWeek',
			            title : '星期'
			        },
			        {
			            field: 'timeOfDay',
			            title : '时间'
			        },
			        {
			            field: 'room',
			            title : '教室'
			        },
			        {
			            field: 'seatingCapacity',
			            title : '容量'
			        }]
			    });
		}
		


		
		$('#remove').click(function() {
			var rows = $('#table').bootstrapTable('getSelections');
			if (rows.length == 0) {
				alert('请选择一条记录！')
			} else {
				confirm('真的要删除吗？')
				$.ajax({
					url : '/course/delete',
					data : {
						courseNo : rows[0].courseNo
					},
					dataType : 'json',
					method : 'post',
					success : function(data) {
						
						if (data.success) {
							$('#table').bootstrapTable('refresh');
						} else {
							alert('删除失败！')
						}
					}
				})
			}
		});

		
		$('#remove1').click(function() {
			var rows = $('#childtable').bootstrapTable('getSelections');
			if (rows.length == 0) {
				alert('请选择一条记录！')
			} else {
				confirm('真的要删除吗？')
				$.ajax({
					url : '/section/deleteSection',
					data : {
						sectionNo : rows[0].sectionNo
					},
					dataType : 'json',
					method : 'post',
					success : function(data) {
						
						if (data.success) {
							$('#table').bootstrapTable('refresh');
						} else {
							alert('删除失败！')
						}
					}
				})
			}
		});

		
		$('#addcourse').click(function(){
  			$.ajax({
  				url:"/course/addCourse",
  				data:$('#ff').serialize(),
  				dataType:'json',
  				method:'post',
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
  		});
  		
		$('#addsection').click(function(){
  			$.ajax({
  				url:"/section/addSection",
  				data:$('#ss').serialize(),
  				dataType:'json',
  				method:'get',
  				success:function(data){
  					$("#close2").click();
  					if(data.success){
  						$('#childtable').bootstrapTable('refresh');
  					}else{
  						alert('添加失败！')
  					}
  				},
  				error:function(){
  					alert('添加失败！请确保所有字段不为空')
  				}
  			})
  		});
		$('#add1').click(function() {
			var rows = $('#table').bootstrapTable('getSelections');
			if (rows.length == 0) {
				alert('请选择一条记录！');
				return false;
			} else {
				$('#courseNo2').attr('value',rows[0].courseNo);
				$('#courseId_add').attr('value',rows[0].courseNo);
				return true;
			}
			
		});

		
		$('#reset').click(function() {
			var rows = $('#table').bootstrapTable('getSelections');
			if (rows.length == 0) {
				alert('请选择一条记录！');
				return false;
			} else {
				$('#courseNo1').attr('value',rows[0].courseNo);
				$('#courseName1').attr('value',rows[0].courseName);
				$('#credits1').attr('value',rows[0].credits);
				return true;
			}
			
		});

		
		$('#resetSec').click(function() {
			var rows1 = $('#childtable').bootstrapTable('getSelections');
			if (rows1.length == 0) {
				alert('请选择一条记录！');
				return false;
			} else {
				$('#sectionNo1').attr('value',rows1[0].sectionNo);
				$('#courseNo3').attr('value',rows1[0].representedCourse.courseNo);
				$('#courseNo4').attr('value',rows1[0].representedCourse.courseNo);
				$('#dayOfWeek1').attr('value',rows1[0].dayOfWeek);
				$('#timeOfDay1').attr('value',rows1[0].timeOfDay);
				$('#room1').attr('value',rows1[0].room);
				$('#seatingcapacity1').attr('value',rows1[0].seatingCapacity);
				return true;
			}
			
		});

		$('#writeSection').click(function(){
	  			$.ajax({
	  				url:"/section/resetSection",
	  				data:$('#rs').serialize(),
	  				dataType:'json',
	  				method:'POST',
	  				success:function(data){
	  					$("#close3").click();
	  					if(data.success){
	  						$('#childtable').bootstrapTable('refresh');
	  					}else{
	  						alert('修改失败！')
	  					}
	  				},
	  				error:function(){
	  					alert('修改失败！请确保所有字段不为空')
	  				}
	  			})
	  		})



  		
  			$('#resetCourse').click(function(){
  			$.ajax({
  				url:"/course/resetCourse",
  				data:$('#rr').serialize(),
  				dataType:'json',
  				method:'POST',
  				success:function(data){
  					$("#close1").click();
  					if(data.success){
  						$('#table').bootstrapTable('refresh');
  					}else{
  						alert('修改失败！')
  					}
  				},
  				error:function(){
  					alert('修改失败！请确保所有字段不为空')
  				}
  			})
  		})

	})
</script>
</head>

<body>
<nav class="nav navbar-default navbar-mystyle navbar-fixed-top">
  <div class="navbar-header">
    <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> 
     <span class="icon-bar"></span> 
     <span class="icon-bar"></span> 
     <span class="icon-bar"></span> 
    </button>
    <a class="navbar-brand mystyle-brand"><span class="glyphicon glyphicon-home"></span></a> </div>
  <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
      <li class="li-border"><a class="mystyle-color" href="#">管理选课中心</a></li>
    </ul>
    
    <ul class="nav navbar-nav pull-right">
       <li class="li-border">
          <a href="#" class="mystyle-color">
            <span class="glyphicon glyphicon-bell"></span>
            <span class="topbar-num">0</span>
          </a>
      </li>
       <li class="li-border dropdown"><a href="#" class="mystyle-color" data-toggle="dropdown">
      <span class="glyphicon glyphicon-search"></span> 搜索</a>
         <div class="dropdown-menu search-dropdown">
            <div class="input-group">
                <input type="text" class="form-control">
                 <span class="input-group-btn">
                   <button type="button" class="btn btn-default">搜索</button>
                </span>
            </div>
         </div>
      </li>
      <li class="dropdown li-border"><a href="#" class="dropdown-toggle mystyle-color" data-toggle="dropdown">安排选课中心<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">安排课程班次</a></li>
          <li class="divider"></li>
          <li><a href="#">班次学生</a></li>
          <li class="divider"></li>
          <li><a href="#">学生成绩</a></li>
          <li class="divider"></li>
          <li><a href="#">我的班次</a></li>
        </ul>
      </li>
      <li class="dropdown li-border"><a href="#" class="dropdown-toggle mystyle-color" data-toggle="dropdown">${professor.email}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="teacherlogin.jsp">退出</a></li>
        </ul>
      </li>
      <li class="dropdown"><a href="#" class="dropdown-toggle mystyle-color" data-toggle="dropdown">换肤<span class="caret"></span></a>
        <ul class="dropdown-menu changecolor">
          <li id="blue"><a href="#">蓝色</a></li>
          <li class="divider"></li>
          <li id="green"><a href="#">绿色</a></li>
          <li class="divider"></li>
          <li id="orange"><a href="#">橙色</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
<div class="down-main">
  <div class="left-main left-full">
    <div class="sidebar-fold"><span class="glyphicon glyphicon-menu-hamburger"></span></div>
    <div class="subNavBox">
      <div class="sBox">
       <div class="subNav sublist-down"><span class="title-icon glyphicon glyphicon-chevron-down"></span><span class="sublist-title">教师排课中心</span>
        </div>
        <ul class="navContent" style="display:block">
           <li class="active">
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />安排选课中心</div>
            <a href="course/skip1"><span class="sublist-icon glyphicon glyphicon-user"></span><span class="sub-title">安排选课中心</span></a> </li>
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />我的课程班次</div>
            <a href="course/skip2"><span class="sublist-icon glyphicon glyphicon-envelope"></span><span class="sub-title">我的课程班次</span></a> </li>
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />课程表查询</div>
            <a href="course/skip3"><span class="sublist-icon glyphicon glyphicon-bullhorn"></span><span class="sub-title">安排选课班次</span></a></li>
               <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />班次学生</div>
            <a href="identify.html"><span class="sublist-icon glyphicon glyphicon-credit-card"></span><span class="sub-title">班次学生</span></a></li>
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />账号管理</div>
            <a href="identify.html"><span class="sublist-icon glyphicon glyphicon-credit-card"></span><span class="sub-title">账号管理</span></a></li>
        </ul>
      </div>
      <div class="sBox">
        <div class="subNav sublist-up"><span class="title-icon glyphicon glyphicon-chevron-up"></span><span class="sublist-title">关于我们</span></div>
        <ul class="navContent" style="display:none">
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />添加课程</div>
            <a href="#"><span class="sublist-icon glyphicon glyphicon-user"></span><span class="sub-title">添加新闻</span></a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="right-product my-index right-full">
     <div class="container-fluid">
	   <div class="info-center">
       
       <!---title----->
            <div class="info-title">
              <div class="pull-left">
               	<c:if test="${empty sessionScope.professor}">
		             <c:redirect url="teacherlogin.jsp" />
	            </c:if>
                <h4><strong>${professor.name }教师，</strong></h4>
                <p>欢迎登录中国矿业大学！ <a href="http://www.mycodes.net/" target="_blank">教师安排选课系统</a></p>
              </div>
             <div class="time-title pull-right">
                  <div class="year-month pull-left">
                    <p id="xq"></p>
                    <p id="yueri"><span id="nian"></span></p>
                  </div>
                  <div class="hour-minute pull-right">
                     <strong id="min"></strong>
                  </div>
              </div>
              <div class="clearfix"></div>
            </div>  
               <div class="content-list">
               <!-------信息列表------->
               <div class="row newslist" style="margin-top:20px;">
               <div id="toolbar">
		          <button id="add" class="btn btn-success" data-toggle="modal"
			       data-target="#myModal">
			     <i class="glyphicon glyphicon-plus"></i> 添加课程
		          </button>
		           <button id="reset" class="btn btn-danger" data-toggle="modal"
			       data-target="#resetForm"">
			          <i class="glyphicon glyphicon-remove"></i>修改
		         </button>
		             <button id="remove" class="btn btn-danger" disabled>
			          <i class="glyphicon glyphicon-remove"></i> 删除
		         </button>
		           <button id="add1" class="btn btn-success" data-toggle="modal"
			       data-target="#addSection">
			     <i class="glyphicon glyphicon-plus"></i> 添加班次
		          </button>
		            <button id="remove1" class="btn btn-danger" disabled>
			          <i class="glyphicon glyphicon-remove"></i> 删除班次
		         </button>
		           <button id="resetSec" class="btn btn-danger" data-toggle="modal"
			       data-target="#resetaSection">
			          <i class="glyphicon glyphicon-remove"></i>修改班次
		         </button>
	             </div>
	                <div class="container-fluid">
		                 <table id="table"></table>
	                </div>
                 
                
               </div>
            </div>
            
       </div>			
	 </div>
  </div>
</div>      
<!-- 修改课程  -->
		<div class="modal fade" id="resetForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="resetLabel">修改课程</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="rr">
	
						<div class="form-group">
							<label for="model" class="col-sm-2 control-label">课程编号</label>
							<div class="col-sm-9">
								<input name="courseNo" type="text" class="form-control" id="courseNo1"/>
							</div>
						</div>
						<br /><br />
						<div class="form-group">
							<label for="model" class="col-sm-2 control-label">课程名字</label>
							<div class="col-sm-9">
								<input name="courseName" type="text" class="form-control" id="courseName1"
									/>
							</div>
						</div>
						<br />
						<br />
						<div class="form-group">
							<label for="exampleInputAmount" class="col-sm-2 control-label">学分</label>
							<div class="input-group col-sm-9">
								<input type="text" class="form-control" min=0 id="credits1"  name="credits"/>
							</div>
						</div>
						<br /><br />
					</form>
				</div>
				<div class="modal-footer">
					<button id="close1" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="resetCourse" type="button" class="btn btn-primary">修改</button>
				</div>
			</div>
		</div>
	</div>
	
	
       <!-- 添加 课程 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加课程</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="ff">
<!-- 						<div class="form-group"> -->
<!-- 							<label for="builder" class="col-sm-2 control-label">builder</label> -->
<!-- 							<div class="col-sm-9"> -->
<!-- 								<input name="builder" type="text" class="form-control" id="builder" placeholder="builder"> -->
<!-- 								<select class="form-control" name="builder" id="builder"> -->
<!-- 									<option value="JIANGSU">江苏</option> -->
<!-- 									<option value="SHANGHAI">上海</option> -->
<!-- 									<option value="SHANDONG">山东</option> -->
<!-- 								</select> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="form-group">
							<label for="model" class="col-sm-2 control-label">课程</label>
							<div class="col-sm-9">
								<input name="courseNo" type="text" class="form-control" id="courseNo"/>
							</div>
						</div>
						<br /><br />
						<div class="form-group">
							<label for="model" class="col-sm-2 control-label">课程名字</label>
							<div class="col-sm-9">
								<input name="courseName" type="text" class="form-control" id="courseName"
									/>
							</div>
						</div>
						<br />
						<br />
						<div class="form-group">
							<label for="exampleInputAmount" class="col-sm-2 control-label">学分</label>
							<div class="input-group col-sm-9">
								<input type="text" class="form-control" min=0 id="credits"  name="credits"/>
							</div>
						</div>
						<br /><br />
					</form>
				</div>
				<div class="modal-footer">
					<button id="close" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="addcourse" type="button" class="btn btn-primary">添加</button>
				</div>
			</div>
		</div>
	</div>
             


<!-- 添加班次 -->
<div class="modal fade" id="addSection" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="addSectionLabel">添加班次</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="ss">
						<div class="form-group">
							<label for="courseId" class="col-sm-2 control-label">课程编号</label>
							<div class="col-sm-9">
								<input name="courseNo" disabled type="text" class="form-control" id="courseNo2" placeholder="请输入课程编号"/>	
								<input name="representedCourse.courseNo" type="hidden" class="form-control" id="courseId_add" placeholder="请输入课程编号"/>
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="sectionId" class="col-sm-2 control-label">班次</label>
							<div class="col-sm-9">
								<input name="sectionNo" type="text" class="form-control" id="sectionNo" placeholder="请输入班次"/>	
							</div>
						</div>
						<br />
							<div class="form-group">
							<label for="select" class="col-sm-2 control-label">学期</label>
							<div class="col-sm-9">
								<select name="semester" id="select" for="ff" class="form-control"> 
									<option selected="selected">学期</option>
									<option>1</option> 
									<option>2</option> 
								</select>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="dayOfWeek" class="col-sm-2 control-label">星期</label>
							<div class="col-sm-9">
								<input name="dayOfWeek" type="text" class="form-control" id="dayOfWeek" placeholder="请输入星期"/>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="timeOfday" class="col-sm-2 control-label">时间</label>
							<div class="col-sm-9">
								<input name="timeOfDay" type="text" class="form-control" id="timeOfday" placeholder="请输入时间"/>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="room" class="col-sm-2 control-label">教室</label>
							<div class="col-sm-9">
								<input name="Room" type="text" class="form-control" id="room" placeholder="请输入教室"/>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="seatingcapacity" class="col-sm-2 control-label">容量</label>
							<div class="col-sm-9">
								<input name="seatingCapacity" type="text" class="form-control" id="seatingcapacity" placeholder="请输入容量"/>	
							</div>
						</div>
						<br />
					</form>
				</div>
				<div class="modal-footer" >
					<button id="close2" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="addsection" type="button" class="btn btn-primary">添加</button>
				</div>
			</div>
		</div>
	</div>


<!-- 修改班次 -->
<div class="modal fade" id="resetaSection" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="resetSectionLabel">修改班次</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="rs">
						<div class="form-group">
							<label for="courseId" class="col-sm-2 control-label">课程编号</label>
							<div class="col-sm-9">
								<input name="representedCourse.courseNo" disabled type="text" class="form-control" id="courseNo3" placeholder="请输入课程编号"/>	
								<input name="representedCourse.courseNo" type="hidden" class="form-control" id="courseNo4" placeholder="请输入课程编号"/>
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="sectionId" class="col-sm-2 control-label">班次</label>
							<div class="col-sm-9">
								<input name="sectionNo" type="text" class="form-control" id="sectionNo1" placeholder="请输入班次"/>	
							</div>
						</div>
						<br />
							<div class="form-group">
							<label for="select" class="col-sm-2 control-label">学期</label>
							<div class="col-sm-9">
								<select name="semester" id="select1" for="rs" class="form-control"> 
									<option selected="selected">学期</option>
									<option>1</option> 
									<option>2</option> 
								</select>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="dayOfWeek" class="col-sm-2 control-label">星期</label>
							<div class="col-sm-9">
								<input name="dayOfWeek" type="text" class="form-control" id="dayOfWeek1" placeholder="请输入星期"/>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="timeOfday" class="col-sm-2 control-label">时间</label>
							<div class="col-sm-9">
								<input name="timeOfDay" type="text" class="form-control" id="timeOfDay1" placeholder="请输入时间"/>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="room" class="col-sm-2 control-label">教室</label>
							<div class="col-sm-9">
								<input name="Room" type="text" class="form-control" id="room1" placeholder="请输入教室"/>	
							</div>
						</div>
						<br />
						<div class="form-group">
							<label for="seatingcapacity" class="col-sm-2 control-label">容量</label>
							<div class="col-sm-9">
								<input name="seatingCapacity" type="text" class="form-control" id="seatingcapacity1" placeholder="请输入容量"/>	
							</div>
						</div>
						<br />
					</form>
				</div>
				<div class="modal-footer" >
					<button id="close3" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="writeSection" type="button" class="btn btn-primary">修改</button>
				</div>
			</div>
		</div>
	</div>



























<script type="text/javascript">
$(function(){
/*换肤*/
$(".dropdown .changecolor li").click(function(){
	var style = $(this).attr("id");
    $("link[title!='']").attr("disabled","disabled"); 
	$("link[title='"+style+"']").removeAttr("disabled"); 

// 	$.cookie('mystyle', style, { expires: 7 }); // 存储一个带7天期限的 cookie 
})
// var cookie_style = $.cookie("mystyle"); 
// if(cookie_style!=null){ 
//     $("link[title!='']").attr("disabled","disabled"); 
// 	$("link[title='"+cookie_style+"']").removeAttr("disabled"); 
// } 
/*左侧导航栏显示隐藏功能*/
$(".subNav").click(function(){				
			/*显示*/
			if($(this).find("span:first-child").attr('class')=="title-icon glyphicon glyphicon-chevron-down")
			{
				$(this).find("span:first-child").removeClass("glyphicon-chevron-down");
			    $(this).find("span:first-child").addClass("glyphicon-chevron-up");
			    $(this).removeClass("sublist-down");
				$(this).addClass("sublist-up");
			}
			/*隐藏*/
			else
			{
				$(this).find("span:first-child").removeClass("glyphicon-chevron-up");
				$(this).find("span:first-child").addClass("glyphicon-chevron-down");
				$(this).removeClass("sublist-up");
				$(this).addClass("sublist-down");
			}	
		// 修改数字控制速度， slideUp(500)控制卷起速度
	    $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(300);
	})
/*左侧导航栏缩进功能*/
$(".left-main .sidebar-fold").click(function(){

	if($(this).parent().attr('class')=="left-main left-full")
	{
		$(this).parent().removeClass("left-full");
		$(this).parent().addClass("left-off");
		
		$(this).parent().parent().find(".right-product").removeClass("right-full");
		$(this).parent().parent().find(".right-product").addClass("right-off");
		
		}
	else
	{
		$(this).parent().removeClass("left-off");
		$(this).parent().addClass("left-full");
		
		$(this).parent().parent().find(".right-product").removeClass("right-off");
		$(this).parent().parent().find(".right-product").addClass("right-full");
		
		}
	})	
 
  /*左侧鼠标移入提示功能*/
		$(".sBox ul li").mouseenter(function(){
			if($(this).find("span:last-child").css("display")=="none")
			{$(this).find("div").show();}
			}).mouseleave(function(){$(this).find("div").hide();})	
})
</script>
<script type="text/javascript">
        var in_1 = document.getElementById('input');
        function showTime(){
            var date = new Date();
            var week = date.getDay();
            var weekday;
            switch(week){
                case 0: weekday = '星期天';break;
                case 1: weekday = '星期一';break;
                case 2: weekday = '星期二';break;
                case 3: weekday = '星期三';break;
                case 4: weekday = '星期四';break;
                case 5: weekday = '星期五';break;
                case 6: weekday = '星期六';break;
            }
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var hour = date.getHours();
            var minute = date.getMinutes();
            var second = date.getSeconds();
            var in_1 = document.getElementById('yueri');
            var in_2 = document.getElementById('xq');
            var in_3 = document.getElementById('min');
            in_3.innerText=hour+':'+minute+':'+second
            in_2.innerText=weekday;
            in_1.innerText = year+'年' + month + "月" + day + '日';
            setTimeout(showTime,1000);
        }
        showTime();
    </script>
</body>
</html>
