$(function(){
    init("1");
});

//init
function init(pageNow){
    $('#table_data').find('tr').remove();
    $.ajax({
        url: "/xszq/initData2",
        async: false,
        type: 'get',
        data:{"pageNow":pageNow},
        dataType: 'json',
        timeout: 1000,
        cache: false,
        beforeSend:function(XMLHttpRequest){
            $('.htmlBody1').show();  //之前
            $('.htmlBody2').hide();  //之前
        },
        success: function (req) {
            if(req.success){
                $(req.data).each(function(index,e){
                    var h = "<tr><td>"+(index+1)+"</td><td>"+e.strDate+"</td><td>"+e.endDate+"</td>"
                    +"<td>"
                    +"<button type=\"button\" class=\"btn btn-sm btn-primary\" onclick=\"setDb('"+e.uuid+"')\">自动设置</button>"
                    +"&nbsp;<button type=\"button\" class=\"btn btn-sm btn-primary\" onclick=\"window.parent.cli(this)\" data-target=\"/xsdbry/sdsz?id="+e.uuid+"\">手动设置</button>"
                    +"</td></tr>";
                    $('#table_data').append(h);
                });
//                分页
                $('#db_page_last').attr("onclick","init("+req.code+")");
                $('.pageNow').find("font").text(pageNow);
                $('.pageTwo').remove();
                var page_last = '';
                if((Number(pageNow)+1) <= Number(req.code)){
                    page_last += "<li class=\"footable-page pageTwo\" onclick=\"init("+(Number(pageNow)+1)+")\">"
                     +"<a><font style=\"vertical-align: inherit;\">"
                     +(Number(pageNow)+1)+"</font></a></li>";
                }
                if((Number(pageNow)+2) <= Number(req.code)){
                    page_last += "<li class=\"footable-page pageTwo\" onclick=\"init("+(Number(pageNow)+2)+")\">"
                     +"<a><font style=\"vertical-align: inherit;\">"
                     +(Number(pageNow)+2)+"</font></a></li>";
                }
                if((Number(pageNow)+3) <= Number(req.code)){
                    page_last += "<li class=\"footable-page pageTwo\" onclick=\"init("+(Number(pageNow)+3)+")\">"
                     +"<a><font style=\"vertical-align: inherit;\">"
                     +(Number(pageNow)+3)+"</font></a></li>";
                }
                $('.pageNow').after(page_last);

                $('.pageOne').remove();
                var page_first = '';
                if((Number(pageNow)-3) > 0){
                    page_first = "<li class=\"footable-page pageOne\" onclick=\"init("+(Number(pageNow)-3)+")\">"
                    +"<a><font style=\"vertical-align: inherit;\">"
                    +(Number(pageNow)-3)+"</font></a></li>";
                }
                if((Number(pageNow)-2) > 0){
                    page_first += "<li class=\"footable-page pageOne\" onclick=\"init("+(Number(pageNow)-2)+")\">"
                                        +"<a><font style=\"vertical-align: inherit;\">"
                                        +(Number(pageNow)-2)+"</font></a></li>";
                }
                if((Number(pageNow)-1) > 0){
                    page_first += "<li class=\"footable-page pageOne\" onclick=\"init("+(Number(pageNow)-1)+")\">"
                                        +"<a><font style=\"vertical-align: inherit;\">"
                                        +(Number(pageNow)-1)+"</font></a></li>";
                }
                $('.pageNow').before(page_first);
            }
            $('.htmlBody1').hide();
            $('.htmlBody2').show();
        },
        error: erryFunction
    });
}

//setDb
function setDb(obj){
    $.ajax({
        url: "/xsdbry/add",
        async: false,
        type: 'post',
        data:{"id":obj},
        dataType: 'json',
        timeout: 1000,
        cache: false,
        beforeSend:function(XMLHttpRequest){
            $('.htmlBody1').show();  //之前
            $('.htmlBody2').hide();  //之前
        },
        success: function (req) {
            if(req.success){
                alert('成功');
                $('#zqdbrysz').click();
            }else{
                if(req.message != null){
                    alert(req.message);
                }else
                    alert("失败");
            }
            $('.htmlBody1').hide();
            $('.htmlBody2').show();
        },
        error: erryFunction
    });
}

//    error
function erryFunction() {
    $('.htmlBody1').hide();
    $('.htmlBody2').show();
    alert("错误!");
}