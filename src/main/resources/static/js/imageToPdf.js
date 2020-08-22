var getImageFromUrl = function(url, callback) {
    var img = new Image();

    img.onError = function() {
        alert('Cannot load image: "'+url+'"');
    };
    img.onload = function() {
        callback(img);
    };
    img.src = url;
}


var createPDF = function(imgData) {
    var doc = new jsPDF();



    doc.addImage(imgData, 'JPEG', 10, 10, 50, 50, 'monkey');
    doc.addImage('monkey', 70, 10, 100, 120); // use the cached 'monkey' image, JPEG is optional regardless



    doc.output('datauri');
}

getImageFromUrl('thinking-monkey.jpg', createPDF);