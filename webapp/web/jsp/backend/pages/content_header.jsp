<%-- 
    Document   : content_header
    Created on : Jan 8, 2019, 8:11:15 AM
    Author     : huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content-header">
    <h1>
      ${category}
      <small>${subcategory}</small>
    </h1>
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
      <li class="breadcrumb-item active">${category}</li>
    </ol>
</section>
