var host = "http://localhost:8080/robo";

function voiceRecognized(){
var recognizer = new webkitSpeechRecognition();
recognizer.lang = "en";
recognizer.onresult = function(event) {
    if (event.results.length > 0) {
        var result = event.results[event.results.length-1];
        if(result.isFinal) {
            console.log(result[0].transcript);
        }
    }  
};
recognizer.start();
}

function answerOfYourQuestion(){
var question=document.getElementById("textMessage").value;
if(question!=""){
$('#textMessage').val('');
 $('.maindiv').empty();
$.ajax({
    url: host + '/ai/contains/'+question,
    type: 'GET',
    success: function(data) {
    var text = data["answer"]
    responsiveVoice.speak(text);
    $('.maindiv').append('<div class="container"><img src="/images/user.png" alt="Avatar" style="width:100%;"><p>'+question+'</p><span class="time-right"></span></div><div class="container darker" id="voice"><img src="/images/robot.png" alt="Avatar" class="right" style="width:100%;"><p>'+data["answer"]+'</p><span class="time-left"></span></div>');
    },
	error: function(error){
	console.log(error);
	}
});     
}
else{
alert("you forgot to ask question");
}
}