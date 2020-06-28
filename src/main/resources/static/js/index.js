var host = "http://localhost:8080/robo";

function answerOfYourQuestion(){
var question=document.getElementById("textMessage").value;
if(question!=""){
console.log(question)
$('#textMessage').val('');
 $('.maindiv').empty();
$.ajax({
    url: host + '/ai/contains/'+question,
    type: 'GET',
    success: function(data) {
    console.log(data["answer"]);
    $('.maindiv').append('<div class="container"><img src="/images/user.png" alt="Avatar" style="width:100%;"><p>'+question+'</p><span class="time-right"></span></div><div class="container darker"><img src="/images/robot.png" alt="Avatar" class="right" style="width:100%;"><p>'+data["answer"]+'</p><span class="time-left"></span></div>');
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