$(document).ready(function() {
	
//	 $("#greet").click(function(event) {
//	        event.preventDefault();
//	        ajaxGet();
//	      });
    $.ajax({
        url: "http://localhost:8080/greeting"
    }).then(function(data, status, jqxhr) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
       
       console.log(jqxhr);
    });
});