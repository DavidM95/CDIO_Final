function EasyPeasyParallax() {
    scrollPos = $(this).scrollTop();
    $('.p1').css({
        'background-position' : '50% ' + (-scrollPos/4)+"px"
    });
    $('.p2').css({
        'background-position' : '50% ' + (-scrollPos/8)+"px"
    });
    $('.p3').css({
        'background-position' : '70% ' + (-scrollPos/16)+"px"
    });
    $('.parallax-text').css({
        'margin-top': (scrollPos/2)+"px",
        'opacity': 1-(scrollPos/230)
    });
}
$(document).ready(function(){
    $(window).scroll(function() {
        EasyPeasyParallax();
    });
});

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
function myFunction() {
    var x = document.getElementById("retbrugerform");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "block";
    }
}
