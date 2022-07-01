<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>Time Table</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/subject.css" rel="stylesheet" />
	<link href="assets/css/metro.css" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="assets/css/style.css" rel="stylesheet" />
	<link href="assets/css/style_responsive.css" rel="stylesheet" />
	<link href="assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link rel="stylesheet" type="text/css" href="assets/chosen-bootstrap/chosen/chosen.css" />
	<link rel="stylesheet" type="text/css" href="assets/uniform/css/uniform.default.css" />
	<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

	
		
<body class="fixed-top">
<%-- <form:form action="/displayTT.htm" method="GET" > --%>
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
	
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				
				<!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="assets/img/menu-toggler.png" alt="" />
				</a>          
				<!-- END RESPONSIVE MENU TOGGLER -->
				<h3 class="enkalvi-logo"><span>EN</span>KALVI</h3>				
				<!-- BEGIN TOP NAVIGATION MENU -->					
				<ul class="nav pull-right">
					
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="assets/img/avatar1_small.jpg" />
						<span class="username">Bipin Yadav</span>
						<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">
						<li style="float:left;"><a href="#"><img style=" margin-right: 10px;" src="assets/img/avatar.jpg" alt=""></li>
							<li><a href="#"><i class="icon-user"></i> Edit Profile</a></li>
							<li><a href="#"><i class="icon-asterisk"></i> Change Password</a></li>
							
							<li class="divider"></li>
							<li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- END TOP NAVIGATION MENU -->	
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->	
	<div class="page-container row-fluid">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
			<div class="slide hide">
				<i class="icon-angle-left"></i>
			</div>
			
			<div class="clearfix"></div>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul>
				<li>
					<a href="timeTableInput.htm">
					<i class="icon-inbox"></i> Time Table setup<span class="selected"></span>
					
					</a>					
				</li>
				<li>
					<a href="generate.htm">
					<i class="icon-tasks"></i> Generate Time Table<span class="selected"></span>
					
					</a>					
				</li><li>
					<a href="dispTTPage.htm">
					<i class="icon-group"></i> Teacher Time Table<span class="selected"></span>
					
					</a>					
				</li><li>
					<a href="dispTTPage.htm">
					<i class="icon-book"></i> Class Time Table<span class="selected"></span>
					
					</a>					
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>portlet Settings</h3>
				</div>
				<div class="modal-body">
					<p>Here will be a configuration form</p>
				</div>
			</div>
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->		
						<h3 class="page-title">
							Time Table
							<small></small>
						</h3>
						<ul class="breadcrumb">
								<li>
									<i class="icon-home"></i>
									
									</li>
							<li>
								
								<a href="index.html">Dashboard</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								
								<a href="timetable.html">Time Table</a> 
								
							</li>
							
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				
				 <div class="row-fluid">
               <div class="span12">
                  <!-- BEGIN SAMPLE FORM PORTLET-->   
                  <div class="portlet box yellow">
                     <div class="portlet-title">
                        <h4><i class="icon-reorder"></i>View Time Table</h4>
                        <div class="tools">
                           <a href="javascript:;" class="expand"></a>
                           <a href="#portlet-config" data-toggle="modal" class="config"></a>
                           <a href="javascript:;" class="reload"></a>
                           <a href="javascript:;" class="remove"></a>
                        </div>
                     </div>
                     <div class="portlet-body form">
                      
				
				<div class="control-group span6">
						   <label class="control-label span2" for="inputWarning" >Standard </label>
                             <div class="controls ">
                             <form:form commandName="courseClass" action="displayTT.htm" method="POST" class="form-horizontal">
                              <form:select path="studentGroup.id" class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                              <c:forEach items="${applicationScope.group}" var="data1" >
                              <form:option value="${data1.id}">${data1.std}-${data1.sec}${data1.combination}</form:option>
                              </c:forEach>	
                              </form:select>    
                              <input type="submit" class="btn span2" name="action" value="Get"/>     
                                  </form:form>
                                                                                    
                              </div>
                              </div>
                              
                         <div class="control-group span6">       
                              <label class="control-label span2" for="inputWarning" >Professor </label>                            
                             <div class="controls ">
                             <form:form commandName="courseClass" action="displayProfessorTT.htm" method="POST" class="form-horizontal">
                              <form:select path="prof.id" class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                              <c:forEach items="${applicationScope.prof}" var="data1" >
                              <form:option value="${data1.id}">${data1.prof_name}</form:option>
                              </c:forEach>	
                              </form:select>     
                               <input type="submit" class="btn span2"  name="action1" value="Get"/>     
                                  </form:form>                                                       
                              </div>
                           </div>                  
                           <div style="clear:both"></div>       
                                                     
						  
				</div>
				</div>
				<!-- BEGIN PAGE CONTENT-->
				<c:if test="${fn:length(profCCList) gt 0}">
					<div class="row-fluid">
					<div class="span12">
	
							
							
							<label>Section A</label>
							<table class="table table-class">
									<thead>
										<tr>
											<th>Time</th>
											<th>Monday</th>
											<th>Tuesday</th>
											<th>Wednesday</th>
											<th>Thursday</th>
											<th>Friday</th>
											<!-- <th>Saturday</th>
											<th>Subject Bin</th> -->
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Period 1</td>
											<c:forEach items="${profCCList}" var="var1" begin="0" end="44" step="9"  >
											<c:set var="combine" value="${var1.studentGroup.id }${var1.course.id}"></c:set>												
											
											<td class="subject${combine}" align="right" > ${var1.course.subject_name}<br>${var1.studentGroup.std}${' '}${var1.studentGroup.sec}${' '}${var1.studentGroup.combination}</td>
											</c:forEach>
											</tr>
										<tr>
											<td>Period 2</td>
											<c:forEach items="${profCCList}" var="var" begin="1" end="44" step="9">
										<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											</c:forEach>
										</tr>
										<tr>
											<td>Period 3</td>
											<c:forEach items="${profCCList}" var="var" begin="2" end="44" step="9">
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											<!-- <td class="spanish">Spanish</td>
											<td class="physics">Physics</td>
											<td class="biology">Biology</td>
											<td class="maths">Maths</td>
											<td class="french">French</td> -->
											</c:forEach>
										</tr>
										
										<tr>
											<td>Period 4</td>
											<c:forEach items="${profCCList}" var="var" begin="3" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											<!-- <td class="french">French</td>
											<td class="physics">Physics</td>
											<td class="maths">Maths</td>
											<td class="sports">Sports</td>
											<td class="biology">Biology</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 5</td>
											<c:forEach items="${profCCList}" var="var" begin="4" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											<!-- <td class="biology">Biology</td>
											<td class="sports">Sports</td>
											<td class="eng">English</td>
											<td class="hindi">Hindi</td>
											<td class="physics">Physics</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 6</td>
											<c:forEach items="${profCCList}" var="var" begin="5" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											</c:forEach>
										</tr>
										
										<tr>
											<td>Period 7</td>
											<c:forEach items="${profCCList}" var="var" begin="6" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											</c:forEach>
										</tr>
										<tr>
											<td>Period 8</td>
											<c:forEach items="${profCCList}" var="var" begin="7" end="44" step="9">
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											</c:forEach>
										</tr>
										<tr>
											<td>Period 9</td>
											<c:forEach items="${profCCList}" var="var" begin="8" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.studentGroup.std}${' '}${var.studentGroup.sec}${' '}${var.studentGroup.combination}</td>
											
											</c:forEach>
										</tr> 
									</tbody>
								</table>
								</div>
				
				</div>
							
				</c:if>
				<c:if test="${fn:length(courseClassList) gt 0}">
				<div class="row-fluid">
					<div class="span12">
						
							
							
							<label>Section A</label>
							<!-- working code with (Day X Period) format -->
							
							<table class="table table-class">
									<thead>
										<tr>
											<th>Time</th>
											<th>Monday</th>
											<th>Tuesday</th>
											<th>Wednesday</th>
											<th>Thursday</th>
											<th>Friday</th>
											<!-- <th>Saturday</th>
											<th>Subject Bin</th> -->
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Period 1</td>
											<c:forEach items="${courseClassList}" var="var1" begin="0" end="44" step="9"  >
											<%-- <c:forEach items="${courseClassList}" var1="data1" begin"1" end="5" step="1"> --%>
											<%-- <c:if test="var1==0" >  --%>
											<c:set var="combine" value="${var1.studentGroup.id }${var1.course.id}"></c:set>	
											<c:if test="${var1.prof.prof_name ==null}">										
											<%-- <td  class="subject${combine}" align="right" ><i class="note">${var1.course.subject_name}<br>${var1.prof.prof_name }</i></td> --%>
												<td  class="subject${combine}" align="right"  ><i class="not" onclick="displayDatas">${var1.course.subject_name}<br>${var1.prof.prof_name }</i></td>
											</c:if>											
											<c:if test="${var1.prof.prof_name !=null}"><td  class="subject${combine}" align="right" >${var1.course.subject_name}<br>${var1.prof.prof_name }</td></c:if>
											<%-- <td  class="subject${combine}" align="right" ><i class="note" > ${var1.course.subject_name}<br>${var1.prof.prof_name }</i></td> --%>
											<%-- ${var1.studentGroup.id }${'-'}${var1.course.id} --%>																		
											 <!-- <td class="physics">Physics</td>
											<td class="chem">Chemistry</td>
											<td class="sports">Sports</td>
											<td class="biology">Biology</td>
											<td class="maths">Maths</td> -->
											</c:forEach>
											<%-- 	</c:forEach> --%>
											<!-- <td rowspan="9">
											<div class="drag-subject">Subject 1</div>
											<div class="drag-subject">Subject 2</div>
											<div class="drag-subject">Subject 3</div>
												
											</td> -->
										</tr>
										<tr>
											<td>Period 2</td>
											<c:forEach items="${courseClassList}" var="var" begin="1" end="44" step="9">
										<%-- 	<c:forEach items="${courseClassList}" var="data2" > --%>
										<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
										<c:if test="${var.prof.prof_name ==null}">
										<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name }</i></td> --%>
										<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name }</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name }</td>
											</c:if>
											
											<!-- <td class="biology">Biology</td>
											<td class="sports">Sports</td>
											<td class="eng">English</td>
											<td class="hindi">Hindi</td>
											<td class="physics">Physics</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 3</td>
											<c:forEach items="${courseClassList}" var="var" begin="2" end="44" step="9">
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>
											<c:if test="${var.prof.prof_name ==null}">
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name}<br>${var.prof.prof_name}</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name}<br>${var.prof.prof_name}</td>
											</c:if>
											<!-- <td class="spanish">Spanish</td>
											<td class="physics">Physics</td>
											<td class="biology">Biology</td>
											<td class="maths">Maths</td>
											<td class="french">French</td> -->
											</c:forEach>
										</tr>
										
										<tr>
											<td>Period 4</td>
											<c:forEach items="${courseClassList}" var="var" begin="3" end="44" step="9">
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>	
											<c:if test="${var.prof.prof_name ==null}">										
											<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name }</i></td> --%>
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name }</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name }</td>
											</c:if>
											<!-- <td class="french">French</td>
											<td class="physics">Physics</td>
											<td class="maths">Maths</td>
											<td class="sports">Sports</td>
											<td class="biology">Biology</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 5</td>
											<c:forEach items="${courseClassList}" var="var" begin="4" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>	
											<c:if test="${var.prof.prof_name ==null}">
											<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name }</i></td> --%>
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name }</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name }</td>
											</c:if>
											
											<!-- <td class="biology">Biology</td>
											<td class="sports">Sports</td>
											<td class="eng">English</td>
											<td class="hindi">Hindi</td>
											<td class="physics">Physics</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 6</td>
											<c:forEach items="${courseClassList}" var="var" begin="5" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>	
											
											
											<c:if test="${var.prof.prof_name ==null}">
											<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name }</i></td> --%>
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name }</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name }</td>
											</c:if>
											<%-- <c:out value="${var.prof.prof_name } "></c:out> --%>
											
											<!-- <td class="spanish">Spanish</td>
											<td class="physics">Physics</td>
											<td class="biology">Biology</td>
											<td class="maths">Maths</td>
											<td class="french">French</td> -->
											</c:forEach>
										</tr>
										
										<tr>
											<td>Period 7</td>
											<c:forEach items="${courseClassList}" var="var" begin="6" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>	
											<c:if test="${var.prof.prof_name ==null}">
											<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name }</i></td> --%>
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name }</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name }</td>
											</c:if>
											<!-- <td class="physics">Physics</td>
											<td class="chem">Chemistry</td>
											<td class="sports">Sports</td>
											<td class="biology">Biology</td>
											<td class="maths">Maths</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 8</td>
											<c:forEach items="${courseClassList}" var="var" begin="7" end="44" step="9">
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>	
											<c:if test="${var.prof.prof_name ==null}">
											<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name }</i></td> --%>
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name }</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name }</td>
											</c:if>
											<!-- <td class="biology">Biology</td>
											<td class="sports">Sports</td>
											<td class="eng">English</td>
											<td class="hindi">Hindi</td>
											<td class="physics">Physics</td> -->
											</c:forEach>
										</tr>
										<tr>
											<td>Period 9</td>
											<c:forEach items="${courseClassList}" var="var" begin="8" end="44" step="9">
											
											<c:set var="combine" value="${var.studentGroup.id }${var.course.id}"></c:set>	
											<c:if test="${var.prof.prof_name ==null}">
											<%-- <td class="subject${combine}" align="center"><i class="note">${var.course.subject_name }<br>${var.prof.prof_name}</i></td> --%>
											<td class="subject${combine}" align="center"><i class="not">${var.course.subject_name }<br>${var.prof.prof_name}</i></td>
											</c:if>
											<c:if test="${var.prof.prof_name !=null}">
											<td class="subject${combine}" align="center">${var.course.subject_name }<br>${var.prof.prof_name}</td>
											</c:if>
											<!-- <td class="spanish">Spanish</td>
											<td class="physics">Physics</td>
											<td class="biology">Biology</td>
											<td class="maths">Maths</td>
											<td class="french">French</td> -->
											</c:forEach>
										</tr> 
									</tbody>
								</table>
						
					</div>
					
				</div>
				</c:if>		
				
							</form>
						</div>

					</div>



				<div  class="control-group" style="text-align:right;">
					
					
					
					<div class="controls">
					<button class="btn blue" type="button">Update</button>&nbsp;&nbsp;&nbsp;<button class="btn yellow" type="button">Freeze</button>
					</div>
				</div>
				
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->	
		</div>
		</div>
		</div>
		
		<!-- END PAGE -->	 	
	<!-- </div> -->
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		2015 &copy; MySchool
		<div class="span pull-right">
			<span class="go-top"><i class="icon-angle-up"></i></span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="assets/js/jquery-1.8.3.min.js"></script>			
	<script src="assets/breakpoints/breakpoints.js"></script>			
	<script src="assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js"></script>	
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.blockui.js"></script>
	<script src="assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>	
	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="assets/chosen-bootstrap/chosen/chosen.jquery.min.js"></script>
	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>	
	<script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>	
	<script src="assets/js/app.js"></script>		
	<script>
		jQuery(document).ready(function() {			
			
			App.init();
		});
	</script>
		
		
	<!-- END JAVASCRIPTS -->
	
	<%-- </form:form> --%>
</body>
<!-- END BODY -->
</html>