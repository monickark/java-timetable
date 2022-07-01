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
	<title>CMS Editor</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />

		<link rel="stylesheet" type="text/css" href="assets/css/jquery-te-1.4.0.css" />
		<link rel="stylesheet" type="text/css" href="assets/css/demo.css" />
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">

	<button class="status">Toggle jQTE</button>

<!------------------------------------------------------------ jQUERY TEXT EDITOR ------------------------------------------------------------>
<form:form commandName="cms" action="cmseditor.htm" method="POST" class="form-horizontal">
<h3>Title:</h3><form:input name="title" path="title" /><br/>
<form:textarea name="about_author" path="about_author" class="jqte-test"/>


<input type='submit' class="status" value="Insert into table"/>
</form:form>


	<script src="assets/js/jquery-1.8.3.min.js"></script>				
	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	
	<script type="text/javascript" src="assets/js/jquery-te-1.4.0.min.js"></script>	
	<script>
	$('.jqte-test').jqte();
	
	// settings of status
	var jqteStatus = true;
	$(".status").click(function()
	{
		jqteStatus = jqteStatus ? false : true;
		$('.jqte-test').jqte({"status" : jqteStatus})
	});
</script>
</body>
<!-- END BODY -->
</html>