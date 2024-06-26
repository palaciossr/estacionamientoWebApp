$(document).ready(function () {
	$('#btnGuardarAuto').on('click', function (event) {
		event.preventDefault();
		var autoData = {
			matricula: $('#matricula').val(),
			marca: $('#marca').val(),
			modelo: $('#modelo').val(),
			color: $('#color').val()
		};

		$.ajax({
			url: '/autos/guardar',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(autoData),
			success: function (response) {
				console.log('Auto guardado con éxito', response);
				$('#exampleModal').modal('hide');
				location.reload();
			},
			error: function (error) {
				console.error('Hubo un error inesperado, intente más tarde', error);
			}
		});
	});
});