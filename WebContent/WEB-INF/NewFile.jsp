
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>Student Marks</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
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
	
	
	
	<link rel="stylesheet" href="assets/data-tables/DT_bootstrap.css" />

	
	
	
	
	
	
	
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
	<div class="headerLogo"><a class="brand" href="index.html">
				<img alt="logo" style="height: 80px; margin-left: 20px;" src="images/sophialogo.png">
				
				</a>
				<a class="brand" href="index.html" style=" float: right;">
				<img style="width: 162px; padding-top: 30px;" src="images/myschool.png" alt="logo">
				</a>
				</div>
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
			<form class="sidebar-search" />
				<div class="input-box">
					<input type="text" class="" placeholder="Search" />
					<input type="button" class="submit" value=" " />
				</div>
			</form>
			<div class="clearfix"></div>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul>
	
				<li>
					<a href="index.html">
					<i class="icon-home"></i> Dashboard
					<span class="selected"></span>
					</a>					
				</li>
				<li class="has-sub active open">
					<a href="javascript:;" class="">
					<i class="icon-user"></i>Student
					<span class="arrow open"></span>
					<span class="selected"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="newadmission.html">New Admission</a></li>
						<li><a class="" href="stu-master.html">Student Master</a></li>
						<li><a class="" href="stu-update.html">Student Updates</a></li>
						<li><a class="" href="stu-alloc.html">Student alloc</a></li>
						
						<li><a class="" href="#">Reports</a></li>
						<li><a class="" href="#">Certificates</a></li>
						<li><a class="" href="#">Generate ID Cards</a></li>
						<li><a class="" href="#">Promotion</a></li>
						
					</ul>
				</li>
				<li>
					<a href="#">
					<i class="icon-book"></i> Student Marks
					<span class="selected"></span>
					</a>					
				</li>
				<li>
					<a href="#">
					 <i class="icon-bookmark"></i>Student Attendance
					<span class="selected"></span>
					</a>					
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-credit-card"></i> Student Fees
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="#">Fees Payment</a></li>
						<li><a class="" href="#">Fees Receip</a></li>
						<li><a class="" href="fees-discount.html">Discount</a></li>
						<li><a class="" href="#">Fees Status</a></li>
						<li><a class="" href="#">Fees Report</a></li>
					</ul>
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-group"></i> Staff
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="#">New Staff</a></li>
						<li><a class="" href="#">Staff Master</a></li>
						<li><a class="" href="#">Staff alloc</a></li>
						<li><a class="" href="#">Staff Attendance</a></li>
						<li><a class="" href="#">Salary</a></li>
						
					</ul>
				</li>
				<li class="has-sub">
				<a href="javascript:;" class="">
					<i class="icon-th"></i> Time Table
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="#">Time Table setup</a></li>
						<li><a class="" href="#">Generate Time Table</a></li>
						<li><a class="" href="#">Teacher Time Table</a></li>
						<li><a class="" href="#">Class Time Table</a></li>
						
						
					</ul>
				
				
				
				
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-tasks"></i>General Administration
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="#">User Management</a></li>
						<li><a class="" href="#">cocd admin</a></li>
						<li><a class="" href="#">state code admin</a></li>
						<li><a class="" href="#">prpm admin</a></li>
						<li><a class="" href="#">table admin1</a></li>
						<li><a class="" href="#">table admin2</a></li>
						<li><a class="" href="#">Holiday Maintenance</a></li>
						<li><a class="" href="#">Scheduling setup</a></li>
						<li><a class="" href="#">Marks setup</a></li>
						<li><a class="" href="#">Fees setup</a></li>
						
					</ul>
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-calendar"></i>Calender
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="cal.html">Event Calender</a></li>
						<li><a class="" href="#">PTA Management</a></li>
						<li><a class="" href="#">Appointments</a></li>
						
						
					</ul>
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-inbox"></i>Communication
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="#">NoticeBoard</a></li>
						<li><a class="" href="#">sms</a></li>
						<li><a class="" href="#">alerts</a></li>
						
						
					</ul>
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-list-alt"></i>Homework
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="#">Submit Homework</a></li>
						<li><a class="" href="#">View Homework</a></li>
						
						
						
					</ul>
				</li>
				
				<li><a class="" href="#"><i class="icon-bar-chart"></i> Analytics</a></li>
				
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
						<!-- BEGIN STYLE CUSTOMIZER-->
						<div class="styler-panel hidden-phone">
							<i class="icon-cog"></i>
							<i class="icon-remove"></i>
							<span class="settings">
							<span class="text">Style:</span>
							<span class="colors">
							<span class="color-default" data-style="default"></span>
							<span class="color-blue" data-style="blue"></span>
							<span class="color-light" data-style="light"></span>		
							</span>
							<span class="layout">
							<label class="hidden-phone">
							<input type="checkbox" class="header" checked="" value="" />Fixed Header
							</label>							
							</span>
							</span>
						</div>
						<!-- END STYLE CUSTOMIZER-->  
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->		
						<h3 class="page-title">
							Student Marks
							<small></small>
						</h3>
						<ul class="breadcrumb">
								<li>
									<i class="icon-home"></i>
									<a href="index.html">Dashboard</a>
									<i class="icon-angle-right"></i>
									</li>
							<li>
								
								<a href="#">Student</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								
								<a href="stu-master.html">Student Marks</a> 
								
							</li>
							
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				
				<div class="row-fluid">
               <div class="span12">
                  <!-- BEGIN VALIDATION STATES-->
                  <div class="portlet box yellow">
                     <div class="portlet-title">
                        <h4><i class="icon-reorder"></i>Heading</h4>
                        <div class="tools">
                           <a href="javascript:;" class="expand"></a>
                           
                        </div>
                     </div>
                     <div class="portlet-body form">
                        
                        <!-- BEGIN FORM-->
                        <form action="#" class="form-horizontal" />
						
                           <div class="control-group" id="year">
                              <label class="control-label" for="inputWarning">Academic Year </label>
                              <div class="control-group">
                              
                              <div class="controls">
                                 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                    <option value="Category 1" />2012-2013
                                    <option value="Category 2" />2013-2014
                                    <option value="Category 3" />2014-2015
                                    <option value="Category 4" />2015-2016
									<option value="Category 5" />2016-2017
                                 </select>
                              </div>
                           </div>
                           </div>
                       <div class="control-group" id="std">
						   <label class="control-label" for="inputWarning">Standard </label>
                             <div class="controls">
                                 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                    
                                    <option value="Category 1" />L.K.G
                                    <option value="Category 2" />U.K.G
                                    <option value="Category 3" />I
                                    <option value="Category 4" />II
									<option value="Category 5" />III
									<option value="Category 6" />IV
                                    <option value="Category 7" />V
									<option value="Category 8" />VI
									<option value="Category 9" />VII
									<option value="Category 10" />VIII
                                    <option value="Category 11" />IX
									<option value="Category 12" />X
									<option value="Category 13" />XI
									<option value="Category 14" />XII
                                 </select>
                              </div>
                           </div>
						   <div class="control-group" id="comb">
						   <label class="control-label" for="inputWarning">Combination </label>
                             <div class="controls">
                                 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                    
                                    <option value="Category 1" />PCMB
                                    <option value="Category 2" />PCME
                                   
                                 </select>
                              </div>
                           </div>
						   <div style="clear:both;"></div>
						    <div class="control-group" id="sec">
						   <label class="control-label" for="inputWarning">Section </label>
                             <div class="controls">
                                 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                    
                                    <option value="Category 1" />A
                                    <option value="Category 2" />B
                                    <option value="Category 3" />C
                                    <option value="Category 4" />D
									<option value="Category 5" />E
                                 </select>
                              </div>
                           </div>
						   
						   <div class="control-group" id="examtype">
						   <label class="control-label" for="inputWarning">Exam Type </label>
                             <div class="controls">
                                 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                    
                                    <option value="Category 1" />Unit 1
                                    <option value="Category 2" />Unit 2
                                    <option value="Category 3" />Unit 3
                                    <option value="Category 4" />Term 1
									<option value="Category 5" />Term 2
                                 </select>
                              </div>
                           </div>
						   <div class="control-group" id="subject">
						   <label class="control-label" for="inputWarning">Subject </label>
                             <div class="controls">
                                 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                    
                                    <option value="Category 1" />English
                                    <option value="Category 2" />Sanskrit
                                    
                                 </select>
                              </div>
                           </div>
                       <div style="clear:both;"></div>
					    <div class="control-group" id="stu-name">
                              <label class="control-label">Student Name</label>
                              <div class="controls">
                                 <select class="span12 m-wrap" multiple="multiple" data-placeholder="Choose a Category" tabindex="1">
                                    <option value="Category 1" />Aakash
                                    <option value="Category 2" />Adharsh
                                    <option value="Category 3" />Anita
                                    <option value="Category 4" />Brinda
                                    <option value="Category 3" />Babitha
                                    
                                 </select>
                              </div>
                           </div>
						   <div class="control-group" id="marks-search">
                              
                              <div class="controls">
                                
                                 <button type="button" class="btn blue">Search</button>
                              </div>
                           </div>
						     <div style="clear:both;"></div>
                        </form>
                        <!-- END FORM-->
						
                     </div>
                  </div>
                  <!-- END VALIDATION STATES-->
               </div>
            </div>
				
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box grey">
							<div class="portlet-title">
								<h4><i class="icon-reorder"></i>Heading</h4>
								<div class="tools">
									<a href="javascript:;" class="expand"></a>
									
								</div>
							</div>
							<div class="portlet-body">
							<div class="span6">
							</div>
									<div class="span6">
										<div id="sample_1_info" class="dataTables_info">Showing 1 to 10 of 25 entries</div>
										</div>
								<table class="table table-striped table-bordered" id="sample_1">
									<thead>
										<tr>
											<th style="width:8px;vertical-align: top;">S.No</th>
											
											<th style="width:8px;vertical-align: top;">Name</th>
												<th class="hidden-phone">
												
												 
												  <div class="control-group">
												  
												  <div class="controls">
													 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
														<option value="Category 1" />Subject 1
														<option value="Category 2" />Subject 2
														<option value="Category 3" />Subject 3
														<option value="Category 2" />Subject 4
														<option value="Category 3" />Subject 5
														
													 </select>
												  </div>
												</div>
												
											</th>
											
											<th class="hidden-phone">
												 
												  <div class="control-group">
												  
												  <div class="controls">
													 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
														<option value="Category 1" />Subject 1
														<option value="Category 2" />Subject 2
														<option value="Category 3" />Subject 3
														<option value="Category 2" />Subject 4
														<option value="Category 3" />Subject 5
														
													 </select>
												  </div>
												
												</div>
											</th>
											
											<th class="hidden-phone">
												  <div class="control-group">
												  
												  <div class="controls">
													 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
														<option value="Category 1" />Subject 1
														<option value="Category 2" />Subject 2
														<option value="Category 3" />Subject 3
														<option value="Category 2" />Subject 4
														<option value="Category 3" />Subject 5
														
													 </select>
												  </div>
												
												</div>
												</th>
												
											<th class="hidden-phone">
											<div class="control-group">
												  
												  <div class="controls">
													 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
														<option value="Category 1" />Subject 1
														<option value="Category 2" />Subject 2
														<option value="Category 3" />Subject 3
														<option value="Category 2" />Subject 4
														<option value="Category 3" />Subject 5
														
													 </select>
												  </div>
												
												</div>
												</th>
												
												<th class="hidden-phone">
												<div class="control-group">
												  
												  <div class="controls">
													 <select class="span12 m-wrap" data-placeholder="Choose a Category" tabindex="1">
														<option value="Category 1" />Subject 1
														<option value="Category 2" />Subject 2
														<option value="Category 3" />Subject 3
														<option value="Category 2" />Subject 4
														<option value="Category 3" />Subject 5
														
													 </select>
												  </div>
												
												</div>
												</th>
										</tr>
									</thead>
									<tbody>
										<tr class="odd gradeX">
										<td>1</td>
											<td>Hema</td>
											
											<td>
											<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />Absent &nbsp; &nbsp; &nbsp; &nbsp;<i class="icon-pencil" id="note"> Note</i> 
											   </div>
											</td>
											
											<td class="center hidden-phone">
											<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												    <input type="checkbox" value="" />Absent &nbsp; &nbsp; &nbsp; &nbsp;<i class="icon-pencil"> Note</i> 
												</div>
												</td>
											
											<td class="hidden-phone">
											<div class="control-group">
												 
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />Absent &nbsp; &nbsp; &nbsp; &nbsp;<i class="icon-pencil"> Note</i> 
											   </div>	
											</td>
											
											<td class="hidden-phone">
												<div class="control-group">
												 
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />Absent &nbsp; &nbsp; &nbsp; &nbsp;<i class="icon-pencil"> Note</i> 
											   </div>
											</td>
											
											<td class="hidden-phone">
												<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												    <input type="checkbox" value="" />Absent &nbsp; &nbsp; &nbsp; &nbsp;<i class="icon-pencil"> Note</i> 
											   </div>
											</td>
										</tr>
										<tr class="odd gradeX">
											<td>2</td>
											<td>Ilakkiya</td>
											
											
											<td>
											<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>
											</td>
											
											<td class="center hidden-phone">
											<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
												</div>
												</td>
											
											<td class="hidden-phone">
											<div class="control-group">
												 
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>	
											</td>
											
											<td class="hidden-phone">
												<div class="control-group">
												 
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>
											</td>
											
											<td class="hidden-phone">
												<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span810 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>
											</td>
											
										</tr>
										<tr class="odd gradeX">
											<td>3</td>
											
											<td>Indumathy</td>
											
											<td>
											<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>
											</td>
											
											<td class="center hidden-phone">
											<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
												</div>
												</td>
											
											<td class="hidden-phone">
											<div class="control-group">
												 
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>	
											</td>
											
											<td class="hidden-phone">
												<div class="control-group">
												 
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>
											</td>
											
											<td class="hidden-phone">
												<div class="control-group">
												  
												  <div class="controls">
													 <input type="text" class="span10 m-wrap" />
													 
												  </div>
												   <input type="checkbox" value="" />
											   </div>
											</td>
										</tr>
										
										
										
										</tbody>
								</table>
								
								<div id="popup">
							
							<div id="event_edit_container" class="ui-dialog-content ui-widget-content">
