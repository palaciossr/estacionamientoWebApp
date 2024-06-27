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

$(document).ready(function () {
    // Manejar el clic en el botón de editar auto
    $('.btnEditarAuto').on('click', function () {
        var matriculaAuto = $(this).data('matricula');

        // Llamar al backend para obtener los datos del auto por matrícula
        $.ajax({
            url: '/autos/' + matriculaAuto,
            type: 'GET',
            success: function (auto) {
                // Poblar el modal con los datos del auto
                $('#matricula').val(auto.matricula);
                $('#marca').val(auto.marca);
                $('#modelo').val(auto.modelo);
                $('#color').val(auto.color);

                // Cambiar título y acción del botón
                $('#modalAgregarAutoLabel').text('Editar Auto');
                $('#btnGuardarAuto').text('Actualizar').attr('id', 'btnActualizarAuto');

                // Mostrar el modal de edición
                $('#exampleModal').modal('show');
            },
            error: function (error) {
                console.error('Error al obtener los datos del auto', error);
            }
        });
    });

    // Manejar el clic en el botón de actualizar auto
    $(document).on('click', '#btnActualizarAuto', function () {
        var autoData = {
            matricula: $('#matricula').val(),
            marca: $('#marca').val(),
            modelo: $('#modelo').val(),
            color: $('#color').val()
        };

        // Llamar al backend para actualizar los datos del auto
        $.ajax({
            url: '/autos/editar',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(autoData),
            success: function (response) {
                console.log('Auto actualizado con éxito', response);
                $('#exampleModal').modal('hide');
                location.reload(); // Otra forma de actualizar la vista
            },
            error: function (error) {
                console.error('Error al actualizar el auto', error);
            }
        });
    });
});