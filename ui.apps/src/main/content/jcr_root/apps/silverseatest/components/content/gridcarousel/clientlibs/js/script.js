$(".carousel").each(function () { 
    //randomize the slider on page load
    //Find .item within the current .carousel
    var $item = $(this).find('.item');
    $item.eq(0).addClass('active'); 

    //Find .item within the current .carousel
    var $numberofSlides = $(this).find('.item').length;
    var $currentSlide = Math.floor((Math.random() * $numberofSlides));

    //Find .carousel-indicators li within the current .carousel
    $(this).find('.carousel-indicators li').each(function(){
        var $slideValue = $(this).attr('data-slide-to'); 
        if($currentSlide == $slideValue) {
            $(this).addClass('active');
            $item.eq($slideValue).addClass('active');
        } else {
            $(this).removeClass('active');
            $item.eq($slideValue).removeClass('active');
        }
    }); 
}); 