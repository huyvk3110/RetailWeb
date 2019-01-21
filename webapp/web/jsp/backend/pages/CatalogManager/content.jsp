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
                                    <th>Tênh</th>
                                    <th>Mô tả</th>
                                    <th>Lượt xem</th>
                                    <th>Danh mục cha</th>
                                    <th>Trạng thái</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listCatalog}" var="catalog">
                                    <tr id="catalog-item-${catalog.catalogId}">
                                        <th>${catalog.catalogId}</th>
                                        <th>${catalog.catalogName}</th>
                                        <th>${catalog.description}</th>
                                        <th>${catalog.view}</th>
                                        <th>${catalog.parentName}</th>
                                        <th id="catalog-status-${catalog.catalogId}"></th>
                                        <th class="d-block">
                                            <button id="catalog-toggle-${catalog.catalogId}" onclick="onClickToggleCatalog('${catalog.catalogId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
<!--                                            <button onclick="location.href = 'catalog-goedit.htm?catalogId=${catalog.catalogId}'" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>-->
                                            <button onclick="onClickEditCatalog('${catalog.catalogId}')" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button onclick="onClickDeleteCatalog('${catalog.catalogId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                <script>
                                    //Create data
                                    initDataStatusCatalog('${catalog.catalogId}',${catalog.status});
                                </script>
                                </tr>
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
    <script src="../jsp/backend/js/pages/datatables.min.js"></script>   
    <script src="../jsp/backend/js/pages/data-table.js"></script>
</section>