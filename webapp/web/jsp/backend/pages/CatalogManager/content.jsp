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
                                            <button id="catalog-toggle-${catalog.catalogId}" onclick="onClickToggle('${catalog.catalogId}')" class="btn btn-action">
                                                <i class="fas fa-check"></i>
                                            </button>
                                            <button onclick="location.href = 'catalog-goedit.htm?catalogId=${catalog.catalogId}'" class="btn btn-action btn-info">
                                                <i class="fas fa-pen"></i>
                                            </button>
<!--                                            <button onclick="location.href = 'catalog_delete.htm?catalogId=${catalog.catalogId}'" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>-->
                                            <button onclick="onClickDelete('${catalog.catalogId}')" class="btn btn-action btn-danger">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </th>
                                        <script>
                                            //Function
                                            function initDataStatus(catalogId,status) {
                                                if(typeof status !== 'boolean') return;
                                                document.getElementById('catalog-status-'+catalogId).innerHTML = (status==true)? "Kích hoạt":"Không kích hoạt";
                                                document.getElementById('catalog-status-'+catalogId).className = (status==true)?"":"text-danger";
                                                document.getElementById('catalog-toggle-' + catalogId).className = "btn btn-action " + ((status==true)?"btn-secondary":"btn-success");
                                            }
                                            
                                            function onClickDelete(catalogId) {
                                                $.ajax({
                                                    url: 'catalog_delete.htm?catalogId=' + catalogId,
                                                    type: 'GET',
                                                    dataType: 'json',
                                                    success: function (result) {
                                                        console.log('Delete output',result);
                                                        var check = result.delete_result;
                                                        if(typeof check === 'boolean' && check) {
                                                            var element = document.getElementById('catalog-item-'+catalogId);
                                                            element.parentNode.removeChild(element);
                                                        }
                                                    },
                                                    error: function (result) {
                                                        console.log('Error output',result);
                                                    }
                                                })
                                            }
                                            
                                            function onClickToggle(catalogId) {
                                                $.ajax({
                                                    url: 'catalog_toggle.htm?catalogId=' + catalogId,
                                                    type: 'GET',
                                                    dataType: 'json',
                                                    success: function (result) {
                                                        console.log('Success', result);
                                                        var status = result.status;
                                                        if(typeof status === 'boolean') {
                                                           console.log("Success:",$("#catalog-status" + catalogId));
                                                           initDataStatus(catalogId,status);
                                                        }
                                                    },
                                                    error: function (result) {
                                                        console.log('Error', result);
                                                    }
                                                })
                                            }
                                            
                                            //Create data
                                            initDataStatus('${catalog.catalogId}',${catalog.status});
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