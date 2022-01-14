<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingListURL" value="/admin/building-list"/>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
<title>Building-List</title>
<!-- <title>Trang chủ</title> -->
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check("breadcrumbs", "fixed");
                } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul>
            <!-- /.breadcrumb -->

            <!-- <div class="nav-search" id="nav-search">
                          <form class="form-search">
                              <span class="input-icon">
                                  <input type="text" placeholder="Search ..." class="nav-search-input"
                                      id="nav-search-input" autocomplete="off" />
                                  <i class="ace-icon fa fa-search nav-search-icon"></i>
                              </span>
                          </form>
                      </div>/.nav-search -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Dashboard
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div>
            <!-- /.page-header -->
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="widget-box">

                    <div class="widget-header">
                        <h4 class="widget-title">Search</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <form:form commandName="modelSearch" action="${buildingListURL}" id="listForm" method="GET">
                                        <from:from class="form-horizontal">
                                            <div class="form-group">
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label for="name">Buildings Name</label>
                                                        <!-- <input type="text" id="name" placeholder="Tên Tòa Nhà" class="form-control" name="name"/> -->
                                                        <form:input path="name" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label for="buildingArea">Diện Tích Sàn</label>
                                                        <!-- buildingArea ko the sai  <form:input></form:input> -->
                                                        <input type="number" id="buildingArea" placeholder="Diện Tích Tòa Nhà"
                                                               class="form-control" name="buildingArea" value="${modelSearch.buildingArea}"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="district">District</label>
                                                        <form:dropdown items="${district}" path="district"></form:dropdown>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="ward">Ward</label>
                                                        <!-- <input type="type" id="ward" placeholder="Ward" class="form-control" name="ward"/> -->
                                                        <form:input path="ward" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="street">Street</label>
                                                        <!-- <input type="text" id="street" placeholder="Street" class="form-control" name="street"/> -->
                                                        <form:input path="street" cssClass="form-control" />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="numberOfBasement">Number Of Basement</label>
                                                        <input type="number" id="numberOfBasement" placeholder="Số Tầng Hầm"
                                                               class="form-control" name="numberOfBasement"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="direction">Direction</label>
                                                        <input type="text" id="direction" placeholder="Hướng Tòa Nhà" class="form-control" name="direction"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="level">Level</label>
                                                        <input type="number" id="level" placeholder="Hạng" class="form-control" name="level"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label for="areaRentFrom">Buildings Area from</label>
                                                        <input type="number" id="areaRentFrom" name="areaRentFrom"
                                                               placeholder="Buildings Area from" class="form-control" name="areaRentFrom"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label for="areaRentTo">Buildings Area To</label>
                                                        <input type="number" id="areaRentTo" name="areaRentTo" placeholder="Buildings Area To"
                                                               class="form-control" name="areaRentTo" />
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label for="rentPriceFrom">Rent Price From</label>
                                                        <input type="number" id="rentPriceFrom" name="rentPriceFrom" placeholder="Rent Price From"
                                                               class="form-control" name="rentPriceFrom" />
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label for="rentPriceTo">Rent Price To</label>
                                                        <input type="number" id="rentPriceTo" name="rentPriceTo" placeholder="Rent Price To"
                                                               class="form-control" name="rentPriceTo" />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="managerName">Managers Name </label>
                                                        <input type="number" id="managerName" placeholder="Managers Name" class="form-control" name="managerName" />
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="managerPhone">Managers Phone</label>
                                                        <input type="tel" id="managerPhone" placeholder="Managers Phone" class="form-control" name="managerPhone" />
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label for="staffId">choose staff in charge</label>
                                                        <form:dropdown items="${staffId}" path="staffId"></form:dropdown>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-9">
                                                <label class="col-sm-4 control-label no-padding-right" for="buildingTypes">Building Types</label>
                                                <form:checkbox items="${buildingTypes}" path="buildingTypes"></form:checkbox>
                                            </div>

                                            <div>
                                                <form:hidden path="id" cssClass="col-xs-10 col-sm-12"></form:hidden>
                                            </div>
                                            <div class="row">
                                                <button type="button" class="btn btn-primary">Search</button>
                                            </div>
                                        </from:from>
                                    </from:from>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="pull-right">
                    <button class="btn btn-white btn-new-mail btn-bold" data-toggle="tooltip" title="Add New Building">
                        <i class="ace-icon fa fa-plus-circle bigger-120 green"></i>
                        <!-- Add New -->
                    </button>
                    <button class="btn btn-white btn-warning btn-bold" data-toggle="tooltip" id="btnDeleteBuilding" title="Remove Building Exit">
                        <i class="ace-icon fa fa-trash bigger-120 red"></i>
                    </button>
                </div>

            </div>

            <!-- <div class="widget-bot">
							<div class="widget-header">
								<h4 class="widget-title">Text Area</h4>

								<div class="widget-toolbar">
									<a href="#" data-action="collapse">
										<i class="ace-icon fa fa-chevron-up"></i>
									</a>

									<a href="#" data-action="close">
										<i class="ace-icon fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="widget-body">
								<div class="row">
									<div class="col-xs-12">
										<div class="col-sm-6">
											<label for="name">Tên Tòa Nhà</label>
											<input type="text" id="name" placeholder="Tên Tòa Nhà"
												class="form-control" />
										</div>
										<div class="col-sm-6">
											<label for="buildingArea">Diện Tích Sàn</label>
											<input type="number" id="buildingArea" placeholder="Diện Tích Tòa Nhà"
												class="form-control" />
										</div>
									</div>
								</div>
							</div>

						</div>/.col -->
            <div class="row">
                <div class="col-xs-12">
                    <table id="buildingList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <!-- <th class="center">
                              <label class="pos-rel">
                                <input type="checkbox" class="ace" />
                                <span class="lbl"></span>
                              </label>
                            </th> -->
                            <th></th>
                            <th>Name Buildings</th>
                            <th>Number Of Basement</th>
                            <th>Address</th>
                            <th>Managers Name</th>
                            <th>Number Phone</th>
                            <th>Buildings Area</th>
                            <th>Rent Price</th>
                            <th>Services Cost</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:foreach var="item" items="${buildings}">
                            <tr>
                                <td><input type="checkbox" name="" value="2" id="checkbox_2"/></td>
                                <td>${item.name}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.address}</td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.buildingArea}</td>
                                <td>${item.costRent}</td>
                                <td>${item.serviceCost}</td>
                                <td>
                                    <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                            title="Giao Tòa Nhà" onclick="assignmentBuilding(2)">
                                        <i class="fa fa-bars" aria-hidden="true"></i>
                                    </button>
                                </td>
                            </tr>
                        </c:foreach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content -->
