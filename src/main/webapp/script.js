$(document).ready(function(){
    var counter = 1;
    for (let li of list.querySelectorAll('.span')) {
        let span = document.createElement('span');
        span.classList.add('show');
        li.prepend(span);
        span.append(span.nextSibling);
        counter += 1;
    }
    var form = document.querySelector("form");
    form.addEventListener("submit",function(event){
        event.preventDefault();
        console.log(form.elements.number.value, form.elements.value.value);
        if(Number(form.elements.number.value) >= counter || Number(form.elements.number.value) < 0
            || !Number.isInteger(Number(form.elements.number.value)
                || form.elements.number.value.includes(" ") || form.elements.number.value == "") ){
            alert("Bad category");
        }else if(form.elements.value.value.length > 10 || form.elements.value.value.length <= 0){
            alert("Length of field 0 or more than 10");
        } else {
            var x = new XMLHttpRequest();
            x.open("GET", "/AddInList?number=" + form.elements.number.value + "&value=" + form.elements.value.value);
            x.send(null);
            form.reset();
            setTimeout(function(){
                location.reload();
            }, 50);
        }
    });
    list.onclick = function(event) {
        if (event.target.tagName != 'SPAN') return;

        let childrenList = event.target.parentNode.querySelector('ul');
        if (!childrenList) return;
        childrenList.hidden = !childrenList.hidden;

        if (childrenList.hidden) {
            event.target.classList.add('hide');
            event.target.classList.remove('show');
        }
        else {
            event.target.classList.add('show');
            event.target.classList.remove('hide');
        }
    }
});