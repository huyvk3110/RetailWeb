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
                                <c:forEach items="${listAccount}" var="account">
                                    <tr id='account-item-${account.accountId}'>
                                        <th>${account.accountId}</th>
                                        <th>${account.userName}</th>
                                        <th>${account.type}</th>
                                        <th>${account.fullName}</th>
                                        <th>${account.birthDay}</th>
                                        <th>${account.mail}</th>
                                        <th>${account.phone}</th>
                                        <th>${account.isOnline}</th>
                                        <th id='account-status-${account.accountId}'></th>
                                        <th class="d-block">
                                            <button id='account-toggle-${account.accountId}' onclick="onClickToggleProduct('${account.accountId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="onClickEditProduct('${account.accountId}')" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button onclick="onClickDeleteProduct('${account.accountId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                    </tr>
                                <script>
                                    //Create data
//                                    initDataStatusProduct('${account.accountId}',${account.status});
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