function mostrarLoader(callback) {
    if (!$(".loader").is(":visible")) {
        if (callback != undefined)
            $(".loader").fadeIn(300, callback);
        else
            $(".loader").fadeIn(300);
    }
}

function ocultarLoader(callback) {
    if ($(".loader").is(":visible")) {
        if (callback != undefined)
            $(".loader").fadeOut(300, callback);
        else
            $(".loader").fadeOut(300);
    }
}