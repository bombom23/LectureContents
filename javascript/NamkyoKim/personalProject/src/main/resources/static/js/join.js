    $(document).ready(function() {

        var formObj = $("#member");

        $("#btnMember").on("click", function() {
            var passwordObj = $("#password");

            
            formObj.attr("action", "join");
            formObj.attr("method", "post");
            formObj.submit();
        });
    });
