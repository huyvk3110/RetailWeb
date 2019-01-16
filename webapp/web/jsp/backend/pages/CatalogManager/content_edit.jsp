<%-- 
    Document   : content
    Created on : Jan 16, 2019, 5:20:01 AM
    Author     : huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content">

    <!-- Basic Forms -->
    <div class="box">
        <!-- /.box-header -->
        <div class="box-body">
            <div class="row">
                <div class="col">
                    <f:form action="edit.html" commandName="catalog">
                        <div class="form-group">
                            <h5>ID <span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="catalogId" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Name <span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="catalogName" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Description</h5>
                            <div class="controls">
                                <f:input path="description" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>View</h5>
                            <div class="controls">
                                <f:input path="view" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Priority</h5>
                            <div class="controls">
                                <f:input path="priority" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Parent</h5>
                            <div class="controls">
                                <f:input path="parentId" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Active</h5>
                            <div class="controls">
                                <f:input path="status" class="form-control"/></div>
                        </div>
                        <div class="text-xs-right">
                            <button type="submit" class="btn btn-info">Submit</button>
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

</section>