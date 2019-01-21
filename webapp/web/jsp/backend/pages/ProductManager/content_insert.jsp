<%-- 
    Document   : content
    Created on : Jan 16, 2019, 5:20:01 AM
    Author     : huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../jsp/backend/css/custom/button-custom.css">	
<jsp:include page="../content_header.jsp"></jsp:include>
    <section class="content">
        <!-- Basic Forms -->
        <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
                <div class="row">
                    <div class="col">
                    <f:form action="product-insert.htm" commandName="product-insert">
                        <div class="form-group">
                            <h5>ID sản phẩm<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="productId" value="${productId}"  class="form-control" readonly="true"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Tên sản phẩm<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="productName" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Giá sản phẩm<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="priceOutput" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Khuyến mại</h5>
                            <div class="controls">
                                <f:input path="discount" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Số lượng<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="quantity" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Chất lượng</h5>
                            <div class="controls">
                                <f:input path="quality" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Tiêu đề SP</h5>
                            <div class="controls">
                                <f:input path="title" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Bảo hành</h5>
                            <div class="controls">
                                <f:input path="guarantee" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>1 Đổi 1</h5>
                            <div class="controls">
                                <f:input path="oneSwitchOne" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Mô tả</h5>
                            <div class="controls">
                                <f:input path="description" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Danh mục cha</h5>
                            <div class="controls">
                                <f:select path="catalogId" id="catalogId" name="select" class="form-control">
                                    <c:forEach items="${listcatalog}" var="_cat">
                                        <f:option value="${_cat.catalogId}" label="${_cat.catalogName}"/>
                                    </c:forEach>
                                </f:select>
                            </div>
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
                        <div class="form-group">
                            <h5>Thông số sản phẩm</h5>
                            <div class="controls">
                                <select id="productType" name="select" class="form-control">
                                    <option value="spec_phone" label="Điện thoại"/>
                                    <option value="spec_acces" label="Phụ kiện"/>
                                    <option value="spec_other" label="Khác"/>
                                </select>
                            </div>
                            <div class="controls">
                                <c:forEach items="${product.specification}" var="spec">
                                    <f:option value="${spec.specificationKey}" label="${spec.specification}"/>
                                </c:forEach>
                            </div>
                            <!--Listen event for add-->
                            <script>
                                var select = document.getElementById("productType");
                                console.log("Select is: ", select.value);
                                select.addEventListener("change", function (e) {
                                    console.log("Select is: ", select.value);
                                    console.log("Specification is: ", product.specification);
                                });
                            </script>
                        </div>
                        <div class="text-xs-right">
                            <input type="submit" value="Insert" class="btn btn-info">
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
        $('#product-insert').submit(function (e) {
            e.preventDefault();
            $.ajax({
                url: 'product-insert.htm',
                type: 'POST',
                data: $(this).serialize(),
                dataType: 'json',
                success: function (result) {
                    var check = result.insertsuccess;
                    if (check) {
                        goProductManager();
                    } else {
                        goError(e);
                    }
                },
                error: function (result) {
                    console.log('Error');
                    goError(e);
                }
            })
        })
    </script>
</section>