</div>
</div>
<!-- /.main-content -->
<!-- assignmentBuilding Modal -->
<div class="modal fade" id="assignmentBuildingModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times; </button>
                <h4 class="modal-title">Staffs List</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered" id="staffsList">
                    <thead>
                    <tr>
                        <th>Assign</th>
                        <th>Staffs</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="checkbox" value="2" id="checkbox_2" checked/></td>
                        <td>Nguyễn Văn B</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="3" id="checkbox_3"/></td>
                        <td>Nguyễn Văn c</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="4" id="checkbox_4"/></td>
                        <td>Nguyễn Văn d</td>
                    </tr>
                    </tbody>
                </table>
                <input type="hidden" name="buildingId" id="buildingId" value="" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="btnAssignBuilding">Assign</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<script>
    function assignmentBuilding(buildingId) {
        openModelAssignmentBuilding();
        $('#buildingId').val(buildingId);
        console.log( $('#buildingId').val());
    }

    function openModelAssignmentBuilding() {
        $('#assignmentBuildingModal').modal();
    }

    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        //call Api
        var data ={};
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        assignStaff(data);
    });

    function assignStaff(data){
        $.ajax({
            url: 'http://localhost:8081/api-user-assignment',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(response){
                //called successfull
                console.log('Success');
            },
            error: function(response){
                //called failed
                console.log('Fail');
                console.log('response');
            }
        });
    }

    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var data ={};
        var buildingId = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['buildingId'] = buildingId;
        deleteBuilding(data);
    });

    function deleteBuilding(data){
        $.ajax({
            url: 'http://localhost:8081/api-building',
            type: 'DELETE',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(response){
                //called successfull
                console.log('Success');
            },
            error: function(response){
                //called failed
                console.log('Fail');
                console.log('response');
            }
        });
    }

    $('#btnSearch').click(function (e)  {
        e.preventDefault();
        $('#listForm').submit();
    });

</script>
</body>
</html>