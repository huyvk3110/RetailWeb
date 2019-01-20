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
                    <f:form action="catalog-insert.htm" commandName="catalog">
                        <div class="form-group">
                            <h5>ID danh mục<span class="text-danger">*</span></h5>
                            <div class="controls">
                                <f:input path="catalogId" value="${catalogId}"  class="form-control" readonly="true"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Tên danh mục</h5>
                            <div class="controls">
                                <f:input path="catalogName" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Mô tả</h5>
                            <div class="controls">
                                <f:input path="description" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Độ ưu tiên danh mục</h5>
                            <div class="controls">
                                <f:input path="priority" class="form-control"/></div>
                        </div>
                        <div class="form-group">
                            <h5>Danh mục cha</h5>
                            <div class="controls">
                                <f:select path="parentId" id="parentId" name="select" class="form-control">
                                    <f:option value="" label="Danh mục chính"/>
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

</section>