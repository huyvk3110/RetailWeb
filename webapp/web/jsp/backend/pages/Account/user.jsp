<%-- 
    Document   : content
    Created on : Jan 16, 2019, 5:20:01 AM
    Author     : huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../jsp/backend/css/custom/button-custom.css">	
<jsp:include page="../content_header.jsp"></jsp:include>
    <section class="content">
        <div class="row">
            <div class="col-12">
                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div class="table-responsive">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>User Name</th>
                                        <th>Chức năng</th>
                                        <th>Họ tên</th>
                                        <th>Ngày sinh</th>
                                        <th>Mail</th>
                                        <th>SDT</th>
                                        <th>Online</th>
                                        <th>Kích hoạt</th>
                                        <th>Hành động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listUser}" var="user">
                                    <tr id='account-item-${user.accountId}'>
                                        <th>${user.accountId}</th>
                                        <th>${user.userName}</th>
                                        <th>${user.type==1? "Admin":user.type==2? "Editor":user.type==3? "Moderator":user.type==4? "User":"Vip user"}</th>
                                        <th>${user.fullName}</th>
                                        <th>${user.birthDay}</th>
                                        <th>${user.mail}</th>
                                        <th>${user.phone}</th>
                                        <th>${user.isOnline}</th>
                                        <th id='account-status-${user.accountId}'></th>
                                        <th class="d-block">
                                            <button id='account-toggle-${user.accountId}' onclick="onClickToggleAccount('${user.accountId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="onClickEditAccount('${user.accountId}')" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button onclick="onClickDeleteAccount('${user.accountId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                    </tr>
                                <script>
                                    //Create data
                                    initDataStatusAccount('${user.accountId}',${user.status});
                                </script>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->        
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>