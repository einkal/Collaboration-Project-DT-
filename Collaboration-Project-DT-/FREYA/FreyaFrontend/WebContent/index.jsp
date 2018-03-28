<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <title></title>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
  	<link href="Styles.css" rel="stylesheet" />
  	<script src="js/app.js"></script>
  	<script src="c_blog/BlogController.js"></script>
</head>
<body>

    <table style="font-family: Arial">
        <tr>
            <td colspan="2" class="header">
                <h1>
                    Freya 
                </h1>
                
            </td>
        </tr>
        <tr>
            <td class="leftMenu">                
                <a href="#/Home">Home</a>
                <a href="#/Job">Job</a>
                <a href="#/Friend">Friend</a>
			    <a href="#/Blog">Blog</a>
				                
            </td>
            <td class="mainContent">
                <ng-view></ng-view>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="footer">
                <b>Copyright since 2018</b>
            </td>
        </tr>
    </table>
</body>
</html>