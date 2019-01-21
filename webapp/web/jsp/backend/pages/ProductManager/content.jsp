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
                                    <th>Tên</th>
                                    <th>Giá</th>
                                    <th>Khuyến mãi</th>
                                    <th>Số lượng</th>
                                    <th>Đã bán</th>
                                    <th>Danh mục</th>
                                    <th>Kích hoạt</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listProduct}" var="product">
                                    <tr id='product-item-${product.productId}'>
                                        <th>${product.productId}</th>
                                        <th>${product.productName}</th>
                                        <th>${product.priceOutput}</th>
                                        <th>${product.discount}</th>
                                        <th>${product.quantity}</th>
                                        <th>${product.sold}</th>
                                        <th>${product.catalogName}</th>
                                        <th id='product-status-${product.productId}'></th>
                                        <th class="d-block">
                                            <button id='product-toggle-${product.productId}' onclick="onClickToggleProduct('${product.productId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="location.href = 'product-goedit.htm?productId=${product.productId}'" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button onclick="onClickDeleteProduct('${product.productId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                    </tr>
                                <script>
                                    //Create data
                                    initDataStatusProduct('${product.productId}',${product.status});
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