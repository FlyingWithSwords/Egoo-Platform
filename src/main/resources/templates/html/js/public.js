
var typeview = location.hash.substring(1);
var username = localStorage.getItem('username');
var types = new Map();

layui.use(['form','flow','element'], function () {
    var $ = layui.jquery,
        flow = layui.flow;

    $.ajaxSetup({async: false});
    $.ajax({
        url: '/api/upload.json',
        success: function (data) {
            if (data.code == 1) {
                if (username != null) {
                    document.getElementById("login").innerText = username;
                    document.getElementById("login").href = '/index.html';
                    document.getElementById("register").style.display = 'none';
                    document.getElementById("loginout").style.display = 'inline-block';
                }
            }
            else{
                loginOut();
            }
            return false;
        }
    });

    $.ajax({
        url: '/commodity/queryCommodityAll',
        success: function (data) {
            var datas = data.data;
            if (data.code == 0) {
                for (var i = 0; i < datas.length; i++) {
                    var ts = datas[i].typee.split(',');
                    for (var j = 0; j < ts.length; j++) {
                        types.set(ts[j], types.get(ts[j]) == undefined ? 1 : types.get(ts[j]) + 1);
                    }
                }
                var typehtml = '<dd class="layui-col-md4"><a href="javascript:;" onclick="setType(\'\')">全部</a></dd>';
                types.forEach(function (v, k) {
                    typehtml += '<dd class="layui-col-md4"><a href="javascript:;" onclick="setType(\'' + k + '\')">' + k + '\t(' + v + ')</a></dd>';
                });
                $('.typee').html(typehtml);
            }
        }
    });

    window.setType = function (t) {
        location.hash = t;
        if(location.href.includes('index.html')) {
            $('#search').attr('placeholder', '搜索' + t + '商品');
            onSearch(1, 9, '', t);
        }
        else
            location.href = 'index.html#'+t;
    }

    function loginOut() {
        localStorage.clear();
    }
});

//获取当前时间 yyyy-MM-dd HH:mm:ss
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var second = date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (hours >= 0 && hours <= 9) {
        hours = "0" + hours;
    }
    if (minutes >= 0 && minutes <= 9) {
        minutes = "0" + minutes;
    }
    if (second >= 0 && second <= 9) {
        second = "0" + second;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " + hours + seperator2 + minutes + seperator2 + second;
    return currentdate;
}

function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}