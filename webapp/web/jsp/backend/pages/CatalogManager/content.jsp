<%-- 
    Document   : content
    Created on : Jan 16, 2019, 5:20:01 AM
    Author     : huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content">
    <div class="row">
        <div class="col-12">
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">Data Table With Full Features</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="table-responsive">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>View</th>
                                    <th>Parent</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listCatalog}" var="catalog">
                                    <tr>
                                        <th>${catalog.catalogId}</th>
                                        <th>${catalog.catalogName}</th>
                                        <th>${catalog.description}</th>
                                        <th>${catalog.view}</th>
                                        <th>${catalog.parentId}</th>
                                        <th class="${catalog.status==true?"":"text-danger"}">${catalog.status==true? "active":"inactive"}</th>
                                        <th>
                                            <button onclick="location.href='toggle.htm?catalogId=${catalog.catalogId}'" class="btn ${catalog.status==true?"btn-secondary":"btn-success"}">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="location.href='catalog-edit.htm?catalogId=${catalog.catalogId}'" class="btn btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button class="btn btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Age</th>
                                    <th>Start date</th>
                                    <th>Salary</th>
                                </tr>
                            </tfoot>
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