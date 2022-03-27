<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="version" value="1.0.0" scope="session" />
<c:set var="Account_present" value="${Account_present}" scope="session" />
<c:set var="Customer_present" value="${Customer_present}" scope="session" />

<div class="container tt">
<div>
    <div class="main">
        <div class="topbar_">
        	<a href=""> Đổi mật khẩu</a>
        </div>
        <div class="row">
            <div class="col-md-4 mt-1">
                <div class="card text-center sidebar">
                    <div class="card-body ">
                        <img src="~/images/Userlogo.png" alt="" class="" width="150">
                        <div class="mt-3">
                            <h4>${Account_present.getTENTK()}</h4>

                            
                            <a href="">Số xe đã đăng: </a>
                           
                                <div class="edit-tt"> <a href="${pageContext.request.contextPath}/userinfo-edit"><i class="far fa-edit"></i> Chỉnh sửa thông tin</a></div>
                                <div class="edit-tt"> <a href=""><i class="far fa-edit"></i> Danh sách xe đăng ký bán</a></div>
                              

                         
                        </div>
                    </div>
                </div>
                <div class="card mb-3 content">
                    <h1 class="m-3">Thông tin khác</h1>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-7">
                                <h4 style="font-weight:bold">Lịch sử bình luận</h4>
                            </div>
                            <div class="col-md-5 text-secondary">
                                <a href=""> Xem thêm</a> <br />

                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-7">
                                <h4 style="font-weight:bold">Lịch sử hợp đồng</h4>
                            </div>
                            <div class="col-md-5 text-secondary">
                                <a href=""> Xem thêm</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-8 mt-1">
                <div class="card mb-3 content">
                    <h1 class="m-3 pt-3"> Thông tin chi tiết</h1>
                    <div class="card-body">
                        
                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">Họ Tên</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Customer_present.getTENKH()}
                                </div>
                            </div>
                            <hr>

                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">Số điện thoại</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Customer_present.getSDT()}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">Giới tính</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Customer_present.getGIOITINH()}
                                </div>
                            </div>
                            <hr>

                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">Trạng thái</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Account_present.getTRANGTHAI()}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">Email</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Customer_present.getEMAIL()}
                                </div>
                            </div>
                            <hr>

                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">CMND</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Customer_present.getCMND()}
                                </div>
                            </div>
                            <hr>

                            <div class="row">
                                <div class="col-md-3">
                                    <h4 style="font-weight:bold">Địa chỉ</h4>
                                </div>
                                <div class="col-md-9 text-secondary">
                                    ${Customer_present.getDIACHI()}
                                </div>
                            </div>
							<hr>
							<hr>
							<hr>
                        
                        

                    </div>
                </div>
                
            </div>
        </div>
    </div>
</div>
</div>