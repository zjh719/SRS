/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.23
 * Generated at: 2017-07-04 09:06:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studentmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1484225550694L));
    _jspx_dependants.put("jar:file:/F:/新建文件夹%20(2)/f/software/gradle-2.11/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no\">\r\n");
      out.write("<title>学生中心</title>\r\n");
      out.write("<link href=\"bootstrap-3.3.5-dist/css/bootstrap.min.css\" title=\"\" rel=\"stylesheet\" />\r\n");
      out.write("<link title=\"\" href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"  />\r\n");
      out.write("<link title=\"blue\" href=\"css/dermadefault.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link title=\"green\" href=\"css/dermagreen.css\" rel=\"stylesheet\" type=\"text/css\" disabled=\"disabled\"/>\r\n");
      out.write("<link title=\"orange\" href=\"css/dermaorange.css\" rel=\"stylesheet\" type=\"text/css\" disabled=\"disabled\"/>\r\n");
      out.write("<link href=\"css/templatecss.css\" rel=\"stylesheet\" title=\"\" type=\"text/css\" />\r\n");
      out.write("<script src=\"script/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"script/jquery.cookie.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"bootstrap-3.3.5-dist/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"nav navbar-default navbar-mystyle navbar-fixed-top\">\r\n");
      out.write("  <div class=\"navbar-header\">\r\n");
      out.write("    <button class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\"> \r\n");
      out.write("     <span class=\"icon-bar\"></span> \r\n");
      out.write("     <span class=\"icon-bar\"></span> \r\n");
      out.write("     <span class=\"icon-bar\"></span> \r\n");
      out.write("    </button>\r\n");
      out.write("    <a class=\"navbar-brand mystyle-brand\"><span class=\"glyphicon glyphicon-home\"></span></a> </div>\r\n");
      out.write("  <div class=\"collapse navbar-collapse\">\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("      <li class=\"li-border\"><a class=\"mystyle-color\" href=\"#\">学生选课中心</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    \r\n");
      out.write("    <ul class=\"nav navbar-nav pull-right\">\r\n");
      out.write("       <li class=\"li-border\">\r\n");
      out.write("          <a href=\"#\" class=\"mystyle-color\">\r\n");
      out.write("            <span class=\"glyphicon glyphicon-bell\"></span>\r\n");
      out.write("            <span class=\"topbar-num\">0</span>\r\n");
      out.write("          </a>\r\n");
      out.write("      </li>\r\n");
      out.write("       <li class=\"li-border dropdown\"><a href=\"#\" class=\"mystyle-color\" data-toggle=\"dropdown\">\r\n");
      out.write("      <span class=\"glyphicon glyphicon-search\"></span> 搜索</a>\r\n");
      out.write("         <div class=\"dropdown-menu search-dropdown\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\">\r\n");
      out.write("                 <span class=\"input-group-btn\">\r\n");
      out.write("                   <button type=\"button\" class=\"btn btn-default\">搜索</button>\r\n");
      out.write("                </span>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"dropdown li-border\"><a href=\"#\" class=\"dropdown-toggle mystyle-color\" data-toggle=\"dropdown\">课程中心<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"#\">选课记录</a></li>\r\n");
      out.write("          <li class=\"divider\"></li>\r\n");
      out.write("          <li><a href=\"#\">课程表</a></li>\r\n");
      out.write("          <li class=\"divider\"></li>\r\n");
      out.write("          <li><a href=\"#\">成绩单</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"dropdown li-border\"><a href=\"#\" class=\"dropdown-toggle mystyle-color\" data-toggle=\"dropdown\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"login\">退出</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle mystyle-color\" data-toggle=\"dropdown\">换肤<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu changecolor\">\r\n");
      out.write("          <li id=\"blue\"><a href=\"#\">蓝色</a></li>\r\n");
      out.write("          <li class=\"divider\"></li>\r\n");
      out.write("          <li id=\"green\"><a href=\"#\">绿色</a></li>\r\n");
      out.write("          <li class=\"divider\"></li>\r\n");
      out.write("          <li id=\"orange\"><a href=\"#\">橙色</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"down-main\">\r\n");
      out.write("  <div class=\"left-main left-full\">\r\n");
      out.write("    <div class=\"sidebar-fold\"><span class=\"glyphicon glyphicon-menu-hamburger\"></span></div>\r\n");
      out.write("    <div class=\"subNavBox\">\r\n");
      out.write("      <div class=\"sBox\">\r\n");
      out.write("       <div class=\"subNav sublist-down\"><span class=\"title-icon glyphicon glyphicon-chevron-down\"></span><span class=\"sublist-title\">课程中心</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"navContent\" style=\"display:block\">\r\n");
      out.write("          <li class=\"active\">\r\n");
      out.write("            <div class=\"showtitle\" style=\"width:100px;\"><img src=\"img/leftimg.png\" />学生中心</div>\r\n");
      out.write("            <a href=\"studentmain.jsp\"><span class=\"sublist-icon glyphicon glyphicon-user\"></span><span class=\"sub-title\">学生中心</span></a> </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <div class=\"showtitle\" style=\"width:100px;\"><img src=\"img/leftimg.png\" />学生选课</div>\r\n");
      out.write("            <a href=\"/student/selectCourse\"><span class=\"sublist-icon glyphicon glyphicon-envelope\"></span><span class=\"sub-title\">学生选课</span></a> </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <div class=\"showtitle\" style=\"width:100px;\"><img src=\"img/leftimg.png\" />查询成绩</div>\r\n");
      out.write("            <a href=\"smsInfo.html\"><span class=\"sublist-icon glyphicon glyphicon-bullhorn\"></span><span class=\"sub-title\">查询成绩</span></a></li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <div class=\"showtitle\" style=\"width:100px;\"><img src=\"img/leftimg.png\" />账户管理</div>\r\n");
      out.write("            <a href=\"identify.html\"><span class=\"sublist-icon glyphicon glyphicon-credit-card\"></span><span class=\"sub-title\">账户管理</span></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"sBox\">\r\n");
      out.write("        <div class=\"subNav sublist-up\"><span class=\"title-icon glyphicon glyphicon-chevron-up\"></span><span class=\"sublist-title\">关于我们</span></div>\r\n");
      out.write("        <ul class=\"navContent\" style=\"display:none\">\r\n");
      out.write("          <li>\r\n");
      out.write("            <div class=\"showtitle\" style=\"width:100px;\"><img src=\"img/leftimg.png\" />添加新闻</div>\r\n");
      out.write("            <a href=\"#\"><span class=\"sublist-icon glyphicon glyphicon-user\"></span><span class=\"sub-title\">添加新闻</span></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"right-product my-index right-full\">\r\n");
      out.write("     <div class=\"container-fluid\">\r\n");
      out.write("\t   <div class=\"info-center\">\r\n");
      out.write("       \r\n");
      out.write("       <!---title----->\r\n");
      out.write("            <div class=\"info-title\">\r\n");
      out.write("              <div class=\"pull-left\">\r\n");
      out.write("              \t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                <h4><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("，</strong></h4>\r\n");
      out.write("                <p>欢迎登录中国矿业大学！ <a href=\"http://www.mycodes.net/\" target=\"_blank\">学生选课系统</a></p>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"time-title pull-right\">\r\n");
      out.write("                  <div class=\"year-month pull-left\">\r\n");
      out.write("                    <p id=\"xq\"></p>\r\n");
      out.write("                    <p id=\"yueri\"><span id=\"nian\"></span></p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"hour-minute pull-right\">\r\n");
      out.write("                     <strong id=\"min\"></strong>\r\n");
      out.write("                  </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("           <!----content-list----> \r\n");
      out.write("            <div class=\"content-list\">\r\n");
      out.write("               <div class=\"row\">\r\n");
      out.write("                 <div class=\"col-md-3\">\r\n");
      out.write("                    <div class=\"content\">\r\n");
      out.write("                       <div class=\"w30 left-icon pull-left\">\r\n");
      out.write("                          <span class=\"glyphicon glyphicon-file blue\"></span>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"w70 right-title pull-right\">\r\n");
      out.write("                       <div class=\"title-content\">\r\n");
      out.write("                           <p>第一学期</p>\r\n");
      out.write("                           <h3 class=\"number\">50</h3>\r\n");
      out.write("                           <button class=\"btn btn-default\">所修课程<span style=\"color:red;\">12</span></button>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                 </div>\r\n");
      out.write("                  <div class=\"col-md-3\">\r\n");
      out.write("                    <div class=\"content\">\r\n");
      out.write("                       <div class=\"w30 left-icon pull-left\">\r\n");
      out.write("                          <span class=\"glyphicon glyphicon-file violet\"></span>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"w70 right-title pull-right\">\r\n");
      out.write("                       <div class=\"title-content\">\r\n");
      out.write("                           <p>第二学期</p>\r\n");
      out.write("                           <h3 class=\"number\">90</h3>\r\n");
      out.write("                           <button class=\"btn btn-default\">所有课程<span style=\"color:red;\">50</span></button>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                 </div>\r\n");
      out.write("                  <div class=\"col-md-3\">\r\n");
      out.write("                    <div class=\"content\">\r\n");
      out.write("                       <div class=\"w30 left-icon pull-left\">\r\n");
      out.write("                          <span class=\"glyphicon glyphicon-file orange\"></span>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"w70 right-title pull-right\">\r\n");
      out.write("                       <div class=\"title-content\">\r\n");
      out.write("                           <p>待办事项</p>\r\n");
      out.write("                           <h3 class=\"number\">90</h3>\r\n");
      out.write("                           <button class=\"btn btn-default\">待我处理<span style=\"color:red;\">12</span></button>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                 </div>\r\n");
      out.write("                  <div class=\"col-md-3\">\r\n");
      out.write("                    <div class=\"content\">\r\n");
      out.write("                       <div class=\"w30 left-icon pull-left\">\r\n");
      out.write("                          <span class=\"glyphicon glyphicon-file green\"></span>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"w70 right-title pull-right\">\r\n");
      out.write("                       <div class=\"title-content\">\r\n");
      out.write("                           <p>待办事项</p>\r\n");
      out.write("                           <h3 class=\"number\">90</h3>\r\n");
      out.write("                           <button class=\"btn btn-default\">待我处理<span style=\"color:red;\">12</span></button>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       </div>\r\n");
      out.write("                       <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                 </div>\r\n");
      out.write("               </div>\r\n");
      out.write("               <!-------信息列表------->\r\n");
      out.write("               <div class=\"row newslist\" style=\"margin-top:20px;\">\r\n");
      out.write("              \r\n");
      out.write("                 <div class=\"col-md-8\">\r\n");
      out.write("                   <div class=\"panel panel-default\">\r\n");
      out.write("                      <div class=\"panel-heading\">\r\n");
      out.write("                       我的课程表<div class=\"caret\"></div>\r\n");
      out.write("                       <a href=\"#\" class=\"pull-right\"><span class=\"glyphicon glyphicon-refresh\"></span></a>\r\n");
      out.write("                      </div>   \r\n");
      out.write("                      ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                      <div class=\"panel-body text-center\">\r\n");
      out.write("                          <a href=\"#\" style=\"color:#5297d6;\">查看全部</a>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 \r\n");
      out.write("                 <div class=\"col-md-4\">\r\n");
      out.write("                     <div class=\"panel panel-default\">\r\n");
      out.write("                      <div class=\"panel-heading\">\r\n");
      out.write("                       成绩中心\r\n");
      out.write("                       <a href=\"#\" class=\"pull-right\"><span class=\"glyphicon glyphicon-refresh\"></span></a>\r\n");
      out.write("                      </div>     \r\n");
      out.write("                      <div class=\"panel-body\">\r\n");
      out.write("                          <p>高等数学     &nbsp;&nbsp;&nbsp;&nbsp; <span class=\"text-green-main\">100 </span></p>\r\n");
      out.write("                            <p>英语四级     &nbsp;&nbsp;&nbsp;&nbsp; <span class=\"text-green-main\">100 </span></p>\r\n");
      out.write("                              <p>JavaEE     &nbsp;&nbsp;&nbsp;&nbsp; <span class=\"text-green-main\">100 </span></p>\r\n");
      out.write("                               <p >网页设计     &nbsp;&nbsp;&nbsp;&nbsp;  <span ><font color=\"red\">未发布</font> </span></p>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                 </div>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("       </div>\t\t\t\r\n");
      out.write("\t </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("/*换肤*/\r\n");
      out.write("$(\".dropdown .changecolor li\").click(function(){\r\n");
      out.write("\tvar style = $(this).attr(\"id\");\r\n");
      out.write("    $(\"link[title!='']\").attr(\"disabled\",\"disabled\"); \r\n");
      out.write("\t$(\"link[title='\"+style+\"']\").removeAttr(\"disabled\"); \r\n");
      out.write("\r\n");
      out.write("\t$.cookie('mystyle', style, { expires: 7 }); // 存储一个带7天期限的 cookie \r\n");
      out.write("})\r\n");
      out.write("var cookie_style = $.cookie(\"mystyle\"); \r\n");
      out.write("if(cookie_style!=null){ \r\n");
      out.write("    $(\"link[title!='']\").attr(\"disabled\",\"disabled\"); \r\n");
      out.write("\t$(\"link[title='\"+cookie_style+\"']\").removeAttr(\"disabled\"); \r\n");
      out.write("} \r\n");
      out.write("/*左侧导航栏显示隐藏功能*/\r\n");
      out.write("$(\".subNav\").click(function(){\t\t\t\t\r\n");
      out.write("\t\t\t/*显示*/\r\n");
      out.write("\t\t\tif($(this).find(\"span:first-child\").attr('class')==\"title-icon glyphicon glyphicon-chevron-down\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t$(this).find(\"span:first-child\").removeClass(\"glyphicon-chevron-down\");\r\n");
      out.write("\t\t\t    $(this).find(\"span:first-child\").addClass(\"glyphicon-chevron-up\");\r\n");
      out.write("\t\t\t    $(this).removeClass(\"sublist-down\");\r\n");
      out.write("\t\t\t\t$(this).addClass(\"sublist-up\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t/*隐藏*/\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t$(this).find(\"span:first-child\").removeClass(\"glyphicon-chevron-up\");\r\n");
      out.write("\t\t\t\t$(this).find(\"span:first-child\").addClass(\"glyphicon-chevron-down\");\r\n");
      out.write("\t\t\t\t$(this).removeClass(\"sublist-up\");\r\n");
      out.write("\t\t\t\t$(this).addClass(\"sublist-down\");\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t// 修改数字控制速度， slideUp(500)控制卷起速度\r\n");
      out.write("\t    $(this).next(\".navContent\").slideToggle(300).siblings(\".navContent\").slideUp(300);\r\n");
      out.write("\t})\r\n");
      out.write("/*左侧导航栏缩进功能*/\r\n");
      out.write("$(\".left-main .sidebar-fold\").click(function(){\r\n");
      out.write("\r\n");
      out.write("\tif($(this).parent().attr('class')==\"left-main left-full\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\t$(this).parent().removeClass(\"left-full\");\r\n");
      out.write("\t\t$(this).parent().addClass(\"left-off\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(this).parent().parent().find(\".right-product\").removeClass(\"right-full\");\r\n");
      out.write("\t\t$(this).parent().parent().find(\".right-product\").addClass(\"right-off\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\t$(this).parent().removeClass(\"left-off\");\r\n");
      out.write("\t\t$(this).parent().addClass(\"left-full\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(this).parent().parent().find(\".right-product\").removeClass(\"right-off\");\r\n");
      out.write("\t\t$(this).parent().parent().find(\".right-product\").addClass(\"right-full\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\t\r\n");
      out.write(" \r\n");
      out.write("  /*左侧鼠标移入提示功能*/\r\n");
      out.write("\t\t$(\".sBox ul li\").mouseenter(function(){\r\n");
      out.write("\t\t\tif($(this).find(\"span:last-child\").css(\"display\")==\"none\")\r\n");
      out.write("\t\t\t{$(this).find(\"div\").show();}\r\n");
      out.write("\t\t\t}).mouseleave(function(){$(this).find(\"div\").hide();})\t\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("        var in_1 = document.getElementById('input');\r\n");
      out.write("        function showTime(){\r\n");
      out.write("            var date = new Date();\r\n");
      out.write("            var week = date.getDay();\r\n");
      out.write("            var weekday;\r\n");
      out.write("            switch(week){\r\n");
      out.write("                case 0: weekday = '星期天';break;\r\n");
      out.write("                case 1: weekday = '星期一';break;\r\n");
      out.write("                case 2: weekday = '星期二';break;\r\n");
      out.write("                case 3: weekday = '星期三';break;\r\n");
      out.write("                case 4: weekday = '星期四';break;\r\n");
      out.write("                case 5: weekday = '星期五';break;\r\n");
      out.write("                case 6: weekday = '星期六';break;\r\n");
      out.write("            }\r\n");
      out.write("            var year = date.getFullYear();\r\n");
      out.write("            var month = date.getMonth() + 1;\r\n");
      out.write("            var day = date.getDate();\r\n");
      out.write("            var hour = date.getHours();\r\n");
      out.write("            var minute = date.getMinutes();\r\n");
      out.write("            var second = date.getSeconds();\r\n");
      out.write("            var in_1 = document.getElementById('yueri');\r\n");
      out.write("            var in_2 = document.getElementById('xq');\r\n");
      out.write("            var in_3 = document.getElementById('min');\r\n");
      out.write("            in_3.innerText=hour+':'+minute+':'+second\r\n");
      out.write("            in_2.innerText=weekday;\r\n");
      out.write("            in_1.innerText = year+'年' + month + \"月\" + day + '日';\r\n");
      out.write("            setTimeout(showTime,1000);\r\n");
      out.write("        }\r\n");
      out.write("        showTime();\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /studentmain.jsp(122,15) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.student}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t             ");
        if (_jspx_meth_c_005fredirect_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t            ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fredirect_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_005fredirect_005f0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_005fredirect_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fredirect_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /studentmain.jsp(123,15) name = url type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fredirect_005f0.setUrl("login.jsp");
    int _jspx_eval_c_005fredirect_005f0 = _jspx_th_c_005fredirect_005f0.doStartTag();
    if (_jspx_th_c_005fredirect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.reuse(_jspx_th_c_005fredirect_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.reuse(_jspx_th_c_005fredirect_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /studentmain.jsp(212,22) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/studentmain.jsp(212,22) '${sessionScope.stuSection}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${sessionScope.stuSection}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /studentmain.jsp(212,22) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("stuSection");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \r\n");
          out.write("                      <div class=\"panel-body\">\r\n");
          out.write("                           <div class=\"w15 pull-left\">\r\n");
          out.write("                             <img src=\"img/noavatar_middle.gif\" width=\"25\" height=\"25\" alt=\"图片\" class=\"img-circle\"/>\r\n");
          out.write("                                       ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stuSection.representedCourse.courseName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                           </div>\r\n");
          out.write("                           <div class=\"w55 pull-left\">星期");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stuSection.dayOfWeek}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                           <div class=\"w20 pull-left text-center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stuSection.timeOfDay}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                          <div class=\"w10 pull-left text-center\"><span class=\"text-green-main\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stuSection.room}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" </span></div>\r\n");
          out.write("                      </div>\r\n");
          out.write("                      ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}