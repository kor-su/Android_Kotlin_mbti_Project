var btt = document.getElementById("but1");
var btt1 = document.getElementById("but2"),
docEl= document.documentElement,
offset,
scrollPos,
docHeight;

var BgColor = document.body;
var fontColor1 = document.documentElement;

function TurnBlack(){
    BgColor.style.backgroundColor = "#2f2f2f";
    fontColor1.style.color = "#ffffff";
}
function TurnWhite(){
    BgColor.style.backgroundColor = "#ffffff";
    fontColor1.style.color = "#2f2f2f";
}

let white = false;

function handleToTOp(event){
    event.preventDefault();
    scrollToTop();
}

function scrollToTop(){
var scrollInterval = setInterval(function(){
    if(scrollPos != 0){
        window.scrollBy(0,-55);
    }else{
        clearInterval(scrollInterval);
    }
},5);
}

function handleChangeColor(event){
    if(white == true){
        white = false;
        but2.innerText = "WHITE MODE";
        TurnBlack();
    }else{
        white = true;
        but2.innerText = "DARK MODE"; 
        TurnWhite();
    }
}

docHeight = Math.max(docEl.scrollHeight, docEl.offsetHeight);
if(docHeight != 'undefined'){
    offset = docHeight / 4;
}


window.addEventListener('scroll', function(){
   scrollPos = docEl.scrollTop;
   console.log(scrollPos);

   btt.className = (scrollPos > offset) ? "visible" : '';
});

btt.addEventListener('click', handleToTOp);
btt1.addEventListener('click', handleChangeColor);