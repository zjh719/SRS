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
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
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
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
	
<script type="text/javascript" src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script type="text/javascript"src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
 $(function() {
	    $('#table').bootstrapTable('destroy');
		$('#table').bootstrapTable({
			url : '/course/listAllCourse',
			method : 'post',
			queryParamsType:'', 
			striped: true,                      //是否显示行间隔色
			sidePagination : 'server',
			toolbar : '#toolbar',
			detailView: true,
			striped : true,
			showColumns : true,
			showRefresh : true,
			showToggle : true,
			showPaginationSwitch : true,
			idField : 'courseNo',
			clickToSelect : true,
			search : true,
			searchOnEnterKey: true,
// 			sortOrder :　'asc',
			singleSelect : true,
			pagination : true,
			pageNumber : 1,
			pageSize : 3,
			pageList : [ 3, 6, 'ALL' ],
			dataField : 'rows',
			totalField : 'total',
			toolbarAlign: "left",//工具栏对齐方式
			sortable: true,
			queryParams : function(params) {
// 				 var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
// 				  limit: params.limit,   //页面大小
// 				  offset: params.offset,  //页码
// 				  departmentname: $("#txt_search_departmentname").val(),
// 				  statu: $("#txt_search_statu").val()
// 				  };
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
				title : '课程学分'
			}],
			onExpandRow: function (index, row, $detail) {
				childTable(index, row, $detail);
			}
		});
		// 子表
		function childTable(index, row, $detail){
			 	var parentid = row.courseNo;
			    var group_com = $detail.html('<table></table>').find('table');
			    $(group_com).bootstrapTable('destroy');
			    $(group_com).bootstrapTable({
			    	url: '/section/getSectionByCourseNo',
			    	method: 'get',
			    	queryParams: { courseNo: parentid },
			    	ajaxOptions: { courseNo: parentid },
			    	sidePagination : 'server',
			    	clickToSelect: true,
			    	cache :　false,
			    	uniqueId: "",
			    	dataField : "rows",
			    	onLoadSuccess : function(data) {
					},
			        columns: [{
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
		
		$('#addcourse').click(function(){
  			$.ajax({
  				url:"/course/addCourse",
  				data:$('#ff').serialize(),
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
           <li >
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />安排选课中心</div>
            <a href="course/skip1"><span class="sublist-icon glyphicon glyphicon-user"></span><span class="sub-title">安排选课中心</span></a> </li>
          <li class="active">
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
			     <i class="glyphicon glyphicon-plus"></i> 添加
		          </button>
		           <button id="reset" class="btn btn-danger" data-toggle="modal"
			       data-target="#resetForm"">
			          <i class="glyphicon glyphicon-remove"></i>修改
		         </button>
		             <button id="remove" class="btn btn-danger" disabled>
			          <i class="glyphicon glyphicon-remove"></i> 删除
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
<!-- 修改  -->
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
	
	
       <!-- 添加  -->
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
