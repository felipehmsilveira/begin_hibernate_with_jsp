/* Mascara de Input */

var options = {
    onKeyPress: function (cpf, ev, el, op) {
        var masks = ['000.000.000-000', '00.000.000/0000-00'],
            mask = (cpf.length > 14) ? masks[1] : masks[0];
        el.mask(mask, op);
    }
}

$(document).ready(function() {
	$(".select").select2();
	
	$("#cnpj").mask('00.000.000/0000-00');
	$("#cpf").mask("000.000.000-000", options);
	$("#telefone").mask("(00) 00000-0000");
	$("#cep").mask("00000-000");
	$("#valorUnitario").maskMoney({ 
		'alias': 'numeric',
        'groupSeparator': ',',
        'autoGroup': true,
        'digits': 2,
        'radixPoint': ".",
        'digitsOptional': false,
        'allowMinus': false,
        'thousands' : '',
        'prefix': '',
        'placeholder': ''
	});
	
})