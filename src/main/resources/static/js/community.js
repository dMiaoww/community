function post(){
     var questionId = $("#question_id").val();
     var commentContent = $("#comment_content").val();
     $.ajax({
       type: "POST",
       url: "/comment",
       contentType: "application/json",
       data: JSON.stringify({
         "parentId":questionId,
         "content":commentContent,
         "type":1
       }),
       success: function (response) {
         if (response.code == 200) {
             $("#comment_content").val("");
             window.location.reload();
         } else {
             if (response.code == 2000) {
                 var isAccepted = confirm(response.message);
                 if (isAccepted) {
                     window.open("https://github.com/login/oauth/authorize?client_id=ed0f78a8629a58dc8dab&redirect_uri=http://localhost:8080/callback&scope=user&state=1");
                     window.localStorage.setItem("closable", true);
                 }
             } else {
                 alert(response.message);
             }
         }
       },
       dataType: "json"
     });
 }

 function like(){
     var commentID = $("#comment_id").val();
     $.ajax({
       type: "POST",
       url: "/like",
       contentType: "application/json",
       data: JSON.stringify({
         "commentID":commentID,
       }),
       success: function (response) {
         if (response.code == 200) {
             //todo:更新图标样式
             window.location.reload();
         } else {
             if (response.code == 2000) {
                 var isAccepted = confirm(response.message);
                 if (isAccepted) {
                     window.open("https://github.com/login/oauth/authorize?client_id=ed0f78a8629a58dc8dab&redirect_uri=http://localhost:8080/callback&scope=user&state=1");
                     window.localStorage.setItem("closable", true);
                 }
             } else {
                 alert(response.message);
             }
         }
       },
       dataType: "json"
     });
 }