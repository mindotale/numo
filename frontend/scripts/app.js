$(".clear").click(function(){

  $('select option').prop('selected', false);
});

$.ajax({
  type: 'GET',
  url: ' /groups/{123}',
  success: function(result){
  }
});