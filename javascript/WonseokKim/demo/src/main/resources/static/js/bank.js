// 오늘 날자 정보
var now = new Date();
// 처음 만난 날자 정보
var firstDay = new Date("2021-06-28");
// 오늘 날자 정보를 컴퓨터가 계산하는 숫자 정보로 변환 (정확하게 ms 단위로 바꿈)
//var toNow = now.getTime();
// 처음 만난 날자를 컴퓨터가 계산하는 숫자 정보로 변환
//var toFirst = firstDay.getTime();
// 오늘 날자 - 첫 만남
//var passedTime = toNow - toFirst;
// 다시 날자로 변환
// Math.round(반올림)임
//var passedDay = Math.round(passedTime / (24 * 60 * 60 * 1000));
var yearLater = new Date(firstDay.setFullYear(now.getFullYear()));

//document.querySelector('#accent').innerText = passedDay + "일";

calcDate(1);
calcDate(3);
calcDate(10);

function calcDate (year) {
    var future = year * (1000 * 60 * 60 * 24);
    var someday = new Date(future);

    var year = someday.getFullYear();
    //var month = someday.getMonth() + 1;
    //var date = someday.getDate();

    document.querySelector('#money' + year).innerText = year + "년";
    /*document.querySelector("#date" + days).innerText =
            year + "년 " + month + "월 " + date + "일";*/
}