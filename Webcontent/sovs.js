
function userLogin2() {
    alert("jeg er her");
    event.preventDefault();
    var data = $('#ingredientform').serializeJSON();
    alert("en mere!");
    $.ajax({
        url: 'rest/helloService',
        method: 'POST',

        contentType: "application/json", // det visender er json
        data: data,
        success: function (data) {
            alert(JSON.stringify(data));
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
            alert(textStatus);
            alert(errorThrown);

        }
    });
}
