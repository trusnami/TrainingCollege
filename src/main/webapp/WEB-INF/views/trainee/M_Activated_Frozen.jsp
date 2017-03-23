<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Training College | Trainee</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/css/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/css/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="/css/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="/css/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="/css/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="/css/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="/css/bootstrap3-wysihtml5.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="/trainee/home" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>T</b>C</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Training</b>College</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->

                    <!-- Notifications: style can be found in dropdown.less -->

                    <!-- Tasks: style can be found in dropdown.less -->

                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/img/os-x-lion-for-music.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${trainee.username}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="/img/os-x-lion-for-music.jpg" class="img-circle" alt="User Image">

                                <p>
                                    ${trainee.username} - ${trainee.id}
                                    <small>registered on 2017/03/12</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">
                                            state
                                            ${trainee.memberstate}</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">
                                            balance
                                            ${trainee.balance}</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">
                                            points
                                            ${trainee.point}</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/user/logout" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->

                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/img/os-x-lion-for-music.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${trainee.username}</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">MAIN NAVIGATION</li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-share"></i> <span>Membership</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/trainee/M_Binding_Unbinding"><i class="fa fa-circle-o"></i> Binding | Unbinding </a></li>

                        <li><a href="/trainee/M_Activated_frozen"><i class="fa fa-circle-o"></i> Activated | Frozen </a></li>

                        <%--<li><a href="/trainee/M_Level_Point"><i class="fa fa-circle-o"></i> Level | Point </a></li>--%>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-share"></i> <span>Course</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/trainee/C_Subscribe"><i class="fa fa-circle-o"></i> Subscribe </a></li>

                        <li><a href="/trainee/C_Unsubscribe"><i class="fa fa-circle-o"></i> Unsubscribe </a></li>

                        <%--<li><a href="/trainee/C_Check_Withdraw"><i class="fa fa-circle-o"></i> Check | Withdraw </a></li>--%>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-share"></i> <span>Information</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <%--<li><a href="/trainee/I_Course"><i class="fa fa-circle-o"></i> Course </a></li>--%>

                        <li><a href="/trainee/I_Member"><i class="fa fa-circle-o"></i> Member </a></li>

                        <%--<li><a href="/trainee/I_Expense"><i class="fa fa-circle-o"></i> Expense </a></li>--%>
                    </ul>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Membership
                <small> Activated | Frozen </small>
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">

                <div class="col-md-6">
                    <!-- Widget: user widget style 1 -->
                    <div class="box box-widget widget-user-2">
                        <!-- Add the bg color to the header using any of the bg-* classes -->
                        <div class="widget-user-header bg-yellow">
                            <div class="widget-user-image">
                                <img class="img-circle" src="/img/os-x-lion-for-music.jpg" alt="User Avatar">
                            </div>
                            <!-- /.widget-user-image -->
                            <h3 class="widget-user-username">id : ${trainee.id}</h3>
                            <div class="row">
                                <div class="col-lg-2">
                                    <h5 class="widget-user-desc">${trainee.memberstate}</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4">
                                    <button type="button" class="btn btn-block btn-default "
                                            onclick="location='http://localhost:8080/trainee/changestate?traineeid=${trainee.id}'"
                                    >membership change</button>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer no-padding">
                            <ul class="nav nav-stacked">
                                <li><a href="#">Level <span class="pull-right badge bg-blue">${trainee.level}</span></a></li>
                                <li><a href="#">Point <span class="pull-right badge bg-aqua">${trainee.point}</span></a></li>
                                <li><a href="#">Balance <span class="pull-right badge bg-green">${trainee.balance}</span></a></li>
                                <li><a href="#">Cut-off Date <span class="pull-right badge bg-red">${trainee.date}</span></a></li>

                            </ul>
                        </div>
                    </div>
                    <!-- /.widget-user -->
                </div>
                <div class="col-md-6">
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Level Benefit</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>

                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="box-group" id="accordion">
                                <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                <div class="panel box box-primary">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" class="collapsed">
                                                Level 1
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body">
                                            discount:0.9
                                            <br>
                                            exchange rate 1:30
                                        </div>
                                    </div>
                                </div>
                                <div class="panel box box-danger">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed" aria-expanded="false">
                                                Level 2
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body">
                                            discount:0.8
                                            <br>
                                            exchange rate 1:25
                                        </div>
                                    </div>
                                </div>
                                <div class="panel box box-success">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed" aria-expanded="false">
                                                Level 3
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body">
                                            discount:0.7
                                            <br>
                                            exchange rate 1:20
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">Recharge</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>

                            </div>
                        </div>
                        <form role="form" action="/trainee/recharge" METHOD="POST">
                            <div class="box-body">
                                <div class="form-group">
                                    <label>choose a card</label>
                                    <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                        <option selected="selected"></option>
                                        <c:forEach var="item" items="${cardList}" >
                                            <option>
                                                    ${item.getCardnumber()}
                                            </option>
                                        </c:forEach>
                                    </select><span class="select2 select2-container select2-container--default select2-container--below"
                                                   dir="ltr" style="width: 100%;">
                    <span class="selection">
                        <span class="select2-selection select2-selection--single" role="combobox" aria-haspopup="true"
                              aria-expanded="false" tabindex="0" aria-labelledby="select2-wyno-container">
                            <span class="select2-selection__rendered" id="select2-wyno-container"
                                  title=""></span><span class="select2-selection__arrow"
                                                        role="presentation"><b role="presentation"></b>
                        </span></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
                                </div>
                                <div class="form-group">
                                    <label>recharge amount</label>
                                    <input type="number" name="rechargeAmount" class="form-control"  placeholder="Enter recharge amount">
                                </div>


                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Points Exchange</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>

                            </div>
                        </div>
                        <form role="form" action="/trainee/exchange" METHOD="POST">
                            <div class="box-body">

                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-dollar"></i></span>
                                    <input type="number" name="money" class="form-control">
                                    <span class="input-group-addon"><i class="fa fa-ambulance"></i></span>
                                </div>

                                <!-- /input-group -->
                            </div>
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                        <!-- /.box-body -->
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.8
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-user bg-yellow"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                <p>New phone +1(800)555-1234</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                <p>nora@example.com</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-file-code-o bg-green"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                <p>Execution time 5 seconds</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="label label-danger pull-right">70%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Update Resume
                                <span class="label label-success pull-right">95%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Laravel Integration
                                <span class="label label-warning pull-right">50%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Back End Framework
                                <span class="label label-primary pull-right">68%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Allow mail redirect
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Other sets of options are available
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Expose author name in posts
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Allow the user to show his name in blog posts
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <h3 class="control-sidebar-heading">Chat Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Show me as online
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Turn off notifications
                            <input type="checkbox" class="pull-right">
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Delete chat history
                            <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                        </label>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/js/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="/js/morris.min.js"></script>
<!-- Sparkline -->
<script src="/js/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/js/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/js/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/js/daterangepicker.js"></script>
<!-- datepicker -->
<script src="/js/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/js/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="/js/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/js/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/js/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/js/demo.js"></script>
</body>
</html>

