<%-- 
    Document   : sidebar
    Created on : Jan 8, 2019, 7:46:42 AM
    Author     : huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<aside class="main-sidebar">
    <!-- sidebar-->
    <section class="sidebar">

        <!-- sidebar menu-->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="active">
                <a href="index.html">
                    <i class="fa fa-dashboard"></i> <span>Trang tổng quan</span>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <span>Danh mục</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-right pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a id="sidebar-catalog-manager" href="#">Quản lý danh mục</a></li>
                    <li><a id="sidebar-catalog-insert" href="#">Thêm danh mục</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <span>Sản phẩm</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-right pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a id="sidebar-product-manager"  href="#">Quản lý sản phẩm</a></li>
                    <li><a id="sidebar-product-insert"  href="#">Thêm sản phẩm</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <span>Người dùng</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-right pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a id="sidebar-moderator-manager"  href="#">Quản trị viên</a></li>
                    <li><a id="sidebar-user-manager"  href="#">Quản lý người dùng</a></li>
                    <li><a id="sidebar-account-insert"  href="#">Thêm người dùng</a></li>
                </ul>
                
            </li>
            <li>
                <a href="index.html">
                    <span>Đơn hàng</span>
                </a>
            </li>
            <li>
                <a href="index.html">
                    <span>Tin tức</span>
                </a>
            </li>
            <li>
                <a href="index.html">
                    <span>Dịch vụ</span>
                </a>
            </li>      
        </ul>
    </section>
</aside>