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
                                <c:forEach items="${listModerator}" var="moderator">
                                    <tr id='account-item-${moderator.accountId}'>
                                        <th>${moderator.accountId}</th>
                                        <th>${moderator.userName}</th>
                                        <th>${moderator.type==1? "Admin":moderator.type==2? "Editor":moderator.type==3? "Moderator":moderator.type==4? "User":"Vip user"}</th>
                                        <th>${moderator.fullName}</th>
                                        <th>${moderator.birthDay}</th>
                                        <th>${moderator.mail}</th>
                                        <th>${moderator.phone}</th>
                                        <th>${moderator.isOnline}</th>
                                        <th id='account-status-${moderator.accountId}'></th>
                                        <th class="d-block">
                                            <button id='account-toggle-${moderator.accountId}' onclick="onClickToggleAccount('${moderator.accountId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="onClickEditAccount('${moderator.accountId}')" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button onclick="onClickDeleteAccount('${moderator.accountId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                    </tr>
                                <script>
                                    //Create data
                                    initDataStatusAccount('${moderator.accountId}',${moderator.status});
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