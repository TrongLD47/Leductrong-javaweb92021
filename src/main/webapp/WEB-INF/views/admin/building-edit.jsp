<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Building-Edit</title>
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
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="col-sx-12">
                    <form class="form-horizontal" role="form" id="formEdit">

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Buildings Name</label>
                            <div class="col-sm-9">
                                <input type="text" id="name" placeholder="Ex: FPT Complex" class="form-control" name="name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="district">District</label>
                            <div class="col-sm-9">
                                <input type="text" id="district" placeholder="Ex: Cam le" class="form-control" name="district" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="ward">Ward</label>
                            <div class="col-sm-9">
                                <input type="text" id="ward" placeholder="Ex: Dien An" class="form-control" name="ward" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="street">Srteet</label>
                            <div class="col-sm-9">
                                <input type="text" id="street" placeholder="Ex: DT609" class="form-control" name="street" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="struct">Struct</label>
                            <div class="col-sm-9">
                                <input type="text" id="struct" placeholder="Ex: " class="form-control" name="struct" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement">Number Of Basements</label>
                            <div class="col-sm-9">
                                <input type="number" id="numberOfBasement" placeholder="Ex: 1"	class="form-control" name="numberOfBasement" value=""/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="floorArea">Floor Area</label>
                            <div class="col-sm-9">
                                <input type="text" id="floorArea" placeholder="Ex: 100,200,300"	class="form-control" name="floorArea" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="direction">Direction</label>
                            <div class="col-sm-9">
                                <input type="text" id="direction" placeholder="Ex: 100,200,300"	class="form-control" name="direction" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="level">Level</label>
                            <div class="col-sm-9">
                                <input type="text" id="level" placeholder="Ex: "	class="form-control" name="level" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentArea">Rent Area</label>
                            <div class="col-sm-9">
                                <input type="text" id="rentArea" placeholder="Ex: 100,200,300"	class="form-control" name="rentArea" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="description">Description</label>
                            <div class="col-sm-9">
                                <input type="text" id="description" placeholder="Ex: 100,200,300"	class="form-control" name="description" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentPrice">Rent Price</label>
                            <div class="col-sm-9">
                                <input type="number" id="rentPrice" placeholder="Ex: 1"	class="form-control" name="rentPrice"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="buildingTypes">Building Types</label>
                            <div class="col-sm-9">
                                <label class="checkbox-inline"><input type="checkbox" value="TANG-TRET" id="buildingTypes" name="buildingTypes">Tầng Trệt</label>
                                <label class="checkbox-inline"><input type="checkbox" value="NGUYEN-CAN" id="buildingTypes" name="buildingTypes">Nguyên Căn</label>
                                <label class="checkbox-inline"><input type="checkbox" value="NOI-THAT" id="buildingTypes" name="buildingTypes">Nội Thất</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <button type="button" class="btn btn-primary" id="btnAddBuilding">Add New Building</button>
                                <button type="button" class="btn btn-danger">Cancel</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.page-content -->
    </div>
</div>
</div>
<!-- /.main-content -->

<script>

    $('#btnAddBuilding').click(function() {
        //call Api Add Building
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            if(v.name == 'buildingTypes') {
                buildingTypes.push(v.value);
            } else {
                data[""+v.name+""] = v.value;
            }
            data['buildingTypes'] = buildingTypes;
        });
        // buildingTypes.push('TANG-TRET');
        // buildingTypes.push('NGUYEN-CAN');
        // data['name'] = 'abc';
        // data['numberOfBasement'] = 100;
        // data['rentArea'] = '100,200,300';
        // data['buildingTypes'] = buildingTypes;
        $.ajax({
            url: 'http://localhost:8081/api-building',
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
    });

</script>

</body>
</html>