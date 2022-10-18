var tabla;

//funcion al cargar la página
$(document).ready(function () {
    // alert("funcionando");
    mostrarTabla();
    // autocompletar();
});

$("#btnBuscarFasesFecha").on("click", function (event) {
    // event.preventDefault();
  
    let fechas_paga = document.getElementById('fechas_paga').value;
    // alert(fechas_paga);

    if (fechas_paga == 0 || $("#fechas_paga").val() == 00) {
        // $('.toast-warning').toast('show');
        // $('.toast-body').text("No ha seleccionado ninguna fecha de pago");
        alert("No ha seleccionado ninguna fecha de pago")
        return false;
    }

    var fecha_paga = { "fec_pago": $("#fechas_paga").val() };
    console.log(fecha_paga);

    $.ajax({
        type: "POST",
        url: "/rest_procesoNomina/buscarPorFecha?" + $.param(fecha_paga),
        data: { fec_pago: $("#fechas_paga").val() },
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            console.log(data);
            // if (data.empleado === null) {
            //     //alert("El número de empleado no está autorizado.");
            //     $('.toast-error .toast-body').html('El empleado no se encuentra registrado en la base de datos.')
            //     $('.toast-error').toast('show')
            //     $("#btnAgregarGuardia").attr('disabled', 'disabled');
            //     return 0;
            // } else {
            //     $("#hdnTipoCT").val(data.empleado.id_tipo_ct);
            //     $("#hdnTabulador").val(data.empleado.id_tipo_tabulador);
            //     $("#hdnZona").val(data.empleado.id_zona);
            //     $("#nombresInt").text(data.empleado.nombre);
            //     $("#apellidosInt").text(data.empleado.apellido_1 + ' ' + data.empleado.apellido_2);
            //     $("#rfcInt").text(data.empleado.id_legal);
            //     $("#adscripcionInt").text(data.empleado.id_centro_trabajo + '-' + data.empleado.n_centro_trabajo);
            //     $("#servicioInt").text(data.empleado.id_clave_servicio + '-' + data.empleado.n_clave_servicio);
            //     $("#puestoInt").text(data.empleado.id_puesto_plaza + '-' + data.empleado.n_puesto_plaza);
            //     //$("#horarioInt").text(data.empleado.id_turno);
            //     $("#nivelInt").text(data.empleado.id_nivel + '/' + data.empleado.id_sub_nivel);
            //     $("#horasInt").text(data.empleado.id_tipo_jornada);
            //     if (data.esValido) {
            //         $('.toast-success .toast-body').html('El empleado cumple con las condiciones para registro de guardias.')
            //         $('.toast-success').toast('show')
            //         $("#btnAgregarGuardia").removeAttr('disabled');
            //         carga_lista_guardias();
            //         //alert("Las caracteristicas del puesto están autorizadas. No. de registro: " + data);
            //         return data;
            //     } else {
            //         //alert("El número de empleado no está autorizado.");
            //         $('.toast-error .toast-body').html('El empleado no cumple con las condiciones para registro de guardias.')
            //         $('.toast-error').toast('show')
            //         // $("#nombresInt").text('');
            //         // $("#apellidosInt").text('');
            //         // $("#rfcInt").text('');
            //         // $("#adscripcionInt").text('');
            //         // $("#servicioInt").text('');
            //         // $("#puestoInt").text('');
            //         // $("#horarioInt").text('');
            //         // $("#nivelInt").text('');
            //         // $("#horasInt").text('');
            //         $("#btnAgregarGuardia").attr('disabled', 'disabled');
            //         return 0;
            //     }
            // }
        }
    });

    

});




function mostrarTabla() {
    $('#tbl_nomina').DataTable({
        pageLength: 10,
        lengthMenu: [[ 5, 8, 10, -1], [ 5, 8, 10, "Todos"]],
        sort: true,
        ajax: {
            url: '/rest_procesoNomina/fases',
            dataSrc: ''
        },
        order: [
            [0 , 1, "desc"]
        ],

        columnDefs: [
            {
                targets: 0,
                data: "fec_Pago"

            },
            {
                targets: 1,
                data: "actividad"

            },
            {
                targets: 2,
                data: "fec_Ini",
                searchable: false
            },
            {
                targets: 3,
                data: "fec_Fin",
                searchable: false
            },
            {
                targets: 4,
                data: "validado",
                // searchable: true,
                render:
                function (data) {
                    if(data == false){
                        return '<span class="badge badge-danger text-wrap">No Validado</span>';
                    }else{
                        return '<span class="badge badge-success text-wrap">Validado</span>';
                    }
                }
            },
            {
                targets: 5,
                data: "fec_Pago",
                orderable: false,
                bSort: false,
                ordering: false,
                render:
                    function (data) {
                        return '<div class="btn-toolbar" id="editar" role="toolbar"><a href="/nomina/actValidacion/' + data + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
                        // return '<div class="btn-toolbar" id="editar" role="toolbar"><a class="btn btn-warning" onclick="return editar('+data+')"><i class="fa fa-edit"></i></a>';
                    }

            },
            
        ],

        language: {
            lengthMenu: "Mostrar _MENU_ resultados",
            info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            zeroRecords: "No se encontraron resultados",
            sSearch: "Buscar: ",
            infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            infoFiltered: "(Filtrado de un total de _MAX_ registros)",
            sProccessing: "Procesando ...",
            oPaginate: {
                sFirst: "Primero",
                sLast: "Ultimo",
                sNext: " Siguiente",
                sPrevious: "Anterior"

            },
            searchPlaceholder: "Buscar"
        }
    });
}

// function eliminar(id) {

//     if (confirm("Seguro que quieres eliminar el siguiente pastel?")) {
//         window.location = ("/guardias/eliminar/" + id);
//         alert("Borrado el usuario con id: " + id);
//     }

// }

// function editar(id) {

//     if (confirm("Seguro que quieres editar el siguiente pastel?")) {
//         window.location = ("/guardias/editar/" + id);
//         // alert("Borrado el usuario con id: " + id);
//     }

// }