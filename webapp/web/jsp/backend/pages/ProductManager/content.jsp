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
                                            <button id='product-toggle-${product.productId}' onclick="onClickToggle('${product.productId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="location.href = 'product-goedit.htm?productId=${product.productId}'" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                            <button onclick="onClickDelete('${product.productId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                    <script>
                                        //Function
                                        function initDataStatus(productId, status) {
                                            if (typeof status !== 'boolean') return;
                                            document.getElementById('product-status-' + productId).innerHTML = (status == true) ? "Kích hoạt" : "Không kích hoạt";
                                            document.getElementById('product-status-'+productId).className = (status==true)?"":"text-danger";
                                            document.getElementById('product-toggle-' + productId).className = "btn btn-action " + ((status == true) ? "btn-secondary" : "btn-success");
                                        }

                                        function onClickDelete(productId) {
                                            $.ajax({
                                                url: 'product_delete.htm?productId=' + productId,
                                                type: 'GET',
                                                dataType: 'json',
                                                success: function (result) {
                                                    console.log('Delete output', result);
                                                    var check = result.delete_result;
                                                    if (typeof check === 'boolean' && check) {
                                                        var element = document.getElementById('product-item-' + productId);
                                                        element.parentNode.removeChild(element);
                                                    }
                                                },
                                                error: function (result) {
                                                    console.log('Error output', result);
                                                }
                                            })
                                        }

                                        function onClickToggle(productId) {
                                            $.ajax({
                                                url: 'product_toggle.htm?productId=' + productId,
                                                type: 'GET',
                                                dataType: 'json',
                                                success: function (result) {
                                                    console.log('Success', result);
                                                    var status = result.status;
                                                    if (typeof status === 'boolean') {
                                                        console.log("Success:", $("#product-status" + productId));
                                                        initDataStatus(productId, status);
                                                    }
                                                },
                                                error: function (result) {
                                                    console.log('Error', result);
                                                }
                                            })
                                        }

                                        //Create data
                                        initDataStatus('${product.productId}',${product.status});
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
</section>