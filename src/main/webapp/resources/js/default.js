
$(document).ready(function() {

    //GET Agreements Active from DB
    $("#button1").click(function(){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: 'http://localhost:8081/eik_war_exploded/v1/agreement/agreementsActive',
            success: function(data){
                let jsonArray = JSON.parse(JSON.stringify(data));

                if (  $.fn.DataTable.isDataTable( '#dataTable3' ) ) {
                    $('#dataTable').dataTable().fnClearTable();
                    $('#dataTable').dataTable().fnDestroy();
                }

                $('.content-container').empty();
                $('.content-container').append(" <table id=\"dataTable3\"></table>")

                $('#dataTable3').dataTable({
                    "aaData": jsonArray,
                    "aoColumns":[
                        {
                            "mData":"agreementId",
                            "sTitle": "agreementId"
                        },{
                            "mData":"orderNumber",
                            "sTitle": "orderNumber"
                        },{
                            "mData":"system",
                            "sTitle": "system"
                        },{
                            "mData":"request",
                            "sTitle": "request"
                        },{
                            "mData":"dateFrom",
                            "sTitle": "dateFrom"
                        },{
                            "mData":"dateTo",
                            "sTitle": "dateTo"
                        },{
                            "mData":"amount",
                            "sTitle": "amount"
                        },{
                            "mData":"amountType",
                            "sTitle": "amountType"
                        },{
                            "mData":"amountPeriod",
                            "sTitle": "amountPeriod"
                        },{
                            "mData":"authorizationPercent",
                            "sTitle": "authorizationPercent"
                        },{
                            "mData":"ative",
                            "sTitle": "ative"
                        }
                    ]
                });
            }
        })
    });

    //GET Agreements from DB
    $("#button2").click(function(){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: 'http://localhost:8081/eik_war_exploded/v1/agreement/agreements',
            success: function(data){
                let jsonArray = JSON.parse(JSON.stringify(data));

                if (  $.fn.DataTable.isDataTable( '#dataTable' ) ) {
                    // $('#dataTable').DataTable().clear().destroy();
                    $('#dataTable').dataTable().fnClearTable();
                    $('#dataTable').dataTable().fnDestroy();
                }

                $('.content-container').empty();
                $('.content-container').append(" <table id=\"dataTable\"></table>")

                $('#dataTable').dataTable({
                    "aaData": jsonArray,
                    "aoColumns":[
                        {
                            "mData":"agreementId",
                            "sTitle": "agreementId"
                        },{
                            "mData":"orderNumber",
                            "sTitle": "orderNumber"
                        },{
                            "mData":"system",
                            "sTitle": "system"
                        },{
                            "mData":"request",
                            "sTitle": "request"
                        },{
                            "mData":"dateFrom",
                            "sTitle": "dateFrom"
                        },{
                            "mData":"dateTo",
                            "sTitle": "dateTo"
                        },{
                            "mData":"amount",
                            "sTitle": "amount"
                        },{
                            "mData":"amountType",
                            "sTitle": "amountType"
                        },{
                            "mData":"amountPeriod",
                            "sTitle": "amountPeriod"
                        },{
                            "mData":"authorizationPercent",
                            "sTitle": "authorizationPercent"
                        },{
                            "mData":"ative",
                            "sTitle": "ative"
                        }
                    ]
                });
            }
        })
    });

    //Get Systems from DB
    $("#button3").click(function () {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: 'http://localhost:8081/eik_war_exploded/v1/system/getSystems',
            success: function(data){
                let jsonArraySyst = JSON.parse(JSON.stringify(data));

                if (  $.fn.DataTable.isDataTable( '#dataTable2' ) ) {
                    // $('#dataTable').DataTable().clear().destroy();
                    $('#dataTable2').dataTable().fnClearTable();
                    $('#dataTable2').dataTable().fnDestroy();
                }

                $('.content-container').empty();
                $('.content-container').append(" <table id=\"dataTable2\"></table>")

                $('#dataTable2').dataTable({
                    "aaData": jsonArraySyst,
                    "aoColumns":[
                        {
                            "mData":"systemId",
                            "sTitle": "systemId"
                        },{
                            "mData":"nameOfTheSystem",
                            "sTitle": "nameOfTheSystem"
                        },{
                            "mData":"systemDescription",
                            "sTitle": "systemDescription"
                        },{
                            "mData":"systemTechnologyDesc",
                            "sTitle": "systemTechnologyDesc"
                        },{
                            "mData":"systemOwner",
                            "sTitle": "systemOwner"
                        }
                    ]
                });
            }
        })
    })

    //App info
    $('#button4').click(function () {
        $('.content-container').empty();
        $('.content-container').append(" <div class=\"box\">" +
            "<p>Adam Sobieraj</p>"+
            "<p>Data wykonania 14.03.2020</p>"+
            "<p>pozdarawiam !</p>"+
            "</div>")

    })

    //GET CSV
    $("#button5").click(function(){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: 'http://localhost:8081/eik_war_exploded/v1/agreement/readcsv',
            success: function(data){
                let jsonArray = JSON.parse(JSON.stringify(data));

                if (  $.fn.DataTable.isDataTable( '#dataTable4' ) ) {
                    $('#dataTable4').dataTable().fnClearTable();
                    $('#dataTable4').dataTable().fnDestroy();
                }

                $('.content-container').empty();
                $('.content-container').append(" <table id=\"dataTable4\"></table>")

                $('#dataTable4').dataTable({
                    "aaData": jsonArray,
                    "aoColumns":[
                        {
                            "mData":"agreementId",
                            "sTitle": "agreementId"
                        },{
                            "mData":"orderNumber",
                            "sTitle": "orderNumber"
                        },{
                            "mData":"system",
                            "sTitle": "system"
                        },{
                            "mData":"request",
                            "sTitle": "request"
                        },{
                            "mData":"dateFrom",
                            "sTitle": "dateFrom"
                        },{
                            "mData":"dateTo",
                            "sTitle": "dateTo"
                        },{
                            "mData":"amount",
                            "sTitle": "amount"
                        },{
                            "mData":"amountType",
                            "sTitle": "amountType"
                        },{
                            "mData":"amountPeriod",
                            "sTitle": "amountPeriod"
                        },{
                            "mData":"authorizationPercent",
                            "sTitle": "authorizationPercent"
                        },{
                            "mData":"ative",
                            "sTitle": "ative"
                        }
                    ]
                });
            },
            complete: function(xhr, statusText){

                if (xhr.status == 200){
                    alert("Import sucess")
                }else{
                    alert("File not found");
                }
            }
        })
    });

    //GET save
    $("#button6").click(function(){
        $.ajax({
            type: "GET",
            data: {},
            url: 'http://localhost:8081/eik_war_exploded/v1/agreement/writecsvdob',
            complete: function(data){
                alert(data.responseText);
            }

        })
    });

});

