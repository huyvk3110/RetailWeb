<%-- 
    Document   : content
    Created on : Jan 16, 2019, 5:20:01 AM
    Author     : huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../content_header.jsp"></jsp:include>
    <section class="content">

        <!-- Basic Forms -->
        <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
                <div class="row">
                    <div class="col">
                    <f:form action="account-edit.htm" commandName="account-edit">
                        <div class="form-group">
                            <h5>ID<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="accountId" value="${accountId}"  class="form-control" readonly="true"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Tài khoản<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="userName" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Mật khẩu<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="passWord" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <h5>Loại</h5>
                            <div class="controls">
                                <f:select path="type" id="accountType" name="select" class="form-control">
                                    <f:option value="4" label="Khách hàng"/>
                                    <f:option value="5" label="Khách hàng thân thiết"/>
                                    <f:option value="3" label="Quản trị viên"/>
                                    <f:option value="2" label="Biên tập viên"/>
                                </f:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <h5>Họ và tên</h5>
                            <div class="controls">
                                <f:input path="fullName" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Ảnh đại diện</h5>
                            <div class="controls">
                                <f:input path="avatar" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Ngày sinh</h5>
                            <div class="controls">
                                <f:input path="birthDay" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Mail</h5>
                            <div class="controls">
                                <f:input path="mail" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Phone</h5>
                            <div class="controls">
                                <f:input path="phone" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Địa chỉ</h5>
                            <div class="controls">
                                <f:input path="address" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Trạng thái</h5>
                            <div class="controls">
                                <f:select path="status"  id="status" name="select" class="form-control">
                                    <f:option value="true" label="Kích hoạt"/>
                                    <f:option value="false" label="Không kích hoạt"/>
                                </f:select>
                            </div>
                        </div>
                        <div class="text-xs-right">
                            <input type="submit" value="Edit" class="btn btn-info">
                        </div>
                    </f:form>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.box-body -->
    </div>
    <!-- /.box -->
    <script>
        $('#account-edit').submit(function (e) {
            e.preventDefault();
            $.ajax({
                url: 'account-edit.htm',
                type: 'POST',
                data: $(this).serialize(),
                dataType: 'json',
                success: function (result) {
                    console.log('Success');
                    var check = result.status;
                    if (check) {
                        goModeratorManager();
                    } else {
                        goError(e);
                    }
                },
                error: function (result) {
                    console.log('Error',result);
                }
            });
        });
    </script>
</section>