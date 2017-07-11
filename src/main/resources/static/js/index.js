/**
 * Created by Yuanjp on 2017/6/16 0016.
 */
var url="localhost:8083/blogyun/search";
function  search () {
    $.ajax({
        type: "GET",
        url: url+"/"+q,
        data: start,
        dataType: "json",
        async: true,
        success: function (data) {
            alert(data);
        }
    });
}