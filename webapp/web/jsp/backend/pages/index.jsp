﻿<!DOCTYPE html>
<html lang="vi">
    <jsp:include page="head.jsp"></jsp:include>
        <body class="hold-transition skin-black dark-sidebar sidebar-mini">
            <div class="wrapper">
                <!-- Header bar-->
            <jsp:include page="header.jsp"></jsp:include>

                <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="sidebar.jsp"></jsp:include>

                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                <%--<jsp:include page="content_header.jsp"></jsp:include>--%>
                <%--<jsp:include page="content_header.jsp"></jsp:include>--%>
                
                <div id="root"></div>

                    <!-- Main content -->
                <jsp:include page="content.jsp"></jsp:include>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <footer >
            </footer>
            <!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
        </div>
        <!-- ../jsp/backend/wrapper -->
        <!-- ../jsp/backend/wrapper -->
        <!-- jQuery 3 -->
        <script src="../jsp/backend/js/util/jquery-3.3.1.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="../jsp/backend/js/util/jquery-ui.js"></script>
        <!-- popper -->
        <script src="../jsp/backend/js/util/popper.min.js"></script>
        <!-- Bootstrap 4.0-->
        <script src="../jsp/backend/js/util/bootstrap.js"></script>	
        <!-- Slimscroll -->
        <script src="../jsp/backend/js/util/jquery.slimscroll.js"></script>
        <!-- FastClick -->
        <script src="../jsp/backend/js/util/fastclick.js"></script>
        <!-- Sparkline -->
        <script src="../jsp/backend/js/util/jquery.sparkline.min.js"></script>
        <!-- morris-->
        <script src="../jsp/backend/js/util/raphael.js"></script>	
        <script src="../jsp/backend/js/util/morris.js"></script>	

        <!-- Qixa Admin App -->
        <script src="../jsp/backend/js/template.js"></script>

        <!-- Qixa Admin dashboard demo (This is only for demo purposes) -->
        <script src="../jsp/backend/js/pages/dashboard.js"></script>
        
        <!-- Controller -->
        <script src="../jsp/backend/js/backend-controller.js"></script>

    </body>

    <!-- Mirrored from pixaq-admin-templates.wordpressthemeshub.com/main/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 07 Jan 2019 15:22:16 GMT -->
</html>
