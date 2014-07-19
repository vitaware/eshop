$(document).ready(function() { 
	//点击导航菜单改变样式
	var removeClas = $('ul li.active'); 
	$('ul li').bind('click', function(){ 
		removeClas.removeClass('active'); 
		$(this).addClass('active'); 
		removeClas = $(this); 
	}); 
	
	
}); 
