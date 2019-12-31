  

function submit(){

        $.ajax({
            type : "GET",
            url : '/bin/example.json?q=testing',

             dataType: "json",
            success : function(data) {
                console.log(data);
    
                alert(JSON.stringify(data));


                }
        

        });

}