var tabla;

//funcion al cargar la página
$(document).ready(function () {
    $("#id_div_geografica").select2();
    $("#id_centro_trabajo").select2();
    mostrarTabla();
});

//Validacion de campos vacios
$("#btnAgregarBolsaTrab").on("click", function (event) {
    // event.preventDefault();
    let rfc = document.getElementById('rfc').value.length;
    let nombre = document.getElementById('nombre').value;
    let apellidoPat = document.getElementById('apellidoPat').value;
    let apellidoMat = document.getElementById('apellidoMat').value;
    let id_div_geografica = document.getElementById('id_div_geografica').value;
    let id_centro_trabajo = document.getElementById('id_centro_trabajo').value;


    if (rfc == 0 || (rfc < 12 && rfc > 13)) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El RFC esta vacio");
        return false;
    }

    if (nombre == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El nombre esta vacio");
        return false;
    }

    if (apellidoPat == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El apellido paterno esta vacio");
        return false;
    }

    if (apellidoMat == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El apellido materno esta vacio");
        return false;
    }

    if (id_div_geografica == 0 || $("#id_div_geografica").val() == 00) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("No ha seleccionado ninguna división geográfica");
        return false;
    }

    if (id_centro_trabajo == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("No ha seleccionado ningun centro de trabajo");
        return false;
    }
    if (rfc && nombre && apellidoPat && apellidoMat && id_div_geografica && id_centro_trabajo) {
        // $("#btnAgregarBolsaTrab").attr('enabled','enabled');
        // mostrarTabla();
    }
    // console.log("Datos enviados:" + rfc + " ," + nombre + " ," + apellidoPat + " ," + apellidoMat + " ," + id_div_geografica + " ," + id_centro_trabajo);

});

function mostrarTabla() {
    $('#tbl_bolsaTrabajo').DataTable({
        pageLength: 1,
        lengthMenu: [[3, 10, 25, 50, -1], [3, 10, 25, 50, "All"]],
        sort: true,
        ajax: {
            url: '/rest_bolsaTrabajo/registros',
            dataSrc: ''
        },
        "order": [
            [1, "desc"]
        ],
        // buttons: [
        //     {
        //         extend: 'pdfHtml5',
        //         text: 'Exportar a PDF',
        //         titleAttr: 'Exportar a PDF',
        //         className: 'btn btn-danger',
        //         title: 'Bolsa de trabajo guardias externos',
        //         exportOptions: {
        //             columns: [2, 3, 4, 5,6,7]
        //         }
        //     }
        // ],

        columnDefs: [
           
            {
                targets: 0,
                data: "id",
                orderable: false,
                render:
                    function (data) {
                        return '<div class="btn-toolbar" id="eliminar" role="toolbar"><a href="/guardias/eliminar/' + data + '" class="btn btn-danger" onclick="return confirm("¿Estas seguro?")"><i class="fa fa-trash"></i></a>';
                        // return '<div class="btn-toolbar" id="eliminar" role="toolbar"><a  sec:authorize="hasAnyAuthority("'+"ROOT"+'")" href="/guardias/eliminar/' + data + '" class="btn btn-danger" onclick="return confirm("¿Estas seguro?")"><i class="fa fa-trash"></i></a>';
                    }
            },
            {
                targets: 1,
                data: "id",
                orderable: false,
                render:
                    function (data) {
                        return '<div class="btn-toolbar" id="editar" role="toolbar"><a href="/guardias/editar/' + data + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
                    }

            },
            {
                targets: 2,
                data: "rfc"

            },
            {
                targets: 3,
                data: "nombre",
                searchable: false
            },
            {
                targets: 4,
                data: "apellidoPat",
                searchable: false
            },
            {
                targets: 5,
                data: "apellidoMat",
                searchable: false
            },
            {
                targets: 6,
                data: "id_div_geografica",
                searchable: false
            },
            {
                targets: 7,
                data: "id_centro_trabajo",
                "searchable": false
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
                "sFirst": "Primero",
                "sLast": "Ultimo",
                "sNext": " Siguiente",
                "sPrevious": "Anterior "

            },
            searchPlaceholder: "RFC"
        }
    });
}