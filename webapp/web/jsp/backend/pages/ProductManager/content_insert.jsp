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
                                <table border="0" class="table table-bordered table-striped">
                                    <tbody>
                                        <c:forEach var = "i" begin = "0" end = "11">
                                            <tr>
                                                <td><f:input path="specification[${i}].specificationKey" class="form-control"  readonly="true"/></td>
                                                <td><f:input path="specification[${i}].specification" class="form-control" /></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="form-group">
                            <h5>Hình ảnh sản phẩm</h5>
                            <div class="controls">
                                
                            </div>
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