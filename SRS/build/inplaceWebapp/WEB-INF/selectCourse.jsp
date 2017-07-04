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
<title>学生中心</title>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet" />
<link title="" href="css/style.css" rel="stylesheet" type="text/css"  />
<link title="blue" href="css/dermadefault.css" rel="stylesheet" type="text/css"/>
<link title="green" href="css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
<link title="orange" href="css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
<link href="css/templatecss.css" rel="stylesheet" title="" type="text/css" />
<script src="script/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="script/jquery.cookie.js" type="text/javascript"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
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
      <li class="li-border"><a class="mystyle-color" href="#">学生选课中心</a></li>
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
      <li class="dropdown li-border"><a href="#" class="dropdown-toggle mystyle-color" data-toggle="dropdown">课程中心<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">选课记录</a></li>
          <li class="divider"></li>
          <li><a href="#">课程表</a></li>
          <li class="divider"></li>
          <li><a href="#">成绩单</a></li>
        </ul>
      </li>
      <li class="dropdown li-border"><a href="#" class="dropdown-toggle mystyle-color" data-toggle="dropdown">${student.email }<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="login">退出</a></li>
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
       <div class="subNav sublist-down"><span class="title-icon glyphicon glyphicon-chevron-down"></span><span class="sublist-title">课程中心</span>
        </div>
        <ul class="navContent" style="display:block">
          <li class="active">
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />学生中心</div>
            <a href="studentmain.jsp"><span class="sublist-icon glyphicon glyphicon-user"></span><span class="sub-title">学生中心</span></a> </li>
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />学生选课</div>
            <a href="message.html"><span class="sublist-icon glyphicon glyphicon-envelope"></span><span class="sub-title">学生选课</span></a> </li>
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />查询成绩</div>
            <a href="smsInfo.html"><span class="sublist-icon glyphicon glyphicon-bullhorn"></span><span class="sub-title">查询成绩</span></a></li>
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />账户管理</div>
            <a href="identify.html"><span class="sublist-icon glyphicon glyphicon-credit-card"></span><span class="sub-title">账户管理</span></a></li>
        </ul>
      </div>
      <div class="sBox">
        <div class="subNav sublist-up"><span class="title-icon glyphicon glyphicon-chevron-up"></span><span class="sublist-title">关于我们</span></div>
        <ul class="navContent" style="display:none">
          <li>
            <div class="showtitle" style="width:100px;"><img src="img/leftimg.png" />添加新闻</div>
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
              	<c:if test="${empty sessionScope.student}">
		             <c:redirect url="login.jsp" />
	            </c:if>
                <h4><strong>${student.name}，</strong></h4>
                <p>欢迎登录中国矿业大学！ <a href="http://www.mycodes.net/" target="_blank">学生选课系统</a></p>
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
           <!----content-list----> 
            <div class="content-list">
               <div class="row">
                 <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file blue"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>第一学期</p>
                           <h3 class="number">50</h3>
                           <button class="btn btn-default">所修课程<span style="color:red;">12</span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file violet"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>第二学期</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default">所有课程<span style="color:red;">50</span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file orange"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>待办事项</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default">待我处理<span style="color:red;">12</span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file green"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>待办事项</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default">待我处理<span style="color:red;">12</span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
               </div>
               <!-------信息列表------->
               <div class="row newslist" style="margin-top:20px;">
              
                 <div class="col-md-8">
                   <div class="panel panel-default">
                      <div class="panel-heading">
                       我的课程表<div class="caret"></div>
                       <a href="#" class="pull-right"><span class="glyphicon glyphicon-refresh"></span></a>
                      </div>   
                      <c:forEach items="${sessionScope.stuSection}" var="stuSection">  
                      <div class="panel-body">
                           <div class="w15 pull-left">
                             <img src="img/noavatar_middle.gif" width="25" height="25" alt="图片" class="img-circle">
                             ${stuSection.representedCourse.courseName}
                           </div>
                           <div class="w55 pull-left">星期${stuSection.dayOfWeek}</div>
                           <div class="w20 pull-left text-center">${stuSection.timeOfDay}</div>
                          <div class="w10 pull-left text-center"><span class="text-green-main">${stuSection.room} </span></div>
                      </div>
                      </c:forEach>
                      <div class="panel-body text-center">
                          <a href="#" style="color:#5297d6;">查看全部</a>
                      </div>
                    </div>
                 </div>
                 
                 <div class="col-md-4">
                     <div class="panel panel-default">
                      <div class="panel-heading">
                       成绩中心
                       <a href="#" class="pull-right"><span class="glyphicon glyphicon-refresh"></span></a>
                      </div>     
                      <div class="panel-body">
                          <p>高等数学     &nbsp;&nbsp;&nbsp;&nbsp; <span class="text-green-main">100 </span></p>
                            <p>英语四级     &nbsp;&nbsp;&nbsp;&nbsp; <span class="text-green-main">100 </span></p>
                              <p>JavaEE     &nbsp;&nbsp;&nbsp;&nbsp; <span class="text-green-main">100 </span></p>
                               <p >网页设计     &nbsp;&nbsp;&nbsp;&nbsp;  <span ><font color="red">未发布</font> </span></p>
                      </div>
                    </div>
                    
                 </div>
               </div>
            </div>
            
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

	$.cookie('mystyle', style, { expires: 7 }); // 存储一个带7天期限的 cookie 
})
var cookie_style = $.cookie("mystyle"); 
if(cookie_style!=null){ 
    $("link[title!='']").attr("disabled","disabled"); 
	$("link[title='"+cookie_style+"']").removeAttr("disabled"); 
} 
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
