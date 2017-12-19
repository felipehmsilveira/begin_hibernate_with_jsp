// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
	  "language":{
		  "search": "Buscar",
		  "lengthMenu": 'Mostrar <select>'+
			 '<option value="10">10</option>'+
			 '<option value="20">20</option>'+
			 '<option value="30">30</option>'+
			 '<option value="40">40</option>'+
			 '<option value="50">50</option>'+
			 '<option value="-1">All</option>'+
			 '</select> qtd',
			 "info": "Paginas mostradas _PAGE_ até _PAGES_"
	  }
  });
});
