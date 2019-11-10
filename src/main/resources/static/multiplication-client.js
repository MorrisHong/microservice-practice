function updateMultiplication() {
    $.ajax({
        url: "http://localhost:8080/multiplications/random"
    }).then(function(data) {
        console.log(data);
        //폼비우기.
        $("#attempt-form").find("input[name='result-attempt']").val("");
        $("#attempt-form").find("input[name='user-alias']").val("");

        $('.multiplication-a').text(data.factorA);
        $('.multiplication-b').text(data.factorB);
    })
}

$(document).ready(function() {
   updateMultiplication();

   $('#attempt-form').submit(function (event) {
       //폼 기본 제출막기
       event.preventDefault();

       //페이지에서 값 가져오기.
       var a = $('.multiplication-a').text();
       var b = $('.multiplication-b').text();
       var $form = $(this),
           attempt = $form.find("input[name='result-attempt']").val(),
           userAlias = $form.find("input[name='user-alias']").val();

       //API에 맞게 데이터를 조립하기.
       var data = {
           user: {
               alias: userAlias
           },
           multiplication: {
               factorA: a,
               factorB: b
           },
           resultAttempt : attempt
       }

       //POST를 이용해 데이터보내기.
       $.ajax({
           url: '/results',
           type: 'POST',
           data: JSON.stringify(data),
           contentType: "application/json;charset=UTF-8",
           dataType:"json",
           success: function(result) {
               if(result.correct) {
                   $('.result-message').empty().append("정답입니다.")
               } else {
                   $('.result-message').empty().append("오답입니다.")
               }
           }
       });

       updateMultiplication();
   })
});