var destin;
var date = "b";
var ship ="c";

$('#destin-list a').on('click', function(){
    destin = ($(this).text());

});

$('#date-list a').on('click', function(){
    date= ($(this).text());
});

$('#ship-list a').on('click', function(){
    ship= ($(this).text());
});





$("#fooo").click(function(event){
    alert("haiiii"+destin+date+ship);

       event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/bin/check",
            data: { dest: destin, date: date, ship:ship }, 
            success: function(data) {
                console.log("got");
                alert("Name :"+ data.place + "  Value: "+data.day + "  Description: "+data.shipname);


        	}
        });

});


