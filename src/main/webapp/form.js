$(document).ready(function(){
var form = document.querySelector("form");
form.addEventListener("submit",function(event){
    console.log(form.elements.number.value, form.elements.value.value);
    event.preventDefault();
    });
});