<form class="note-form">
<input type="hidden" value="">
<ul class="note-list">




<li>
<label for="body">Remarks: <i class="icon-remove" style="float: right;"></i></label>
<textarea name="body"></textarea>
</li>
</ul>

</form>
</div>

						</div>
								<div class="control-group">
                                       <label class="control-label"></label>
                                       <div class="controls">
                                          <select class="small m-wrap" tabindex="1">
                                             <option value="Category 1" />10
                                             <option value="Category 2" />25
                                             <option value="Category 3" />45
                                             <option value="Category 4" />50
                                          </select>
                                       </div>
                                    </div>
								
								<table id="pagination"><tr><td><i class="icon-fast-backward"></i>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><i class="icon-step-backward"></i>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Page <input type="text" class="movepage"> of 3&nbsp;&nbsp;&nbsp;&nbsp;</td><td><i class="icon-step-forward"></i>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><i class="icon-fast-forward"></i></td>&nbsp;&nbsp;&nbsp;&nbsp;</tr></table>
								<div class="control-group" style="text-align:right;">
									<div class="controls">
									<button class="btn blue" type="button">    Add Marks    </button>
									</div>
								</div>
							</div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->
					</div>
				</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->	
		</div>
		<!-- END PAGE -->	 	
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		2013 &copy; MySchool
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
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->
	<script src="assets/js/app.js"></script>	

	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	
	<script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>	
	<script>
		jQuery(document).ready(function() {			
			// initiate layout and plugins
			App.setPage('calendar');
			App.init();
		});
	</script>
	<script>
	$(document).ready(function(){
		$("#popup").hide();
		$("#note").click(function(){
		
		$("#popup").show();
		});
		$(".icon-remove").click(function(){
		
		$("#popup").hide();
		});
		});
		</script>
	
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>